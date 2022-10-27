package org.login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MavenTask {

	public static void main(String[] args) throws IOException {
		
    WebDriverManager.chromedriver().setup();
    
    WebDriver driver=new ChromeDriver();
    
    driver.get("http://demo.automationtesting.in/Register.html");
		
    WebElement element = driver.findElement(By.id("Skills"));
    
    Select select=new Select(element);
    
    List<WebElement> list = select.getOptions();
    
    for (int i = 0; i < list.size(); i++) {
    	
    	WebElement text = list.get(i);
    	
		String text2 = text.getText();
		
		System.out.println(text2);
	
    //create file
	File file =new File("C:\\Users\\sivap\\eclipse-workspace\\MavenClass\\ExcelSheet\\task.xlsx");
    
    Workbook work=new XSSFWorkbook();
    
    Sheet sheet=work.createSheet("task");
    
    for (int j = 0; j < list.size(); j++) {
    	
    	WebElement user = list.get(j);
    	
    	String text3 = user.getText();
    	
    	 Row row = sheet.createRow(j);
    	 
    	 Cell cell = row.createCell(0);
    	 
    	 cell.setCellValue(text3);
    	 
    	 FileOutputStream m=new FileOutputStream(file);
    	 
    	 work.write(m);
    	 
    	 
    	 
    	 
		
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
		
		
		}
}
