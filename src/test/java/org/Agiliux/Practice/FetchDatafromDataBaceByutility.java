package org.Agiliux.Practice;

import java.sql.SQLException;
import java.util.List;

import com.Agiliux.Genericutility.DataBaseUtility;
import com.Agiliux.Genericutility.IConstantUtility;

public class FetchDatafromDataBaceByutility {
public static void main(String[] args) throws SQLException {
	DataBaseUtility db=new DataBaseUtility();
	db.openDBconnection(IConstantUtility.Db_url, "root", "root");
	List<String> data = db.getDataFromDataBAse("select * from sdet40", "emp_name");
	//List<String> data1 = db.getDataFromDataBAse("select * from sdet40", "emp_name");
	
	
	System.out.println(data);
	//System.out.println(data1);
	
	
	//Object modi = db.modifyDataFromDB("select * from sdet40");
	boolean status = db.verifyDataIntoDatabase("select * from sdet40" ,"emp_name" , "nitesh");
	System.out.println(status);
	db.closeDB();
}
}
