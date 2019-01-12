import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Question3CIIPOM {

public static WebElement element = null;
	
	public static List<WebElement> AllLanguages(WebDriver driver){
		List<WebElement> AllLanguages = driver.findElements(By.xpath("//*[@data-testid='masthead-edition-menu']//a"));
		return AllLanguages;
	}

	public static WebElement CII_CIIServices(WebDriver driver){
		return element = driver.findElement(By.xpath("//a[.='CII Services']"));
	}
	public static WebElement CII_Sectoral_Portfolio(WebDriver driver){
		return element = driver.findElement(By.xpath("//a[.='Sectoral Portfolio']"));
	}
	
	public static WebElement CII_Services(WebDriver driver){
		return element = driver.findElement(By.xpath("//a[.='Services']"));
	}
	
	public static WebElement CII_Auto_Components(WebDriver driver){
		return element = driver.findElement(By.xpath("//a[.='Auto Components']"));
	}
	
	
	
	public static WebElement CII_ContactName(WebDriver driver){
		return element = driver.findElement(By.xpath("//div[@class='contact-txt']//strong"));
	}
	
	public static WebElement CII_DesignationAndFAX(WebDriver driver){
		return element = driver.findElement(By.xpath("//div[@class='contact-txt']"));
	}
}
