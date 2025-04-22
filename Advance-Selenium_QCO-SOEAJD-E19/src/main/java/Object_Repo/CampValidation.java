package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

public class CampValidation {

	public CampValidation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateCamp(WebDriver driver)
	{
		 
		String actdata = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();

		return actdata;
//		if (actData.equals(campName)) {
//			System.out.println("Campaign name is created");
//		} else {
//			System.out.println("Campaign name is not created");
//		}
	}
	
	public void validatePrd(WebDriver driver,String prdName)
	{
		String actPrd = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
		if (actPrd.equals(prdName)) {
			System.out.println("product name is created");
		} else {
			System.out.println("product name is not created");
		}
	}
}
