import java.sql.*;

public class JDBC_Ex21_StoredFunctionJDBCCallableStatement {

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
			callableStatement = connection.prepareCall("{? = call sfCountPlayerRecordinDB()}");
			//register OUT parameter
			callableStatement.registerOutParameter(1,  Types.INTEGER);
			//Step 2.C: Executing CallableStatement
			callableStatement.execute();
			//get count and print in console
			int count = callableStatement.getInt(1);
			System.out.println("Player count in PLAYER_INFO database is = " + count);
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
