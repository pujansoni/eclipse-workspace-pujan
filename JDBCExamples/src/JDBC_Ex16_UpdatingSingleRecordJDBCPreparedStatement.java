import java.sql.*;

public class JDBC_Ex16_UpdatingSingleRecordJDBCPreparedStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variables
		Connection connection = null;
		PreparedStatement preparedStatement = null;
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
			String sqlUpdateQuery = "UPDATE PLAYER SET AGE = ? WHERE PLAYER_ID = ?";
			//Step 2.B: Creating JDBC PreparedStatement
			preparedStatement = connection.prepareStatement(sqlUpdateQuery);
			//set values for PreparedStatement for respective ?
			preparedStatement.setInt(1, 46); //AGE 
			preparedStatement.setInt(2, 1); //PLAYER_ID
			//Step 2.C: Executing SQL & retrieve data into ResultSet
			int sqlQueryResult = preparedStatement.executeUpdate();
			System.out.println(sqlQueryResult + " indicates PLAYER info updation is successful");
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			//Step 3: Closing database connection
			try {
				if(null != connection) {
					preparedStatement.close();
					connection.close();
				}
			} catch(SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}
	}

}
