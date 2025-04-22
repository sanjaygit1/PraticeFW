package DDT;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliEx {

	public static void main(String[] args) throws Throwable {

		WebDriver driver;

		Screen scr = new Screen();

		Pattern minimize = new Pattern("C:\\Users\\Shobha\\Pictures\\Screenshots\\MiniiBar.png");
		scr.click(minimize);

		Pattern searchBar = new Pattern("C:\\Users\\Shobha\\Pictures\\Screenshots\\searchBarIcon.png");
		scr.type(searchBar, "NotePad");

		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		Pattern excel = new Pattern("C:\\Users\\Shobha\\Pictures\\Screenshots\\NotePadPage1.png");
		scr.type(excel, "Hello good evening");

	}

}
