import java.sql.*;

public class JDBC_Ex4_InsertTableUsingJDBCStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variables
		Connection connection = null;
		Statement statement = null;
		//Step 1: Loading or registering MySQL JDBC driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException cnfex) {
			System.out.println("Problem in loading MySQL JDBC driver");
			cnfex.printStackTrace();
		}
		//Step 2: Opening database connection
		try {
			//Step 2.A: Create and get connection using DriverManager
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/player_info?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			//Step 2.B: Creating JDBC statement
			statement = connection.createStatement();
			//create SQL query to insert new PLAYER info
			String sqlInsertQuery = "INSERT INTO PLAYER(NAME, AGE, MATCHES) VALUES ('Sachin Tendulkar', '43', '200')";
			//Step 2.C: Executing SQL to retrieve data into ResultSet
			int sqlQueryResult = statement.executeUpdate(sqlInsertQuery);
			//output of database creation
			System.out.println(sqlQueryResult + " PLAYER info inserted successfully");
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			//Step 3: Closing database connection
			try {
				if(null != connection) {
					//cleanup resources, once after processing
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
