import java.sql.*;

public class JDBC_Ex15_GettingSingleRecordJDBCPreparedStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variables
		Connection connection = null;
		PreparedStatement preparedStatement = null;
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
			//Step 2.A: Create and get connection using DriverManager
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/player_info?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			//create SQL query to fetch all player records
			String sqlSelectQuery = "SELECT * FROM PLAYER WHERE PLAYER_ID = ?";
			//Step 2.B: Creating JDBC PreparedStatement
			preparedStatement = connection.prepareStatement(sqlSelectQuery);
			//set values for PreparedStatement for respective ?
			preparedStatement.setInt(1, 1);
			//Step 2.C: Executing SQL & retrieve data into ResultSet
			resultSet = preparedStatement.executeQuery();
			System.out.println("ID\tName\t\t\tAge\tMatches");
			System.out.println("==\t====================\t===\t=======");
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
					resultSet.close();
					preparedStatement.close();
					connection.close();
				}
			} catch(SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}
	}

}
