import java.sql.*;

public class JDBC_Ex9_BatchInsertJDBCStatement {

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
			//Start of JDBC transaction
			connection.setAutoCommit(false);
			//Step 2.B: Creating JDBC Statement
			statement = connection.createStatement();
			String sqlInsertQuery1 = "INSERT INTO PLAYER(NAME, AGE, MATCHES) VALUES('Jacques Kallis', '40', '160')";
			//add to batch for execution
			statement.addBatch(sqlInsertQuery1);
			String sqlInsertQuery2 = "INSERT INTO PLAYER(NAME, AGE, MATCHES) VALUES('AB de Villiers', '32', '106')";
			//add to batch for execution
			statement.addBatch(sqlInsertQuery2);
			String sqlInsertQuery3 = "INSERT INTO PLAYER(NAME, AGE, MATCHES) VALUES('Hashim Amla', '33', '92')";
			//add to batch for execution
			statement.addBatch(sqlInsertQuery3);
			//Step 2.C: Executing batch
			statement.executeBatch();
			//End of JDBC transaction
			connection.commit();
			System.out.println("All new PLAYER info insertion is successful");
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			//Step 3: Closing database connection
			try {
				if(null != connection) {
					//cleanup resources once after processing
					statement.close();
					connection.close();
				}
			} catch(SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}
	}

}
