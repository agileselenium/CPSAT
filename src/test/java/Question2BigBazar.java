import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Question2BigBazar {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("https://www.bigbazaar.com");
		System.out.println("Clicking on the Beverages");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//h3[.='Beverages']")).click();
		System.out.println("Clicked on the Beverages");
		
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[.='Beverages']")));
		
		System.out.println("Again clicking on the beverages");
		driver.findElement(By.xpath("//h3[.='Beverages']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@title='+1'])[4]")).click();
		driver.findElement(By.xpath("(//a[@title='Add to Shopping list'])[4]")).click();
		
		String Quantity = driver.findElement(By.xpath("(//input[@title='Quantity'])[4]")).getAttribute("value");
		System.out.println("Quantity = " + Quantity);
		
		Assert.assertTrue("Added To List Text is not present", driver.findElement(By.xpath("/a[@title='Add to Shopping list'])[4]")).getAttribute("innerHTML").equals("Added to list"));

		driver.findElement(By.xpath("(//input[@title='-1'])[4]")).click();
		
		Quantity = driver.findElement(By.xpath("(//input[@title='Quantity'])[4]")).getAttribute("value");
		System.out.println("Quantity = " + Quantity);
		
		System.out.println("ToolTip = " + driver.findElement(By.xpath("(//a[@title='Add to Shopping list'])[4]")).getAttribute("title"));
		
	}

}
