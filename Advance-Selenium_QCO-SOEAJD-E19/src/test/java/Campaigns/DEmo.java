package Campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.File_Utility;
import Object_Repo.ConstructorEx;
import Object_Repo.LoginPage;

public class DEmo {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");

		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		ConstructorEx camp = new ConstructorEx(driver);
		camp.login(USERNAME, PASSWORD);

//		LoginPage login = new LoginPage(driver);
//		login.loginIntoApp(driver, USERNAME, PASSWORD);
//		driver.navigate().refresh();
//		login.getLoginButton().click();
//	
//		login.loginIntoApp(driver, USERNAME, PASSWORD);
//        login.getLoginButton().click();
	}

}
