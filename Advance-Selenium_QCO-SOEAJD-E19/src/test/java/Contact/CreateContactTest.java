package Contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repo.ContactLookUp;
import Object_Repo.ContactValidationPage;
import Object_Repo.CreateContactPage;
import Object_Repo.HomePage;
import Object_Repo.LoginPage;

public class CreateContactTest extends BaseClass {


//im branch 1

	@Test(groups = "regressionTest")
	public void createContactTest() throws Throwable {

		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

//		driver.findElement(By.linkText("Contacts")).click();
		HomePage home = new HomePage(driver);
		home.clickContactLink();
//  Assert.fail("im failing the script");
//		driver.findElement(By.cssSelector("[alt=\"Create Contact...\"]")).click();
		ContactLookUp lookUp = new ContactLookUp(driver);
		lookUp.clickContactLookUp();

		CreateContactPage contactPage = new CreateContactPage(driver);
		contactPage.selectDropDOwnVAlue(driver);

		String FirstName = elib.getExcelData("Contact", 0, 0);
		String LastName = elib.getExcelData("Contact", 1, 0);
		contactPage.enterContactDetails(FirstName, LastName);

//----------------------------------------------------------------------------------------------------------------------------
		contactPage.clickSaveButton();

		ContactValidationPage validate = new ContactValidationPage(driver);
		String actData = validate.validateContactFirstNAme(driver, FirstName);
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actData, FirstName);
		System.out.println("Assert PASS");
		
		validate.validateContactLastNAme(driver, LastName);
		
		soft.assertAll();

	}

}
