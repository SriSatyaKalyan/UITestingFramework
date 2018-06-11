package Project;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.homepageObjects;
import pageObjects.loginpageObjects;
import resources.baseClass;

public class LoginPageTest extends baseClass {
	
	//Mandatory Step needed to make sure that the logs are shown
	public static Logger log = LogManager.getLogger(baseClass.class.getName());
	
	@BeforeMethod
	public void openBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("homepage"));
		log.info("Navigated to Home Page");
	}
		
	@Test
	public void LoginButton() {	
		log.info("LoginPageTest.LoginButton");
		loginpageObjects objs = new loginpageObjects(driver);
		homepageObjects objs2 = new homepageObjects(driver);
		
		//Code snippet to get the popup out of the page
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(objs2.findPopup()));
		//System.out.println("Popup visible");
		wait.until(ExpectedConditions.elementToBeClickable(objs2.findNoThanks()));
		objs2.getNoThanksbutton().click();
		
		objs.selectLogin().click();
		String title_text = objs.getTitleText().getText();
		//System.out.println(title_text);
		String expected = "Log In to QaClickAcademy";
		
		if (title_text.contains(expected)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}

	@Test(dataProvider = "LoginDetails")
	public void LoginDetails(String username, String password, String text) throws IOException {
		log.info("LoginPageTest.LoginDetails");
		loginpageObjects objs = new loginpageObjects(driver);
		driver.navigate().to(prop.getProperty("loginpage"));
		
		log.info("LoginPageTest.LoginDetails");
		log.info(text);
		
		objs.emailId().sendKeys(username);
		objs.passwordId().sendKeys(password);
		objs.clickLogin().click();
		
		if(objs.getErrorMessage().size() > 0) {
			log.info("Expected Error Message - Credentials Invalid");
			Assert.assertTrue(true);
		}
	}
	
	@DataProvider
	public Object[][] LoginDetails() {
		Object data[][] = new Object[2][3];
		
		//1st row
		data[0][0]      = "pratyusha321@gmail.com";
		data[0][1]      = "123456";
		data[0][2]      = "Restricted User";
		
		//2nd Row
		data[1][0]      = "batman@gotham.com";
		data[1][1]      = "123456";
		data[1][2]      = "UnRestricted User";
		
		return data;
	}
	
	@Test
	public void ForgotPassword() {
		log.info("LoginPageTest.ForgotPassword");
		loginpageObjects objs = new loginpageObjects(driver);
		driver.navigate().to(prop.getProperty("loginpage"));
		
		objs.getForgotPassword().click();
		
		if(objs.getResetPassword().size() > 0) {
			log.info("Reset Password button is present");
			Assert.assertTrue(true);
		}else {
			log.error("Reset Password button is not present");
			Assert.assertFalse(true);
		}
	}
	
	@Test
	public void SendInstructions() {
		log.info("LoginPageTest.SendInstructions");
		loginpageObjects objs = new loginpageObjects(driver);
		driver.navigate().to(prop.getProperty("loginpage"));
		
		objs.getForgotPassword().click();
		//System.out.println("Clicked Forgot Password button");
		
		Actions action = new Actions(driver);
		//If there is any error, it would be in prop.getProperty function
		action.moveToElement(objs.getresetemailId()).sendKeys(prop.getProperty("randomemail")).build().perform();
		action.moveToElement(objs.sendInstructions()).click().build().perform();
		//I am struggling because I want to hit "Enter" instead of the "Send Instructions" button
		if (objs.getInvalidEmailError().size() > 0) {
			log.info("The invalid error message is present");
			Assert.assertTrue(true);
		}else {
			log.error("The invalid error message is not present");
			Assert.assertFalse(true);
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
		driver = null;
	}
}
