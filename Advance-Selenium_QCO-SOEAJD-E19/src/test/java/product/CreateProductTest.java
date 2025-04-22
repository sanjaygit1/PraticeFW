package product;

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
import Object_Repo.CreateCampPage;
import Object_Repo.CreatePrdPage;
import Object_Repo.HomePage;
import Object_Repo.LoginPage;
import Object_Repo.PrdLookUpImg;
import Object_Repo.ProductVAlidation;

@Listeners(Generic_Utilities.ExtentReportImp.class)
public class CreateProductTest extends BaseClass {

	@Test(groups = {"regressionTest"})
public void createProductTest()	 throws Throwable {
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();


		HomePage home = new HomePage(driver);
		home.clickPrdLink();

		PrdLookUpImg lookUp = new PrdLookUpImg(driver);
		lookUp.clickPrdLookUp();

		String prdName = elib.getExcelData("Product", 0, 0);
		System.out.println(prdName);

		CreatePrdPage prdPage = new CreatePrdPage(driver);
		prdPage.enterPrdDetails(prdName);

	//	Assert.fail("im failing the script");
		ProductVAlidation validate = new ProductVAlidation(driver);
		validate.validatePrd(driver, prdName);

	
	}

}
