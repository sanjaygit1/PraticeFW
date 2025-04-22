package Campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repo.CampLookUpImg;
import Object_Repo.CampValidation;
import Object_Repo.CreateCampPage;
import Object_Repo.CreatePrdPage;
import Object_Repo.HomePage;
import Object_Repo.LoginPage;
import Object_Repo.PrdLookUpImg;
import Object_Repo.SwtichingWindowPage;

//@Test(groups = "smokeTest")
public class CreateCampWithProductTest extends BaseClass {

	public void createCampWithProductTest() throws Throwable {

		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

		HomePage home = new HomePage(driver);
		home.clickPrdLink();

		PrdLookUpImg lookUp = new PrdLookUpImg(driver);
		lookUp.clickPrdLookUp();

		int ranNum = jlib.getRandomNum();

		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(prdName);

		CreatePrdPage prdPage = new CreatePrdPage(driver);
		prdPage.enterPrdDetails(prdName);

//------------------------------------------------------------------------------------------

		home.clickCampLink();

//		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		CampLookUpImg lookUpImg = new CampLookUpImg(driver);
		lookUpImg.clickCampLookUp();

		String CampName = elib.getExcelData("Campaign", 0, 0);

		System.out.println(CampName);

		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampDetails(CampName);

		campPage.clickPrdPlusSign();

		wlib.windowSwitching(driver, "Products&action");

		SwtichingWindowPage switching = new SwtichingWindowPage(driver);
		switching.searchPrdNAme(CampName);
		switching.dynamicXpath(driver, prdName);

		Thread.sleep(2000);

		// -------------------------------------------------------------------------------------------------

		wlib.windowSwitching(driver, "Campaigns&action");
		campPage.clickSaveButton();

		CampValidation validate = new CampValidation(driver);
		validate.validateCamp(driver);
		validate.validatePrd(driver, prdName);

	}
}
