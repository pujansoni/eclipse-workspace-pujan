import java.sql.*;

public class JDBC_Ex13_InsertRecordJDBCPreparedStatement {

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
			//create SQL query to create new table PLAYER
			String sqlInsertQuery = "INSERT INTO PLAYER (NAME, AGE, MATCHES) VALUES (?, ?, ?)";
			//Step 2.B: Creating JDBC PreparedStatement
			preparedStatement = connection.prepareStatement(sqlInsertQuery);
			//set values for PreparedStatement
			preparedStatement.setString(1, "Sachin Tendulkar"); //NAME
			preparedStatement.setInt(2, 43); //AGE
			preparedStatement.setInt(3, 200); //MATCHES
			//Step 2.C: Executing SQL & retrieve data into ResultSet
			int sqlQueryResult = preparedStatement.executeUpdate();
			//output of database creation
			System.out.println(sqlQueryResult + " PLAYER info inserted successfully");
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
