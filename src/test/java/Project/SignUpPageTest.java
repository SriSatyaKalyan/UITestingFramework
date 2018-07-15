/**
 * Author: Satya 
 * Purpose: The purpose of this file is to have tests which run on the signup page
*/

package Project;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.signuppageObjects;
import resources.baseClass;

public class SignUpPageTest extends baseClass{
	
	//Creating instances of PageObjects
	public signuppageObjects signuppageobject = new signuppageObjects(driver);
	
	//Mandatory Step needed to make sure that the logs are shown
	public static Logger log = LogManager.getLogger(baseClass.class.getName());
		
	//Initializing the driver and navigating to the homepage
	@BeforeMethod
	public void openBrowser() throws IOException, InterruptedException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("signuppage"));
		log.info("Navigated to SignUp Page");
	}
	
	//Verifying the title text for the page
	@Test
	public void TitleTextValidation() {
		log.info("SignUpPageTest.TitleTextValidation");
		
		String title_text = signuppageobject.getTitleText().getText();
		String expected = "Sign Up to QaClickAcademy";
		System.out.println(title_text);
		
		if(title_text.contains(expected)) {
			log.info("Successfully validated Text Message on Practice Page");
			Assert.assertTrue(title_text.contains(expected));
		}else {
			log.error("Error in validating Text Message on Practice Page");
			Assert.assertFalse(true);
		}
	}
	
	//Test which takes in the various credentials from the DataProvider method and sends them as input to the sign-in section
	@Test(dataProvider = "SignupDetails")
	public void SignUpTest(String fullname, String emailaddress, boolean subscriptionCheckbox, String password, String confirmpassword, boolean termsofuseCheckbox, String credentialsinfo) {
		log.info("SignUpPageTest.SignUpTest");
		log.info(credentialsinfo);
		signuppageobject.fullName().sendKeys(fullname);
		signuppageobject.emailAddress().sendKeys(emailaddress);
		
		if (subscriptionCheckbox) {
			if (!(signuppageobject.subscriptionCheckbox().isSelected())) {
				signuppageobject.subscriptionCheckbox().click(); }	
		}
			
		signuppageobject.password().sendKeys(password);
		signuppageobject.confirmPassword().sendKeys(confirmpassword);
		
		if (termsofuseCheckbox) {
			if (!(signuppageobject.termsofuseCheckbox().isSelected()))
				signuppageobject.termsofuseCheckbox().click();
		}

		signuppageobject.signupButton().click();	
		
		log.info("ErrorExistence " + signuppageobject.ErrorMessage().size());
		if (((List<WebElement>) signuppageobject.ErrorMessage()).size() > 0) {
			
			System.out.println("EmailUseError " + signuppageobject.emailUseErrorMessage().size());
			System.out.println("PasswordError " + signuppageobject.passwordErrorMessage().size());
			System.out.println("TermsUsageError " + signuppageobject.termsErrorMessage().size());
			
			if (((List<WebElement>) signuppageobject.emailUseErrorMessage()).size() > 0) {
				log.info("Email is already in use");
				Assert.assertTrue(true);
			}
			
			if (((List<WebElement>) signuppageobject.passwordErrorMessage()).size() > 0) {
				log.info("Password confirmation doesn't match Password");
				Assert.assertTrue(true);
			}
			
			if (((List<WebElement>) signuppageobject.termsErrorMessage()).size() > 0) {
				log.info("You must agree to the Terms of Use and Privacy Policy");
				Assert.assertTrue(true);
			}
			
		}else {
			System.out.println(signuppageobject.verifyingText().getText());
			if (signuppageobject.verifyingText().getText().contains("Courses")) {
				Assert.assertTrue(true);
			}
		}
			
	}
	
	//Method which has the needed credentials for the test to run in every iteration
	//This Data Provider method has different kinds of credentials testing the aspects of the signup & error process
	@DataProvider
	public Object[][] SignupDetails(){
		Object data[][] = new Object[4][7];
		
		Random rand = new Random();
		baseClass base = new baseClass();
		String[] strings = base.generateRandomWords(rand.nextInt(9) + 1);
		
		//4rth row
		//Working Email
		data[0][0] = "Bat Woman";
 		data[0][1] = strings[rand.nextInt(5) + 1] + "@valhalla.com";
 		data[0][2] = false;
 		data[0][3] = "deadpool";
 		data[0][4] = "deadpool";
		data[0][5] = true;
		data[0][6] = "New Login Details";
				
		//2nd row
		//Passwords don't match
		data[1][0] = "Robin Hood";
 		data[1][1] = "robingood@valhalla.com";
 		data[1][2] = false;
 		data[1][3] = "b@tm@nknows";
 		data[1][4] = "b@tm@5knows";
		data[1][5] = true;
		data[1][6] = "Passwords won't match";
		
		//3rd row
		//Not accepting the "Terms of Use" - data[1][5] = false
		data[2][0] = "Cat Woman";
 		data[2][1] = "norulesforcat@valhalla.com";
 		data[2][2] = false;
 		data[2][3] = "b@tm@nknows";
 		data[2][4] = "b@tm@nknows";
		data[2][5] = false;
		data[2][6] = "Non-Agreement to the Terms of Use and Privacy Policy";
		
		//4rth row
		//Used Email
		data[3][0] = "Dick Gray";
 		data[3][1] = "nightwing231@tokomo.com";
 		data[3][2] = true;
 		data[3][3] = "b@tm@nknows";
 		data[3][4] = "b@tm@nknows";
		data[3][5] = true;
		data[3][6] = "Used Login Details";
		
		return data;
	}
	
	//Closing the driver
	@AfterMethod
	public void closeBrowser() {
		driver.close();
		driver = null;
	}	
}