package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojos.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcel(String fileName) {
		// TODO Auto-generated method stub
		
		File xssfFile=new File(System.getProperty("user.dir")+"\\testData\\"+fileName+".xlsx");
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		Iterator<Row> rowIterator;
		Row row;
		Cell emailAddress, password;
		User user;
		List<User> userList = null;
		try {
			workbook=new XSSFWorkbook(xssfFile);
			sheet=workbook.getSheet("LoginTestData");
			rowIterator=sheet.rowIterator();
			rowIterator.next();
			userList=new ArrayList<User>();
			while(rowIterator.hasNext()) {
				row=rowIterator.next();
				emailAddress=row.getCell(0);
				password=row.getCell(1);
				user=new User(emailAddress.toString(),password.toString());
				userList.add(user);
			}
			workbook.close();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList.iterator();
		
		
	}

}
