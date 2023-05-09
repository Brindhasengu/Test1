import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class BBCLogin {

	private WebDriver driver;
	String[][] testData;	
	
	
	@Test
	public void LoginTest() throws InterruptedException {
		for (int i = 0; i < testData.length - 1; i++) {
			  System.out.println("Testing with data");
			  System.out.println(testData[i][0]);
			  System.out.println(testData[i][1]);
			  System.out.println(testData[i][2]);
			  
			  LaunchSite();
			  LoginTest(testData[i][0], testData[i][1], testData[i][2]);
			  Logout();
			}
	}
	
	private void LaunchSite() throws InterruptedException {
		driver.get("https://www.BBC.co.uk");
		Thread.sleep(1000);
		
	}

	private void Logout() {
		// TODO Auto-generated method stub
		
	}

	private void LoginTest(String testUsername, String testPassword, String isValid)
	{
		System.out.println("Within LoginTest()");
		WebElement login = driver.findElement(By.xpath("//*[@id=\"header-content\"]/nav/div[1]/div/div[2]/ul[1]/li[1]/a"));
		login.click();
		WebElement username = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[1]/div[3]/form/div[1]/div/input"));

		username.sendKeys(testUsername);
		WebElement password=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[1]/div[3]/form/div[2]/div/input"));
		password.sendKeys(testPassword);
		WebElement signin =driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[1]/div[3]/form/div[2]/div/input"));
		signin.click();
		/*
		WebElement errorText=driver.findElement(By.id("form-message-password"));
		if(errorText != null)
		{
			System.out.println("Error message displayed");
		}
		else
		{
			System.out.println("Error message NOT displayed");
		}*/
	}

	@BeforeMethod 
	public void Delay() throws InterruptedException {
		driver.get("https://www.BBC.co.uk");
		Thread.sleep(3000);
	}
	
	@BeforeSuite
	public void beforeSuite() throws InterruptedException, EncryptedDocumentException, IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\Brindha\\Chrome Driver\\ChromeDriver.exe");
		driver = new ChromeDriver();
		
		LoadTestData();
		
		
	}

	private void LoadTestData() throws EncryptedDocumentException, IOException {
		// Work out the location of the xls file
		String filename = System.getProperty("user.dir") + "\\src\\SeleniumLearning\\TestData\\Usernames.xlsx";
		System.out.println(filename);
		
		// Open the file into a stream
		File file = new File(filename);
		FileInputStream fis = new FileInputStream(file);
		
		// Create a excel workbook from the file stream
		Workbook wb = WorkbookFactory.create(fis);
		
		// Get the sheet within the workbook we are interested in.
		Sheet sheet = wb.getSheet("sheet1");
		
		// Read rows and columns from the sheet
		int rowsCount  = sheet.getLastRowNum();
		Row row0 = sheet.getRow(0);
		int columnsCount = row0.getLastCellNum();
		System.out.println(rowsCount);
		System.out.println(columnsCount);
		
		DataFormatter formatter = new DataFormatter();
		
		testData = new String[rowsCount][columnsCount];
		
		for(int i = 1; i <= rowsCount ; i++){
			for(int j = 0 ; j < columnsCount ; j++)	{
				
				testData[i-1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
				
				System.out.println(testData[i-1][j]);
			}
		}
		
	}

	@AfterSuite
	public void afterSuite() {

		driver.quit();

	}

}
