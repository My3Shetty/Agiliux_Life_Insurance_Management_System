package org.Agiliux.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromProperty {

	public static void main(String[] args) throws IOException {
   //Steo 1--> convert the physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/commdata.properties");
		//step 2 --> create the object for properties
		Properties Property = new Properties();
		//step 3-->load all the keys
		Property.load(fis);
		//step 4-->fetch the data4
		String url = Property.getProperty("url").trim();
		String browser = Property.getProperty("browser").trim();
		String username = Property.getProperty("username").trim();
		String password = Property.getProperty("password");

		System.out.println(url);
		System.out.println(browser);
		System.out.println(username);
		System.out.println(password);
	}

}
