/**
 * Author: Satya 
 * Purpose: The purpose of this file is to have tests which run on the practice page
*/

package Project;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.practicepageObjects2;
import resources.baseClass;

public class PracticePageTest2 extends baseClass{
	
	//Creating instances of PageObjects
	public practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
	
	//Mandatory Step needed to make sure that the logs are shown
	public static Logger log = LogManager.getLogger(baseClass.class.getName());
	
	//Initializing the driver and navigating to the practicepage
	@BeforeMethod
	public void openBrowser() throws IOException, InterruptedException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("practicepage"));
		log.info("Navigated to Practice Page2");
	}
	
	//Verifying the title text for the SwitchWindow section
	@Test
	public void getSwitchWindowTitle() {
		log.info("PracticePageTest2.getSwitchWindowTitle");
		
		if(practicepageobjects.getSwitchWindowTitle().getText().contains("Switch Window Example")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	//Test checking if a new window will be opened if the necessary actions are performed
	@Test
	public void OpenNewWindow() {
		log.info("PracticePageTest2.OpenNewWindow");
		
		practicepageobjects.getWindowButton().click();
		
		//Loop performing the iteratio between various window handles and getting the expected title
		for (String handle:driver.getWindowHandles()) {
			log.info("Switching to another window handle");
			
			if(driver.switchTo().window(handle).getTitle().contains(prop.getProperty("expectedtitletext"))) {
				log.info("The title of the page contains the expected text");
				Assert.assertTrue(true);
			}else {
				log.info("The title of the page does not contain the expected text");
				driver.close();
			}	
		}
	}
	
	//Verifying the title text for the SwitchTab section
	@Test
	public void getSwitchTabTitle() {
		log.info("PracticePageTest2.getSwitchTabTitle");
		
		if(practicepageobjects.getSwitchTabTitle().getText().contains("Switch Tab Example")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	//Test checking if a new tab will be opened when the necessary actions are performed
	@Test
	public void OpenNewTab() {
		log.info("PracticePageTest2.OpenNewTab");
		
		practicepageobjects.getTabButton().click();
		
		//Handling the tabs
		Set<String> windowids = driver.getWindowHandles();
		Iterator<String> iterator = windowids.iterator();
		
		String oldwindowid = iterator.next();
		String newwindowid = iterator.next();
		if(driver.switchTo().window(newwindowid).getTitle().contains(prop.getProperty("expectedtabtitle"))) {
			log.info("The title of the new tab contains the expected text");
			Assert.assertTrue(true);
		}else {
			log.info("The title of the new tab does not contain the expected text");
			Assert.assertFalse(true);
		}	
	}
	
	//Verifying the title text for the SwitchAlert section
	@Test
	public void getSwitchAlertTitle() {
		log.info("PracticePageTest2.getSwitchAlertTitle");
		
		if(practicepageobjects.getSwitchAlertTitle().getText().contains("Switch To Alert")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	//Test where we check if the alert box is opening as intended and if it is being dismissed
	@Test
	public void getAlert() {
		log.info("PracticePageTest2.getAlert");
		
		practicepageobjects.getAlertNameBox().sendKeys(prop.getProperty("alertname1"));
		practicepageobjects.clickAlertBox().click();
		
		if (driver.switchTo().alert().getText().contains(prop.getProperty("alertname1"))) {
			driver.switchTo().alert().dismiss();
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	//Test where we check if the alert box is opening as intended and if it is being confirmed
	@Test
	public void getConfirm() {
		log.info("PracticePageTest2.getConfirm");
			
		practicepageobjects.getAlertNameBox().sendKeys(prop.getProperty("alertname2"));
		practicepageobjects.clickConfirmBox().click();
		
		if (driver.switchTo().alert().getText().contains(prop.getProperty("alertname2"))) {
			driver.switchTo().alert().dismiss();
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	////Verifying the title text for the Table section
	@Test
	public void getTableTitle() {
		log.info("PracticePageTest2.getTableTitle");
		
		if(practicepageobjects.getWebTableTitle().getText().contains("Web Table")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	//Test validating the total price produced if all the courses are taken
	@Test
	public void getTable() {
		log.info("PracticePageTest2.getTable");
		
		int count = practicepageobjects.getWebTable().findElements(By.cssSelector("td:nth-child(3)")).size();
		int totalprice = 0;
		for (int i=2; i <= count; i++) {
			totalprice += Integer.parseInt(practicepageobjects.getWebTable().findElement(By.cssSelector("tr:nth-child("+i+") td:nth-child(3)")).getText());
		}
		log.info("The total price of all the courses combined is " + totalprice);
		log.info("The expected total price is 235");
	}
	
	//Verifying the title text for the ElementDisplayed section
	@Test
	public void getElementDisplayedTitle() {
		log.info("PracticePageTest2.getElementDisplayedTitle");
		
		if(practicepageobjects.getElementExampleTitle().getText().contains("Element Displayed")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	//Test checking if the required element can be displayed
	@Test
	public void elementShow() {
		log.info("PracticePageTest2.elementShow");
		
		practicepageobjects.getShowButton().click();
		if (practicepageobjects.getElementBox().isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	//Test checking if the required element can be hidden
	@Test
	public void elementHide() {
		log.info("PracticePageTest2.elementHide");
		
		practicepageobjects.getHideButton().click();
		if(practicepageobjects.getElementBox().isDisplayed()) {
			Assert.assertFalse(true);
		}else {
			Assert.assertTrue(true);
		}
	}
	
	//Verifying the title text for the MouseHover section
	@Test
	public void mouseHoverTitle() {
		log.info("PracticePageTest2.mouseHoverTitle");
		
		if (practicepageobjects.getMouseHoverTitle().getText().contains("Example")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	//Test checking if the mouse hovering actioncan be performed and a required selection can be made	
	@Test
	public void mouseHoverselectTop() {
		log.info("PracticePageTest2.mouseHoverselectTop");
		
		Actions action = new Actions(driver);
		action.moveToElement(practicepageobjects.getMouseButton()).build().perform();	
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.presenceOfElementLocated(practicepageobjects.mousehovertopbutton));
		
		practicepageobjects.getMouseHoverTopButton().click();
        log.info("Selected the Top button and the page has been redirected to the top");
	}
	
	//Test checking if the mouse hovering actioncan be performed and a required selection can be made
	@Test
	public void mouseHoverselectReload() {
		log.info("PracticePageTest2.mouseHoverselectReload");
		
		Actions action = new Actions(driver);
		action.moveToElement(practicepageobjects.getMouseButton()).build().perform();	
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.presenceOfElementLocated(practicepageobjects.mousehoverreloadbutton));
		
		practicepageobjects.getMouseHoverReloadButton().click();
        log.info("Selected the Reload button and the page has reloaded");
	}
	
	//Verifying the title text for the iFrame section
	@Test
	public void iFrameTitle() {
		log.info("PracticePageTest2.iFrameTitle");
		
		if (practicepageobjects.getiFrameTitle().getText().contains("")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	//Test checking if an operation can be performed on the frame
	@Test
	public void iFrameOperation() {
		log.info("PracticePageTest2.iFrameOperation");
		
		driver.switchTo().frame(practicepageobjects.getiFrame());
		HomePageTest homepage = new HomePageTest();
		homepage.TitleTextValidation();
		
		driver.switchTo().defaultContent();
		PracticePageTest2 page = new PracticePageTest2();
		page.iFrameTitle();
	}
	
	//Test checking if all the links in the page can be opened at a time
	@Test
	public void accessAllLinks() throws InterruptedException {
		log.info("PracticePageTest2.accessAllLinks");
		
		WebElement linksset = practicepageobjects.getLinksBox(); //footer_driver
		int linkscount = practicepageobjects.getNumberofLinks();
		
		for (int i=0; i < linkscount; i++) {
			String openlinkkeys = Keys.chord(Keys.CONTROL, Keys.ENTER);
			linksset.findElements(By.tagName("a")).get(i).sendKeys(openlinkkeys);
			Thread.sleep(2000);
		}
		
		Set<String> tabset = driver.getWindowHandles();
		Iterator<String> iterator = tabset.iterator();
		
		log.info("The pages will be Practice Page, ApacheJMeter, Appium, SOAPUI and REST API");
		log.info("The iteration has begun");
		while(iterator.hasNext()) {
			driver.switchTo().window(iterator.next());
			log.info(driver.getTitle());
		}
	}
	
	//Closing the driver
	@AfterMethod
	public void closeBrowser() {
		log.info("Closing the driver");
		driver.close();
		driver = null;
	}	
}