/*
 * To handle JDBC transaction
 * a) Set auto commit mode to false so as to handle JDBC transaction
 * b) That's setAutoCommit(false);
 * c) commit/rollback as per program logic
 * d) commit(); -> for successful execution
 * e) rollback(); -> for failures
 */
import java.sql.*;

public class JDBC_Ex23_JDBCTransactionJDBCStatement {

	public static void main(String[] args) throws SQLException {
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
			//Start of JDBC transaction
			connection.setAutoCommit(false);
			//Step 2.B: Creating JDBC Statement
			statement = connection.createStatement();
			//Step 2.C: Execute both in  order
			//Insert query
			String sqlInsertQuery = "INSERT INTO PLAYER (NAME, AGE, MATCHES) VALUES ('Mattew Hayden', '44', '103)";
			//1st execute insert query
			statement.executeUpdate(sqlInsertQuery);
			//Update query this is written to throw ERROR
			String sqlUpdateQuery = "UPDATE PLAYER SET MATCHES = 'Stephen Rodger Waugh' WHERE PLAYER_ID = 11";
			statement.executeUpdate(sqlUpdateQuery);
			connection.commit();
			System.out.println("All DML operations are successful");
		} catch(SQLException sqlex) {
			//rollback, if any of the DML operation is failure
			connection.rollback();
			System.out.println("roll back done !!");
		} finally {
			//Step 3: Closing database connection
			try {
				if(null != connection) {
					statement.close();
					connection.close();
				}
			} catch(SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}
	}

}
