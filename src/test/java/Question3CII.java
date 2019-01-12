import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;*/


import junit.framework.Assert;

public class Question3CII {
	WebDriver driver;
	WebDriverWait wait;
	Question3CIIPOM ciipom;

	@Before
	public void setUp() throws IOException{
		ciipom = new Question3CIIPOM();
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get("http://www.cii.in");
	}

	@Test
	public void testCase() throws InterruptedException, IOException{
		Thread.sleep(10000);
		Actions builder = new Actions(driver);
		
		Action act = builder.moveToElement(ciipom.CII_CIIServices(driver)).
				moveToElement(ciipom.CII_Sectoral_Portfolio(driver)).
				moveToElement(ciipom.CII_Services(driver)).
				click(ciipom.CII_Auto_Components(driver)).build();

		act.perform();

		Assert.assertTrue("Title is different than CII" , driver.getTitle().contains("CII"));
		Assert.assertTrue("Contact Name is Different", ciipom.CII_ContactName(driver).getAttribute("innerHTML").equals("Amita  Sarkar"));
		Assert.assertTrue("Designation is different ", ciipom.CII_DesignationAndFAX(driver).getAttribute("innerHTML").contains("Deputy Director General"));
		Assert.assertTrue("Fax Details is different ", ciipom.CII_DesignationAndFAX(driver).getAttribute("innerHTML").contains("Fax :91-11-2462 6149"));

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("CIIPageScreenshot.png"));
	}

	@After
	public void tearDown(){
		//driver.quit();	
	}
}
