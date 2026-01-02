package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	public static String readProperties(Env env, String propertyName) {
		
		System.out.println(System.getProperty("user.dir"));
		File propFile=new File(System.getProperty("user.dir")+"\\config\\"+env+".properties");
		FileReader fileReader = null;
		Properties prop=new Properties();
		try {
			fileReader = new FileReader(propFile);
			prop.load(fileReader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop.getProperty(propertyName);
		
		
	}
}
