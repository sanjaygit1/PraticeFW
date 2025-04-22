package Object_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConstructorEx 
{
	 private WebDriver driver;

	    // Locators
	    private By usernameField = By.name("user_name");
	    private By passwordField = By.name("user_password");
	    private By loginButton = By.id("submitButton");

	    // Constructor
	    public ConstructorEx(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Methods to interact with the elements
	    public void enterUsername(String username) {
	        WebElement usernameInput = driver.findElement(usernameField);
	     //   usernameInput.clear();
	        usernameInput.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        WebElement passwordInput = driver.findElement(passwordField);
	    //    passwordInput.clear();
	        passwordInput.sendKeys(password);
	    }

	    public void clickLoginButton() {
	        driver.findElement(loginButton).click();
	    }

	    // Method to perform a full login operation
	    public void login(String username, String password) {
	        enterUsername(username);
	        enterPassword(password);
	   //     driver.navigate().refresh();
	        clickLoginButton();
	        
}}