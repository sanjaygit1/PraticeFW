package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InsertDataIntoPropertiesFile {

	public static void main(String[] args) throws Throwable {
		
		Properties pro = new Properties();
		pro.setProperty("browser", "chrome");
		pro.setProperty("url", "http://localhost:8888");
	
		FileOutputStream fos = new FileOutputStream("./src/test/resources/CommonData7pm.properties");
		pro.store(fos, "StoringData");
		
//-------------------------------------------------------------------------------------------------------------------
		
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData7pm.properties");
		
		// step2:-create an object to properties class to load all the keys
		
		pro.load(fis);

		// step3:-read the value using getProperty()
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
        String PASSWORD = pro.getProperty("password");
		
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

		driver.get(URL);
	}

}
