import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;


public class BBC {

	private WebDriver driver;
		
	@Test
	public void testCaseGoToNews() throws InterruptedException {
		
		WebElement news = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/header/nav/div[1]/div/div[2]/ul[2]/li[2]"));
		news.click();
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Home - BBC News");
	}

	@Test
	public void testCaseGoToNews2() throws InterruptedException {
		
		WebElement news = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/header/nav/div[1]/div/div[2]/ul[2]/li[2]"));
		news.click();
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Home - BBC News");
	}


	@Test
	public void testWeather() {
		WebElement weather = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/header/nav/div[1]/div/div[2]/ul[2]/li[4]"));
		weather.click();
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "BBC Weather - Home");
	}
	
	@Test
	public void testSport() {
		WebElement sport = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/header/nav/div[1]/div/div[2]/ul[2]/li[3]"));
		sport.click();
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "BBC Sport - Scores, Fixtures, News - Live Sport");
	}

	@BeforeMethod 
	public void Delay() throws InterruptedException {
		driver.get("https://www.BBC.com");
		Thread.sleep(1000);
	}
	
	@BeforeSuite
	public void beforeSuite() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Brindha\\Chrome Driver\\ChromeDriver.exe");
		driver = new ChromeDriver();
		
		
	}

	@AfterSuite
	public void afterSuite() {

		driver.quit();

	}

}
