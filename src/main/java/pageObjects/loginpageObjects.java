/**
 * Author: Satya 
 * Purpose: This file is the POM for loginpage
*/

package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class loginpageObjects {
	
	public WebDriver driver;
	
	By logInSelect = By.xpath("//*[text()='Login']");
	By emailBox    = By.xpath("//input[@type='email']");
	By passwordBox = By.xpath("//input[@type='password']");
	By loginButton = By.xpath("//input[@type='submit']");
	By titletext = By.xpath("//h1[contains(text(),'Log In')]");
	By errormessage = By.xpath("//div[contains(text(), 'Invalid email or password')]");
	By forgotpasswordbutton = By.xpath("//a[contains(text(), 'Forgot Password?')]");
	By resetpasswordbutton = By.xpath("//h1[contains(text(), 'Reset Password')]");
	By instructionsbutton = By.xpath("//input[@value='Send Me Instructions']");
	By resetemailBox    = By.xpath("//input[@id='user_email']");
	By invalidemailerrormessage = By.xpath("//span[contains(text(),'find an account')]");
	
	public loginpageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement selectLogin() {
		return driver.findElement(logInSelect);
	}
	
	public WebElement emailId() {
		return driver.findElement(emailBox);
	}
	
	public WebElement passwordId() {
		return driver.findElement(passwordBox);
	}
	
	public WebElement clickLogin() {
		return driver.findElement(loginButton);
	}
	
	public WebElement getTitleText() {
		return driver.findElement(titletext);
	}
	
	public List<WebElement> getErrorMessage() {
		return driver.findElements(errormessage);
	}
	
	public WebElement getForgotPassword() {
		return driver.findElement(forgotpasswordbutton);
	}
	
	public List<WebElement> getResetPassword() {
		return driver.findElements(resetpasswordbutton);
	}
	
	public WebElement sendInstructions() {
		return driver.findElement(instructionsbutton);
	}
	
	public WebElement getresetemailId() {
		return driver.findElement(resetemailBox);
	}
	
	public List<WebElement> getInvalidEmailError() {
		return driver.findElements(invalidemailerrormessage);
	}
	
}
