/*
 * To handle JDBC transaction
 * a) Set auto commit mode to false so as to handle JDBC transaction
 * b) That's setAutoCommit(false);
 * c) commit/rollback as per program logic
 * d) commit(); -> for successful execution
 * e) rollback(); -> for failures
 */
import java.sql.*;

public class JDBC_Ex24_JDBCTransactionJDBCPreparedStatement {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException {
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
			//Start of JDBC transaction
			connection.setAutoCommit(false);
			//Insert query
			String sqlInsertQuery = "INSERT INTO PLAYER (NAME, AGE, MATCHES) VALUES (?, ?, ?)";
			//Step 2.B: Creating JDBC PreparedStatement
			preparedStatement = connection.prepareStatement(sqlInsertQuery);
			//set values
			preparedStatement.setString(1,  "Justin Langer");
			preparedStatement.setInt(2, 45);
			preparedStatement.setInt(3, 105);
			//Step 2.C: Execute
			preparedStatement.executeUpdate();
			//Update query, this is written to throw ERROR mismatch
			String sqlUpdateQuery = "UPDATE PLAYER SET MATCHES = ? WHERE PLAYER_ID = ?";
			//Step 2.B: Creating JDBC Statement
			preparedStatement = connection.prepareStatement(sqlUpdateQuery);
			// purposely setting wrong data-type to cause db ERROR
			preparedStatement.setString(1, "Steve Waugh");  
            preparedStatement.setInt(2, 8);
            //Step 2.C: Execute
            preparedStatement.executeUpdate();
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
					preparedStatement.close();
					connection.close();
				}
			} catch(SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}
	}

}
