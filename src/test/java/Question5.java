import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Question5 {
	WebDriver driver;
	WebDriverWait wait;
	Question3CIIPOM ciipom;

	@BeforeTest
	public void setUp() throws IOException{
		ciipom = new Question3CIIPOM();
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}

	@Test
	public void testCase(String searchkey) throws InterruptedException, IOException{
		driver.get("https://www.hometown.in");
		
		String BestSellerText = driver.findElement(By.xpath("//h4[.='Best Sellers']/following-sibling::p")).getAttribute("innerHTML");
		Assert.assertEquals(BestSellerText, "Shop Your Favorite from our Range of Best Sellers");
		
		Actions builder = new Actions(driver);
		Action act = builder.moveToElement(driver.findElement(By.xpath("//span[.='Kitchenware']"))).
				        	click(driver.findElement(By.xpath("//a[.='Food Storage']"))).build();

		act.perform();
		String ProductName = driver.findElement(By.xpath("(//a[contains(@id,'cat_2_')]/div)[1]/div")).getAttribute("innerHTML");
		System.out.println("Product Name = " + ProductName);
	}

	@AfterTest
	public void tearDown(){
		driver.quit();	
	}
	
}
