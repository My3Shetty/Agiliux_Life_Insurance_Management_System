package org.Agiliux.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabase {
	public static void main(String[] arg) throws SQLException
	// step 1-->Create the object for Driver
	{
		Driver dbdriver = new Driver();
		// Step 2-->register the driver instance on the jdbc
		DriverManager.deregisterDriver(dbdriver);
		// step 3-->get/establish the database connection

		Connection Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
		try {
			// step 4-->create the statement
			Statement statement = Connection.createStatement();
			// step 5-->Execute the Quary
			ResultSet result = statement.executeQuery("Select * for sdet40");
			// step 6-->verify or itterate or fetch the data
			while (result.next()) {
				System.out.println(result.getString("emp_name"));
			}
		} finally {
			// step 7-->close the db connection
			Connection.close();// mandatory
			System.out.println("connection closed sussecfully");
		}
	}
}
