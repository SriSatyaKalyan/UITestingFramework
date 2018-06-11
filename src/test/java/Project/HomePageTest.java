package Project;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.homepageObjects;
import resources.baseClass;

public class HomePageTest extends baseClass{
	
	//Mandatory Step needed to make sure that the logs are shown
	public static Logger log = LogManager.getLogger(baseClass.class.getName());
	
	//Declaring an instance of the objects page here
	//homepageObjects objs = new homepageObjects(driver);
	
	@BeforeClass
	public void openBrowser() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("homepage"));
		log.info("Navigated to HomePage");
	}
	
	@Test
	public void PopupPresence() {
		log.info("HomePageTest.PopupPresence");
		homepageObjects objs = new homepageObjects(driver);
		
		//Code snippet to get the popup out of the page
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(objs.findPopup()));
		//System.out.println("Popup visible");
		wait.until(ExpectedConditions.elementToBeClickable(objs.findNoThanks()));
		objs.getNoThanksbutton().click();
		
		System.out.println(driver.switchTo().alert().getText());
	}
	
	@Test
	public void TitleTextValidation() {	
		log.info("HomePageTest.TitleTextValidation");
		homepageObjects objs = new homepageObjects(driver);
				
		String title_text = objs.getTitle().getText();
		String expected = "FEATURED COURSES";
//		System.out.println(title_text);
		
		if(title_text.contains(expected)) {
			log.info("Successfully validated Text Message on Home Page");
			Assert.assertTrue(true);
		}else {
			log.error("Error in validating Text Message on Home Page");
			Assert.assertFalse(true);
		}
	}
	
	@Test
	public void NavigationBarPresence() {
		log.info("HomePageTest.NavigationBarPresence");
		homepageObjects objs = new homepageObjects(driver);
		Assert.assertTrue(objs.getNavigationBar().isDisplayed());
		log.info("Validated presence of Navigation Bar");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		driver = null;
	}
}