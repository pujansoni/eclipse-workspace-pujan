import java.sql.*;

public class JDBC_Ex10_BatchUpdateJDBCStatement {

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
			String sqlUpdateQuery1 = "UPDATE PLAYER SET AGE = 46 WHERE PLAYER_ID = 2";
			//add to batch for execution
			statement.addBatch(sqlUpdateQuery1);
			String sqlUpdateQuery2 = "UPDATE PLAYER SET AGE = 35 WHERE PLAYER_ID = 3";
			//add to batch for execution
			statement.addBatch(sqlUpdateQuery2);
			String sqlUpdateQuery3 = "UPDATE PLAYER SET NAME = 'Graeme Craig Smith' WHERE PLAYER_ID = 4";
			//add to batch for execution
			statement.addBatch(sqlUpdateQuery3);
			//Step 2.C: Executing batch
			statement.executeBatch();
			//End of JDBC transaction
			connection.commit();
			System.out.println("All PLAYER info updation is successful");
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
