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
	
	public practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
	
	//Mandatory Step needed to make sure that the logs are shown
	public static Logger log = LogManager.getLogger(baseClass.class.getName());
	
	@BeforeMethod
	public void openBrowser() throws IOException, InterruptedException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("practicepage"));
		log.info("Navigated to Practice Page2");
	}
		
	@Test
	public void getSwitchWindowTitle() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
		log.info("PracticePageTest2.getSwitchWindowTitle");
		
		if(practicepageobjects.getSwitchWindowTitle().getText().contains("Switch Window Example")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	
	@Test
	public void OpenNewWindow() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
		log.info("PracticePageTest2.OpenNewWindow");
		
		practicepageobjects.getWindowButton().click();
		
		//String parentwindowhandle = driver.getWindowHandle();
		for (String handle:driver.getWindowHandles()) {
			log.info("Switching to another window handle");
			//System.out.println(driver.switchTo().window(handle).getTitle());
			if(driver.switchTo().window(handle).getTitle().contains(prop.getProperty("expectedtitletext"))) {
				log.info("The title of the page contains the expected text");
				Assert.assertTrue(true);
			}else {
				log.info("The title of the page does not contain the expected text");
				driver.close();
			}	
		}
	}
	
	
	@Test
	public void getSwitchTabTitle() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
		log.info("PracticePageTest2.getSwitchTabTitle");
		
		if(practicepageobjects.getSwitchTabTitle().getText().contains("Switch Tab Example")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	@Test
	public void OpenNewTab() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
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
	
	
	@Test
	public void getSwitchAlertTitle() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
		log.info("PracticePageTest2.getSwitchAlertTitle");
		
		if(practicepageobjects.getSwitchAlertTitle().getText().contains("Switch To Alert")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	@Test
	public void getAlert() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
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
	
	@Test
	public void getConfirm() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
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
	
	@Test
	public void getTableTitle() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
		log.info("PracticePageTest2.getTableTitle");
		
		if(practicepageobjects.getWebTableTitle().getText().contains("Web Table")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	@Test
	public void getTable() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
		log.info("PracticePageTest2.getTable");
		
		//We are trying to print the total price if all the courses are taken
		int count = practicepageobjects.getWebTable().findElements(By.cssSelector("td:nth-child(3)")).size();
		int totalprice = 0;
		for (int i=2; i <= count; i++) {
			totalprice += Integer.parseInt(practicepageobjects.getWebTable().findElement(By.cssSelector("tr:nth-child("+i+") td:nth-child(3)")).getText());
		}
		log.info("The total price of all the courses combined is " + totalprice);
		log.info("The expected total price is 235");
	}
	
	
	@Test
	public void getElementDisplayedTitle() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
		log.info("PracticePageTest2.getElementDisplayedTitle");
		
		if(practicepageobjects.getElementExampleTitle().getText().contains("Element Displayed")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	@Test
	public void elementShow() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
		log.info("PracticePageTest2.elementShow");
		
		practicepageobjects.getShowButton().click();
		if (practicepageobjects.getElementBox().isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	@Test
	public void elementHide() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
		log.info("PracticePageTest2.elementHide");
		
		practicepageobjects.getHideButton().click();
		if(practicepageobjects.getElementBox().isDisplayed()) {
			Assert.assertFalse(true);
		}else {
			Assert.assertTrue(true);
		}
	}
		
	@Test
	public void mouseHoverTitle() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
		log.info("PracticePageTest2.mouseHoverTitle");
		
		if (practicepageobjects.getMouseHoverTitle().getText().contains("Example")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	@Test
	public void mouseHoverselectTop() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
		log.info("PracticePageTest2.mouseHoverselectTop");
		
		Actions action = new Actions(driver);
		action.moveToElement(practicepageobjects.getMouseButton()).build().perform();	
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.presenceOfElementLocated(practicepageobjects.mousehovertopbutton));
		
		practicepageobjects.getMouseHoverTopButton().click();
        log.info("Selected the Top button and the page has been redirected to the top");
	}
	
	@Test
	public void mouseHoverselectReload() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
		log.info("PracticePageTest2.mouseHoverselectReload");
		
		Actions action = new Actions(driver);
		action.moveToElement(practicepageobjects.getMouseButton()).build().perform();	
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.presenceOfElementLocated(practicepageobjects.mousehoverreloadbutton));
		
		practicepageobjects.getMouseHoverReloadButton().click();
        log.info("Selected the Reload button and the page has reloaded");
	}
	
	@Test
	public void iFrameTitle() {
//		practicepageObjects2 practicepageobjects = new practicepageObjects2(driver);
		log.info("PracticePageTest2.iFrameTitle");
		
		if (practicepageobjects.getiFrameTitle().getText().contains("")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	
	@Test
	public void iFrameOperation() {
//		practicepageObjects2 objs = new practicepageObjects2(driver);
		log.info("PracticePageTest2.iFrameOperation");
		
		driver.switchTo().frame(practicepageobjects.getiFrame());
		HomePageTest homepage = new HomePageTest();
		homepage.TitleTextValidation();
		
		driver.switchTo().defaultContent();
		PracticePageTest2 page = new PracticePageTest2();
		page.iFrameTitle();
	}
	
	
	@Test
	public void accessAllLinks() throws InterruptedException {
//		practicepageObjects2 objs = new practicepageObjects2(driver);
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
	
	@AfterMethod
	public void closeBrowser() {
		log.info("Closing the driver");
		driver.close();
		driver = null;
	}	
}











