import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class nyTimes {

	WebDriver driver;
	nyTimesPOM pom;

	@BeforeTest
	public void Start()
	{
		//System.setProperty("webdriver.chrome.driver", System. getProperty("user.dir") + "/src/test/resources/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		driver.get("http://www.nytimes.com/");
	}

	@org.testng.annotations.Test
	public void Test() throws InterruptedException, IOException
	{
		pom = new nyTimesPOM();

		List<WebElement> els = pom.AllLanguages(driver);
		for(WebElement el: els){
			System.out.println("Languages = " + el.getAttribute("innerHTML"));
		}

		System.out.println("Tech Button Href = " + pom.NY_TechButton(driver).getAttribute("href"));
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("nyTimesPageScreenshot.png"));

		Assert.assertTrue("Title doesn't conatins Text 'The New York Times'" , driver.getTitle().contains("The New York Times"));
	}

	@AfterTest
	public void Endtest()
	{
		driver.close();
	}

}
