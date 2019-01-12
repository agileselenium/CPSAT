import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nyTimesPOM {

	public static WebElement element = null;
	
	public static List<WebElement> AllLanguages(WebDriver driver){
		List<WebElement> AllLanguages = driver.findElements(By.xpath("//*[@data-testid='masthead-edition-menu']//a"));
		return AllLanguages;
	}

	public static WebElement NY_TechButton(WebDriver driver){
		return element = driver.findElement(By.xpath("//a[.='Tech']"));
	}

}
