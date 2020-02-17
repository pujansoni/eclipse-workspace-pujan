import java.sql.*;

public class JDBC_Ex20_StoredProcedureJDBCCallableStatement {

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
			//set values for new player record
			callableStatement.setString(1, "Michael Vaughan");
			callableStatement.setInt(2, 41);
			callableStatement.setInt(3, 82);
			//Step 2.C: Executing CallableStatement
			int result = callableStatement.executeUpdate();
			System.out.println(result + " indicates stored procedure execution is successful");
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
