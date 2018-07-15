/**
 * Author: Satya 
 * Purpose: This file is the POM for signuppage
*/

package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class signuppageObjects {
	
	public WebDriver driver;
	
	By titletext            = By.xpath("//h1[contains(text(),'Sign Up')]"); 
	By fullname             = By.cssSelector("input[name = 'user[name]']");
	By emailaddress         = By.cssSelector("input[name = 'user[email]']");
	By subscriptioncheckbox = By.xpath("//*[@id='user_unsubscribe_from_marketing_emails']");
    //By.cssSelector("input[name = 'user[unsubscribe_from_marketing_emails]']");
	By password             = By.cssSelector("input[name='user[password]']"); 
	By confirmpassword      = By.cssSelector("input[name='user[password_confirmation]']");
	By termsofusecheckbox   = By.xpath("//input[@id='user_agreed_to_terms']");
	//By.cssSelector("input[name='user[agreed_to_terms]']");
	By signupbutton         = By.cssSelector("input[value='Sign Up']");
	By errormessage         = By.xpath("//*[contains(text(), 'Oops!')]");
	By emailuseerrormessage = By.xpath("//*[contains(text(), 'Email is already')]");
	By passworderrormessage = By.xpath("//*[contains(text(), 'Password confirmation')]");
	By termsofuseerrormessage = By.xpath("//*[contains(text(), 'Terms of Use and Privacy Policy')]");
	By verificationtext      = By.xpath("//*[contains(text(),'My Courses')]");
	//Oops! Please fix the following
	//You must agree to the Terms of Use and Privacy Policy
	
	public signuppageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getTitleText() {
		return driver.findElement(titletext);
	}
	
	public WebElement fullName() {
		return driver.findElement(fullname);
	}
	
	public WebElement emailAddress() {
		return driver.findElement(emailaddress);
	}
	
	public WebElement subscriptionCheckbox() {
		return driver.findElement(subscriptioncheckbox);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement confirmPassword() {
		return driver.findElement(confirmpassword);
	}
	
	public WebElement termsofuseCheckbox() {
		return driver.findElement(termsofusecheckbox);
	}
	
	public WebElement signupButton() {
		return driver.findElement(signupbutton);
	}
	
	public List<WebElement> ErrorMessage() {
		return driver.findElements(errormessage);
	}

	public List<WebElement> emailUseErrorMessage() {
		return driver.findElements(emailuseerrormessage);
	}
	
	public List<WebElement> passwordErrorMessage() {
		return driver.findElements(passworderrormessage);
	}
	
	public List<WebElement> termsErrorMessage() {
		return driver.findElements(termsofuseerrormessage);
	}
	
	public WebElement verifyingText() {
		return driver.findElement(verificationtext);
	}
	
}
