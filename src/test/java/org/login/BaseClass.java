package org.login;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.swing.text.Element;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi.withSha224;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v101.page.model.FrameId;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public String getData(String sheetName,int rownum, int cellnum) throws IOException {

		String res=null;

		File file=new File("C:\\Users\\sivap\\eclipse-workspace\\MavenClass\\ExcelSheet\\data.xlsx");

		FileInputStream fileInputStream=new FileInputStream(file);

		Workbook workbook=new XSSFWorkbook(fileInputStream);

		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rownum);

		Cell cell = row.getCell(cellnum);

		CellType cellType = cell.getCellType();

		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();

			break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)){
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yy");
				res = dateFormat.format(dateCellValue);

			}else {

				double d = cell.getNumericCellValue();
				BigDecimal decimal=new BigDecimal(d);
				res = decimal.toString();
			}
		default:
			break;
		}
		return res;

	}
	//writedata
	public void writedata(String sheetname, int rownum, int cellnum, String orderNumber) throws IOException {

		File file=new File("C:\\Users\\sivap\\eclipse-workspace\\MavenClass\\ExcelSheet\\data.xlsx");

		FileInputStream fileInputStream=new FileInputStream(file);

		Workbook workbook=new XSSFWorkbook(fileInputStream);

		Sheet sheet = workbook.getSheet(sheetname);

		Row row = sheet.createRow(rownum);

		Cell cell = row.createCell(cellnum);

		cell.setCellValue(orderNumber);

		FileOutputStream stream=new FileOutputStream(file);

		workbook.write(stream);


	}


	public static WebDriver driver;

	//1.get driver
	public static void getDriver(String browserType) {

		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

			break;

		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();

			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();

			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();

			break;

		default:
			
			break;
		}

	}

		//1.enterurl
		public static void loadUrl(String url) {

			driver.get(url);

		}
		//2.maximize
		public static void maximizeWindow() {

			driver.manage().window().maximize();
		}
		//3.insert value in textbox
		public void type(WebElement element,String data) {
			element.sendKeys(data);

		}
		//4.click button
		public void clickButton(WebElement element) {
			element.click();


		}
		//5.click ok in alerts
		public void okAlerts() {
			Alert al=driver.switchTo().alert();
			al.accept();

		}
		//6.cancel in alert box
		public void cancelAlert() {
			Alert al=driver.switchTo().alert();
			al.dismiss();

		}
		//7.get text from webpage
		public String textFromWebpage(WebElement element) {
			String text = element.getText();
			return text;

		}

		public String getAttribute(WebElement element) {
			String attribute = element.getAttribute("value");
			//		System.out.println(attribute);
			return attribute;
		}



		//8.get insert value from textbox
		public String getAttribute(WebElement element,String value) {
			String attribute = element.getAttribute(value);
			return attribute;
		}
		//9.close all windows
		public static void closeWindows() {
			driver.quit();

		}
		//10.close current window
		public void currentWindow() {
			driver.close();

		}
		//11 get the title
		public String getTitle() {
			String title = driver.getTitle();
			return title;

		}
		//12 entered url
		public String enteredrl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;

		}
		//13dropdown option by text
		public void selectByVisibleText(WebElement element, String text) {
			Select select=new Select(element);
			select.selectByVisibleText(text);

		}
		//14dropdown attribute value
		public void selectByValue(WebElement element,String value) {
			Select select=new Select(element);
			select.selectByValue(value);

		}
		//15dropdoen in index
		public void selectByIndex(WebElement element, int index) {
			Select select=new Select(element);
			select.selectByIndex(index);

		}
		//16.insert value in txtbox in js
		public void textboxInJs(WebElement element,String text) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeAsyncScript("arguments[0].setAttribute('value','"+text+"')",element);

		}
		//17click button by js
		public void clickBtnJs(WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("arguments[0].click", element);

		}
		//18switch to child window
		public void switchTo(String win) {
			WebDriver window = driver.switchTo().window(win);

		}
		//20frame by index
		public void switchToFrame(String index) {
			WebDriver frame = driver.switchTo().frame(0);

		}
		//21 frame by frameid
		public void framesId(String id) {
			WebDriver frame = driver.switchTo().frame(id);

  
		}
		//22 find locator by id
		public  WebElement locatorId(String attributevalue) {
			WebElement findElement = driver.findElement(By.id(attributevalue));
			return findElement;

		}
		//23 find locator by name
		public WebElement locatorName(String attributevalue) {
			WebElement findElement = driver.findElement(By.name(attributevalue));
			return findElement;
		}

		//24 find locator by classname
		public WebElement locatorClassName(String attributevalue) {
			WebElement findElement = driver.findElement(By.className(attributevalue));
			return findElement;

		}
		//25 find locator by xpath
		public WebElement locatorXpath(String attributevalue) {
			WebElement findElement = driver.findElement(By.xpath(attributevalue));
			return findElement;
		}

		//26scrool up in js
		public void scroolDown(WebElement element) {
			JavascriptExecutor ja=(JavascriptExecutor)driver;
			ja.executeScript("arguments[0].scroolintoview(true)", element);

		}
		//27scrool down in js
		public void Up(WebElement element) {
			JavascriptExecutor ja=(JavascriptExecutor)driver;
			ja.executeScript("arguments[0].scroolintoview(false)", element);

		}
		//28 get option
		public List<WebElement> getOptions(WebElement element) {
			Select s=new Select(element);
			List<WebElement> options = s.getOptions();
			return options;

		}
		//29get all selected options
		public List<WebElement> allSelectOptions(WebElement element) {
			Select select=new Select(element);
			List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
			return allSelectedOptions;

		}
		//30 get first select option
		public WebElement firstSelect(WebElement element) {
			Select select=new Select(element);
			WebElement option = select.getFirstSelectedOption();
			return option;

		}
		//31deselect by index
		public void deselectByIndex(WebElement element,int index) {
			Select select=new Select(element);
			select.deselectByIndex(0);

		}
		//32deselect by value
		public void deselectByValue(WebElement element,String value) {
			Select select=new Select(element);
			select.deselectByValue(value);

		}
		//33deselect by text
		public void deselectByText(WebElement element,String text) {
			Select select=new Select(element);
			select.deselectByVisibleText(text);

		}
		//33deselect by text
		public void selectByText(WebElement element,String text) {
			Select select=new Select(element);
			select.selectByVisibleText(text);
		}
		//34deselect all
		public void deselectAll(WebElement element) {
			Select select=new Select(element);
			select.deselectAll();

		}
		//35is multiple
		public boolean isMultiple(WebElement element) {
			Select select=new Select(element);
			boolean multiple = select.isMultiple();
			return  multiple;

		}
		//36mouse over action
		public void mouseOverAction(WebElement element) {
			Actions a=new Actions(driver);
			a.moveToElement(element).perform();

		}
		//37drag and drop
		public void dragAndDrop(WebElement from,WebElement to) {
			Actions a=new Actions(driver);
			a.dragAndDrop(from, to).perform();

		}
		//38double click
		public void doubleClick() {
			Actions a=new Actions(driver);
			a.doubleClick().perform();

		}
		//39 context click
		public void contextClick() {
			Actions a=new Actions(driver);
			a.contextClick().perform();

		}
		//40robot key press
		public void robotKeyPress(int key) throws AWTException {
			Robot robot=new Robot();
			robot.keyPress(0);

		}
		//41robot key release
		public void robotKeyRelease(int key) throws AWTException {
			Robot robot=new Robot();
			robot.keyRelease(0);

		}
		//42take screen shot
		public File takeScreenShot() {
			TakesScreenshot sc=(TakesScreenshot) driver;
			File screenshotAs = sc.getScreenshotAs(OutputType.FILE);
			return screenshotAs;

		}
		//43get window handling
		public String windoeHandle() {
			String handle = driver.getWindowHandle();
			return handle;

		}
		//44get windoe handles
		public Set<String> windoeHandles() {
			Set<String> windowHandles = driver.getWindowHandles();
			return windowHandles;
		}
		//45navigate to load url
		public void navigateTo(String url) {
			driver.navigate().to(url);

		}
		//46navigate to forward
		public void navigateForward() {
			driver.navigate().forward();


		}
		//47 navigate to backword
		public void nacigateBackward() {
			driver.navigate().back();

		}
		//48 navigate to refresh
		public void navigateRefresh() {
			driver.navigate().refresh();

		}
		//49 system set property
		public void systemSetProperty(String driver,String path) {
			System.setProperty(driver, path);

		}
		//50 get attribute js
		public Object getAttributeJs(WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			Object script = js.executeScript("arguments[0].getAttribute('value')",element);
			return script;

		}
		//51 thread sleep
		public  void thread(int sec) throws InterruptedException {
			Thread.sleep(sec);

		}
		//52 parent frame
		public void parentFrame() {
			driver.switchTo().parentFrame();

		}
		//53 default content
		public void defaultContent() {
			driver.switchTo().defaultContent();

		}
		//54 child window
		public void childWindow(String win) {
			driver.switchTo().window(win);

		}
		//55 implicity waits
		public static  void implicityWaits(int sec ) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));

		}
		//56 alert is present
		public boolean alertPresent() {
			boolean al=driver.switchTo().equals(driver);
			return al;

		}
		//57alerts in title contains
		public void alertContains(int index) {
			Alert a=(Alert) driver.switchTo().frame(0);


		}
		//58clear
		public void clear(WebElement element) {
			element.clear();

		}




	}
