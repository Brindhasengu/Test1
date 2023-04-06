package SeleniumLearning;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
public class findelementsFromElement {

	public findelementsFromElement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Brindha\\Chrome Driver\\ChromeDriver.exe");
        WebDriver driver = new ChromeDriver();
        

        try {
            driver.get("https://moneycontrol.com");

            // Get element with tag name 'div'
            WebElement element = driver.findElement(By.tagName("div"));

            // Get all the elements available with tag name 'p'
            List<WebElement> elements = element.findElements(By.tagName("p"));
            for (WebElement e : elements)
            {
                System.out.println(e.getText());
            }
        } finally {
           // driver.quit();
        }
    }
}
