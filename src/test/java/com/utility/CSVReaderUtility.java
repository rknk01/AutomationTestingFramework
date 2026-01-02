package com.utility;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.ui.pojos.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSV(String fileName) {
		// TODO Auto-generated method stub

		File csvFile=new File(System.getProperty("user.dir")+"\\testData\\"+fileName);
		FileReader fileReader=null;
		CSVReader csvReader;
		String[] line;
		User userData;
		List<User> userList = null;
		
		try {
			fileReader=new FileReader(csvFile);
			csvReader=new CSVReader(fileReader);
			csvReader.readNext();
			userList=new ArrayList<User>();
			while((line=csvReader.readNext())!=null) {
				userData=new User(line[0], line[1]);
				userList.add(userData);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userList.iterator();
		
	}

}
