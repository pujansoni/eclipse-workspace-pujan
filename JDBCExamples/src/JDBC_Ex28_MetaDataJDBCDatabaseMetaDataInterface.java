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

public class JDBC_Ex28_MetaDataJDBCDatabaseMetaDataInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variables
		Connection connection = null;
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
			//get database metadata through connection
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			System.out.println("=== Database Metadata information ===\n");
			//database information
			System.out.println("Database Product Name: \t\t" + databaseMetaData.getDatabaseProductName());
			System.out.println("Database Product Version: \t" + databaseMetaData.getDatabaseProductVersion());
			System.out.println("Database Major Version: \t" + databaseMetaData.getDatabaseMajorVersion());
			System.out.println("Database Minor Version: \t" + databaseMetaData.getDatabaseMinorVersion());
			System.out.println();
			//driver information
			System.out.println("Driver Name: \t\t\t" + databaseMetaData.getDriverName());
			System.out.println("Driver Version: \t\t" + databaseMetaData.getDriverVersion());
			System.out.println("Driver Major Version: \t\t" + databaseMetaData.getDriverMajorVersion());
			System.out.println("Driver Minor Version: \t\t" + databaseMetaData.getDriverMinorVersion());
			//retrieving table information
			String table[] = {"TABLE"};
			resultSet = databaseMetaData.getTables(null, null, null, table);
			while(resultSet.next()) {
				System.out.println("Table information: \t\t" + resultSet.getString(3));
			}
			//retrieving view information
			String views[] = {"VIEWS"};
			resultSet = databaseMetaData.getTables(null, null, null, views);
			while(resultSet.next()) {
				System.out.println("View information: \t\t" + resultSet.getString(3));
			}
			System.out.println("\n== End of MetaData information ==");
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
