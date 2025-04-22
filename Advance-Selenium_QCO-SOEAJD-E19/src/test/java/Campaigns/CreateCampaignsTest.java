package Campaigns;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repo.CampLookUpImg;
import Object_Repo.CampValidation;
import Object_Repo.ContactLookUp;
import Object_Repo.ContactValidationPage;
import Object_Repo.CreateCampPage;
import Object_Repo.CreateContactPage;
import Object_Repo.HomePage;
import Object_Repo.LoginPage;

//im eng1


@Listeners(Generic_Utilities.ExtentReportImp.class)
//	@Listeners(Generic_Utilities.ListenersImp.class)
public class CreateCampaignsTest extends BaseClass {
@Test(retryAnalyzer = Generic_Utilities.RetryImp.class)
	public void createCampaignsTest() throws Throwable {

		Excel_Utility elib = new Excel_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		HomePage home = new HomePage(driver);
		home.clickCampLink();

		CampLookUpImg lookUp = new CampLookUpImg(driver);
		lookUp.clickCampLookUp();

	//	Assert.fail("im failing the script-----");

		String CampName = elib.getExcelData("Campaign", 0, 0);
		System.out.println(CampName);

		CreateCampPage camp = new CreateCampPage(driver);
		camp.enterCampDetails(CampName);

		camp.clickSaveButton();

		CampValidation validate = new CampValidation(driver);
		String actData = validate.validateCamp(driver);

		Assert.assertEquals(actData, CampName,"AssertFail");
		System.out.println("Assert pass");
	}

	
	// -------------------------------------------------------------------

	@Test(groups = "regressionTest")
	public void m2()
{
	System.out.println("Hello");
}
}
