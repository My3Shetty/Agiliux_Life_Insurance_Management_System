package org.Agiliux.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/*
		 * Naming convention.....
		 * package--> org.project_name.module_name--> camelcase
		 * class/interface--> paselcase
		 * veriable/methods--.camelcase
		 * 
		 * all names should be meaningfull
		 */
public class ModifyDataIntoDatabase {
	//for DDL,DML statement

	public static void main(String[] args) throws SQLException {
		//step 1-->crete object for driver
		Driver dbdrvier=new Driver();
		//step 2-->register the driver instace to the object
		DriverManager.registerDriver(dbdrvier);
		//step 3-->get/establish the database connection
		     Connection Connection = DriverManager.getConnection("jdbc:mysql://localhost;3306/tyss", "root", "root");
		      try {
				//step 4--> create the statement 
		    	     Statement statement = Connection.createStatement();
		    	//step 5-->Execute the Quary
		    	        int result = statement.executeUpdate("insert into sdet40 values 1005,'Mohan', 89895623,'Shimoga'):");
		    	        //step 6--> verify or itterate or fetch the data
		    	        System.out.println(result+"Data update sucessfully");
			} finally {
				//step 7-->close the db connection
				Connection.close();
				System.out.println("connection closed sucessfully");
			}
		
	}

}
