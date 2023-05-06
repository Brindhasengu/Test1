package first2022;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
import java.util;

public class First {

	public First() {
		
		// TODO Auto-generated constructor stub
		System.setProperty("webdriver.chrome.driver", 
				"/home/brindha/Documents/Selenium/chromedriver");

			//	WebDriver driver = new ChromeDriver(); 
	//	System.setProperty("webdriver.Chrome.driver", 
			//	"/home/brindha/Documents/Selenium/chromedriver");

				Object driver;
				//RemoteWebDriver driver = new ChromeDriver (); 
				//Interface
				//Dynamic Binding
				driver.get("https://www.bbc.co.uk/news");
						 	
			
	}

}
