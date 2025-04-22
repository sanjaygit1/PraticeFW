package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchingEmptyBrowser {

	public static void main(String[] args) throws Throwable {

		// HardCoding
//		WebDriver driver=new ChromeDriver();

		// step1:-get the java representation object of the physical file/path of the
		// file
//		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Downloads\\CommonData7pm.properties");
        FileInputStream fis = new FileInputStream("./src/test/resources/CommonData7pm.properties");
		
		// step2:-create an object to properties class to load all the keys
		Properties pro = new Properties();
		pro.load(fis);

		// step3:-read the value using getProperty()
		String BROWSER = pro.getProperty("browser");

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

	}

}
