package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Excel_Utility;

public class DataProviderEx3 {

	@Test(dataProvider = "readContactNames")
	public void createContact(String firstNAme, String lastNAme) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
        driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("[alt='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys(firstNAme);
		driver.findElement(By.name("lastname")).sendKeys(lastNAme);
		driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
        driver.quit();
	}

	@DataProvider
	public Object[][] readContactNames() throws Throwable {
	
		Excel_Utility elib = new Excel_Utility();
		Object[][] data = elib.readDataUsingDataProvider("DataProvider");
		return data;
		

	}
}
