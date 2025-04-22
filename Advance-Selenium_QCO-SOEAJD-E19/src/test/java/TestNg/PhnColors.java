package TestNg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PhnColors {

	public static void main(String[] args) throws Throwable {
	
		WebDriver driver=new EdgeDriver();

		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("field-keywords")).sendKeys("iphone14",Keys.ENTER);
		
		List<WebElement> allColors = driver.findElements(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Starlight']/../../../..//div[@class='a-section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view']//a"));
	Thread.sleep(1000);
		for (WebElement color : allColors)
		{
			System.out.println(color.getAttribute("aria-label"));
		}
	
	}

}
