import java.sql.*;

public class JDBC_Ex22_BatchStoredProcedureJDBCCallableStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variables
		Connection connection = null;
		CallableStatement callableStatement = null;
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
			//Step 2.B: Creating JDBC CallableStatement
			callableStatement = connection.prepareCall("{call spInsertNewPlayerRecord(?, ?, ?)}");
			//set values for new player record - 1
			callableStatement.setString(1, "Herchelle Gibbs");
			callableStatement.setInt(2, 42);
			callableStatement.setInt(3, 90);
			//add to batch - 1
			callableStatement.addBatch();
			//set values for new player record - 2
			callableStatement.setString(1, "Mervyn Dillon");
			callableStatement.setInt(2, 41);
			callableStatement.setInt(3, 38);
			//add to batch - 2
			callableStatement.addBatch();
			//set values for new player record - 3
			callableStatement.setString(1, "Nathan Astle");
			callableStatement.setInt(2, 44);
			callableStatement.setInt(3, 81);
			//add to batch - 3
			callableStatement.addBatch();
			//Step 2.C: Executing CallableStatement
			int[] insertCounts = callableStatement.executeBatch();
			for(int result: insertCounts) {
				System.out.println(result + " indicates insertion is successful");
			}
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			//Step 3: Closing database connection
			try {
				if(null != connection) {
					callableStatement.close();
					connection.close();
				}
			} catch(SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}
	}

}
