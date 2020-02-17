import java.sql.*;

public class JDBC_Ex12_CreateTableJDBCPreparedStatement {

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
			String sqlQuery = "CREATE TABLE PLAYER (" +
                    " PLAYER_ID INT(6) NOT NULL AUTO_INCREMENT, " +
                    " NAME VARCHAR(50) NOT NULL, " + 
                    " AGE INT(3) NOT NULL, " + 
                    " MATCHES INT(3) NOT NULL, " + 
                    " PRIMARY KEY (`PLAYER_ID`))";
			//Step 2.B: Creating JDBC PreparedStatement
			preparedStatement = connection.prepareStatement(sqlQuery);
			//Step 2.C: Executing SQL & retrieve data into ResultSet
			int sqlQueryResult = preparedStatement.executeUpdate();
			//output of database creation
			if(0 == sqlQueryResult) {
				System.out.println("New table created successfully");
			} else {
				System.out.println("Error in creating table");
			}
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
