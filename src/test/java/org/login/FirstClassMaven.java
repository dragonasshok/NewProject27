package org.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstClassMaven {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		
		
    	//get the path of excel
		File file=new File("C:\\Users\\sivap\\eclipse-workspace\\MavenClass\\ExcelSheet\\data.xlsx");
		
		//get the object from file
	    FileInputStream stream=new FileInputStream(file);
	    
	    //create the workbook
	    Workbook workbook=new XSSFWorkbook(stream);
	    
	    //create the sheet name
	    Sheet sheet = workbook.getSheet("sheet1");
	    
	   //iterate the rows
		for(int i=0; i<sheet.getPhysicalNumberOfRows();i++) {
			Row row = sheet.getRow(i);
		for(int j=0; j<row.getPhysicalNumberOfCells();j++) {
			Cell cell = row.getCell(j);
			System.out.println(cell+" ");
			
		}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
