package product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repo.CreatePrdPage;
import Object_Repo.DeleteProductPage;
import Object_Repo.HomePage;
import Object_Repo.HomePage1;
import Object_Repo.LoginPage;
import Object_Repo.ProductVAlidation;

public class CreateProductAndDeletePrd {

	public static void main(String[] args) throws Throwable {

		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		WebDriver driver;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		wlib.maximizeWindow(driver);
		wlib.waitElementsToLoad(driver);
		driver.get(URL);

		LoginPage login = new LoginPage(driver);
		login.loginIntoApp(USERNAME, PASSWORD);

		HomePage1 home = new HomePage1(driver);
		home.clickPrdLink();
        home.clickLookUp();

		Java_Utility jib = new Java_Utility();
		int ranNum = jib.getRandomNum();

		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(prdName);

		CreatePrdPage prdPage = new CreatePrdPage(driver);
		prdPage.enterPrdDetails(prdName);

		ProductVAlidation validate = new ProductVAlidation(driver);
		validate.validatePrd(driver, prdName);

		home.clickPrdLink();

		DeleteProductPage deletePrd = new DeleteProductPage(driver);
		deletePrd.selectPrdCheckBox(driver, prdName);
		deletePrd.clickDeletePrdButton();

		wlib.alertAccept(driver);

		
		deletePrd.validatePrdDeleted(driver, prdName);

		HomePage home1 = new HomePage(driver);
		home1.signOut();
	}

}
