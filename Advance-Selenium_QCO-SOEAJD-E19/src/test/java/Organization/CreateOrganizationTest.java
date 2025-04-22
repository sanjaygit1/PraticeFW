package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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
import Object_Repo.CreateOrganizationPAge;
import Object_Repo.HomePage;
import Object_Repo.LoginPage;
import Object_Repo.OrgLookUpImg;
import Object_Repo.OrgValidate;

public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "sanityTest")
	public void createOrganizationTest() throws Throwable {

		HomePage home = new HomePage(driver);
		home.clickOrgLink();

		OrgLookUpImg lookUp = new OrgLookUpImg(driver);
		lookUp.getOrgLookUp().click();

		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String orgName = elib.getExcelData("Organization", 0, 0) + ranNum;
		String phnNum = elib.getExcelDataUsingFormatter("Organization", 1, 0);
		String emailId = elib.getExcelDataUsingFormatter("Organization", 2, 0);

		CreateOrganizationPAge org = new CreateOrganizationPAge(driver);
		org.enterOrgDetails(orgName, phnNum, emailId);
		org.clickSaveButton();

		OrgValidate validate = new OrgValidate(driver);
		validate.validateOrg(driver, orgName);

	}

}
