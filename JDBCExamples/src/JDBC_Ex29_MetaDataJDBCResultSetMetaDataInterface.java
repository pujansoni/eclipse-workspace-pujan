/*
 * We can retrieve below listed database information
 * 1. Driver name
 * 2. Driver version
 * 3. User name
 * 4. Product name
 * 5. Product version
 * 6. Table count
 * 7. View count
 */
import java.sql.*;

public class JDBC_Ex29_MetaDataJDBCResultSetMetaDataInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variables
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		//Step 1: Loading or registering MySQL driver class
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
			//Step 2.B: Creating JDBC Statement
			statement = connection.createStatement();
			//create SQL query to get all players
			String sqlSelectQuery = "SELECT * FROM PLAYER";
			//Step 2.C: Executing SQL & retrieve data into ResultSet
			resultSet = statement.executeQuery(sqlSelectQuery);
			//Retrieve result set metadata information
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			//Column count information
			System.out.println("Number of columns in table: " + resultSetMetaData.getColumnCount() + "\n");
			//Column information
			System.out.println("Name\t\tType");
			System.out.println("====\t\t====");
			for(int i=1; i<=resultSetMetaData.getColumnCount(); i++) {
				System.out.println(resultSetMetaData.getCatalogName(i) + "\t\t" + resultSetMetaData.getColumnTypeName(i));
			}
		} catch(SQLException sqlex) {
			sqlex.printStackTrace();
		} finally {
			//Step 3: Closing database connection
			try {
				if(null != connection) {
					//and then finally close connection
					connection.close();
				}
			} catch(SQLException sqlex) {
				sqlex.printStackTrace();
			}
		}
	}

}
