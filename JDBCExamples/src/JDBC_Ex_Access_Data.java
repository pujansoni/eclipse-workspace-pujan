import java.sql.*;

public class JDBC_Ex_Access_Data {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variables
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		//Step 1: Loading or registering MySQL JDBC driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException cnfex) {
			System.out.println("Problem in loading MySQL JDBC driver");
			cnfex.printStackTrace();
		}
		
		//Step 2: Opening database connection
		try {
			//Step 2.A: Create and get connection using DriverManager class
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/benchresources?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			//Step 2.B: Creating JDBC Statement
			statement = connection.createStatement();
			//Step 2.C: Executing SQL and retrieve data into ResultSet
			resultSet = statement.executeQuery("SELECT * FROM PLAYER");
			System.out.println("ID\tName\t\t\tAge\tMatches");
			System.out.println("==\t================\t===\t=======");
			//processing returned data and printing into console
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3) + "\t" + resultSet.getInt(4));
			}
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			//Step 3: Closing database connection
			try {
				if(null != connection) {
					//cleanup resources, once after processing
					resultSet.close();
					statement.close();
					//and then finally close connection
					connection.close();
				}
			} catch(SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}
	}

}
