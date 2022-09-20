package com.Agiliux.Genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	/**
	 * 
	 */
	private Connection Connection;

	/**
	 * this method is use to open database connection
	 * 
	 * @author Maithri Shetty
	 * @param dburl
	 * @param dbUserName
	 * @param dbPassword
	 * @throws SQLException
	 */

	public void openDBconnection(String dburl, String dbUserName, String dbPassword) {
		Driver dbdriver = null;
		try {
			dbdriver = new Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DriverManager.deregisterDriver(dbdriver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * this method is use to get the data from database
	 * 
	 * @author Nitesh ambastha
	 * @param Quary
	 * @param columnName
	 * @return
	 */

	public List<String> getDataFromDataBAse(String Quary, String columnName) {

		Statement statement = null;
		try {
			statement = Connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = null;
		try {
			result = statement.executeQuery(Quary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> list = new ArrayList<String>();
		try {
			while (result.next()) {
				list.add(result.getString(columnName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * this method is use to close the database
	 * 
	 * @author Nitesh ambastha
	 */
	public void closeDB() {
		try {
			Connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modifyDataFromDB(String Quary) {
		Statement statement = null;
		try {
			statement = Connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.executeQuery(Quary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public boolean verifyDataIntoDatabase(String Quary, String columnName, String expectedData) throws SQLException {
		List<String> list = getDataFromDataBAse(Quary, columnName);
		boolean flag = false;
		
		for (String actualData : list) {
			if (actualData.equalsIgnoreCase(expectedData)) {
				flag=true;
				break;
			}
		}
		return flag;
		
	}

}
