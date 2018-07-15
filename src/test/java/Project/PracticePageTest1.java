/**
 * Author: Satya 
 * Purpose: The purpose of this file is to have tests which run on the practice page
*/

package Project;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.practicepageObjects1;
import resources.baseClass;

public class PracticePageTest1 extends baseClass{
	
	//Creating instances of PageObjects
	public practicepageObjects1 practicepageobjects = new practicepageObjects1(driver);
	
	//Mandatory Step needed to make sure that the logs are shown
	public static Logger log = LogManager.getLogger(baseClass.class.getName());
	
	//Initializing the driver and navigating to the practicepage
	@BeforeMethod
	public void openBrowser() throws IOException, InterruptedException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("practicepage"));
		log.info("Navigated to Practice Page");
	}
	
    //Validating the title text 
	@Test
	public void TitleTextValidation() {
		log.info("PracticePageTest.TitleTextValidation");
		
		if(practicepageobjects.getTitle().getText().contains("Practice Page")) {
			log.info("Successfully validated Text Message on Practice Page");
			Assert.assertTrue(practicepageobjects.getTitle().getText().contains("Practice Page"));
		}else {
			log.error("Error in validating Text Message on Practice Page");
			Assert.assertFalse(true);
		}
	}
	
	//Validating the title on the RadioButtons section
	@Test
	public void RadioButtonTitle() {
		log.info("PracticePageTest.RadioButtonExample");

		if (practicepageobjects.getRadioButtonTitle().getText().contains("Radio Button")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	//Pressing Radio buttons
	@Test
	public void RadioButtons() throws IOException {
		log.info("PracticePageTest.RadioButtons");

		int radiobuttonnumber = Integer.parseInt(prop.getProperty("radiobutton"));
		
		log.info("The radio button to be selected is " + radiobuttonnumber);
		
		if (radiobuttonnumber == 1) {
			if (!practicepageobjects.getRadioButton1().isSelected()) {
				practicepageobjects.getRadioButton1().click();
			}
		}else if (radiobuttonnumber == 2) {
			if (!practicepageobjects.getRadioButton2().isSelected()) {
				practicepageobjects.getRadioButton2().click();
			}
		}else {
			if (!practicepageobjects.getRadioButton3().isSelected()) {
				practicepageobjects.getRadioButton3().click();
			}
		}
	
		baseClass base = new baseClass();
		base.getScreenshot("Radiobuttons");
		log.info("Check the 'Radiobuttons.png' file in 'TestFailureScreenshots' folder situated in the basepath");
	}
	
	//Validating the title text for Suggestion Class section
	@Test
	public void SuggestionClassTitle() {
		log.info("PracticePageTest.SuggestionClassTitle");

		if (practicepageobjects.getSuggestionClass().getText().contains("Suggession Class")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	} 
	
	//Test performed to get the suggested country. Check the test carefully for better understanding
	@Test
	public void getSuggestedCountry() {
		log.info("PracticePageTest.getSuggestedCountry");
		log.info("Change the 'countrykeyword' and 'country' property values in the properties file accordingly");
		practicepageobjects.getSuggestionBox().sendKeys(prop.getProperty("countrykeyword"));
		
		int i = 1;
		//Hoping that there won't be more than 5 suggestions when a small part of the country keyword is entered
		while(true) {
			i++;
			if(i>5) {
				log.error("The country provided was not found");
				Assert.assertFalse(true);
			}else {
				if (practicepageobjects.getCountrySuggestor().get(i).getText().contains(prop.getProperty("country"))) {
					log.info("The country was found in the dropbox menu with the provided keyword");
					practicepageobjects.getCountrySuggestor().get(i).click();
					Assert.assertTrue(true);
				}
			}
		}
	}
		
	//Verifying the title text for the DropDown Example section
	@Test
	public void DropDownExampleTitle() {
		log.info("PracticePageTest.DropDownExampleTitle");

		if (practicepageobjects.getDropDownTitle().getText().contains("Dropdown Example")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	//Test performing the selection of DropDown options and selecting one of them
	@Test
	public void selectDropDownOptions() {
		log.info("PracticePageTest.selectDropDownOptions");

		practicepageobjects.hitDropdownmenu().click();
		
		for (int i=1;i<=3; i++) {
			if(practicepageobjects.selectDropdownOptions().get(i).getText().contains(prop.getProperty("optionnumber"))) {
				log.info("Selected the required option");
				practicepageobjects.selectDropdownOptions().get(i).click();
				Assert.assertTrue(true);
			}
		}
	}
	
	//Verifying the title text for the Checkbox Example section
	@Test
	public void CheckboxExampleTitle() {
		log.info("PracticePageTest.CheckboxExampleTitle");

		if (practicepageobjects.getCheckboxTitle().getText().contains("Checkbox")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	//Selecting a particular checkbox which is random number between 1,2 and 3
	@Test
	public void selectCheckbox() {
		log.info("PracticePageTest.selectCheckbox");

		if(prop.getProperty("checkboxnumber").equals("1")) {
			practicepageobjects.getCheckbox1().click();
		}else if(prop.getProperty("checkboxnumber").equals("2")) {
			practicepageobjects.getCheckbox2().click();
		}else {
			practicepageobjects.getCheckbox3().click();
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