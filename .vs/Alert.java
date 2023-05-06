package SeleniumLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public Alert() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException
	
	{
		// TODO Auto-generated method stub

		//System.out.println("I am constructor");
		System.setProperty("webdriver.chrome.driver", "C:\\Brindha\\Chrome Driver\\ChromeDriver.exe");

		
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/brind/OneDrive/Desktop/Html%20file.html");
		Thread.sleep(3000);
		WebElement searchBox = driver.findElement(By.id("alertButton"));
		searchBox.click();
		//driver.switchTo().alert().dismiss();
		Thread.sleep(3000);
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().getText();
	}

}
