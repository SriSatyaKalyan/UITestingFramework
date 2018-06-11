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
	
	//Mandatory Step needed to make sure that the logs are shown
	public static Logger log = LogManager.getLogger(baseClass.class.getName());
	
	@BeforeMethod
	public void openBrowser() throws IOException, InterruptedException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("practicepage"));
		log.info("Navigated to Practice Page");
	}
	
    
	@Test
	public void TitleTextValidation() {
		practicepageObjects1 objs = new practicepageObjects1(driver);
		log.info("PracticePageTest.TitleTextValidation");
		
		String title_text = objs.getTitle().getText();
		String expected = "Practice Page";
		//System.out.println(title_text);
		
		if(title_text.contains(expected)) {
			log.info("Successfully validated Text Message on Practice Page");
			Assert.assertTrue(title_text.contains(expected));
		}else {
			log.error("Error in validating Text Message on Practice Page");
			Assert.assertFalse(true);
		}
	}
	
	//RadioButtons
	@Test
	public void RadioButtonTitle() {
		log.info("PracticePageTest.RadioButtonExample");
		practicepageObjects1 objs = new practicepageObjects1(driver);
		
		//System.out.println(objs.getRadioButtonTitle().getText());
		if (objs.getRadioButtonTitle().getText().contains("Radio Button")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	//Pressing Radio buttons
	@Test
	public void RadioButtons() throws IOException {
		log.info("PracticePageTest.RadioButtons");
		practicepageObjects1 objs = new practicepageObjects1(driver);

//		Random rand = new Random();	
//		int radiobuttonnumber = rand.nextInt(3)+1;
		int radiobuttonnumber = Integer.parseInt(prop.getProperty("radiobutton"));
		
		log.info("The radio button to be selected is " + radiobuttonnumber);
		
		if (radiobuttonnumber == 1) {
			if (!objs.getRadioButton1().isSelected()) {
				objs.getRadioButton1().click();
			}
		}else if (radiobuttonnumber == 2) {
			if (!objs.getRadioButton2().isSelected()) {
				objs.getRadioButton2().click();
			}
		}else {
			if (!objs.getRadioButton3().isSelected()) {
				objs.getRadioButton3().click();
			}
		}
	
		baseClass base = new baseClass();
		base.getScreenshot("Radiobuttons");
		log.info("Check the 'Radiobuttons.png' file in 'TestFailureScreenshots' folder situated in the basepath");
	}
	
	//Suggestion Class
	@Test
	public void SuggestionClassTitle() {
		log.info("PracticePageTest.SuggestionClassTitle");
		practicepageObjects1 objs = new practicepageObjects1(driver);
		
		//System.out.println(objs.getSuggestionClass().getText());
		if (objs.getSuggestionClass().getText().contains("Suggession Class")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	} 
	

	@Test
	public void getSuggestedCountry() {
		log.info("PracticePageTest.getSuggestedCountry");
		practicepageObjects1 objs = new practicepageObjects1(driver);
		log.info("Change the 'countrykeyword' and 'country' property values in the properties file accordingly");
		objs.getSuggestionBox().sendKeys(prop.getProperty("countrykeyword"));
		
		int i = 1;
		//Hoping that there won't be more than 5 suggestions when a small part of the country keyword is entered
		while(true) {
			i++;
			if(i>5) {
				log.error("The country provided was not found");
				Assert.assertFalse(true);
			}else {
				if (objs.getCountrySuggestor().get(i).getText().contains(prop.getProperty("country"))) {
					log.info("The country was found in the dropbox menu with the provided keyword");
					objs.getCountrySuggestor().get(i).click();
					Assert.assertTrue(true);
				}
			}
		}
	}
		
	//DropDown Example Title
	@Test
	public void DropDownExampleTitle() {
		log.info("PracticePageTest.DropDownExampleTitle");
		practicepageObjects1 objs = new practicepageObjects1(driver);
		
		if (objs.getDropDownTitle().getText().contains("Dropdown Example")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	
	@Test
	public void selectDropDownOptions() {
		log.info("PracticePageTest.selectDropDownOptions");
		practicepageObjects1 objs = new practicepageObjects1(driver);
		
		objs.hitDropdownmenu().click();
		
		for (int i=1;i<=3; i++) {
			if(objs.selectDropdownOptions().get(i).getText().contains(prop.getProperty("optionnumber"))) {
				log.info("Selected the required option");
				objs.selectDropdownOptions().get(i).click();
				Assert.assertTrue(true);
			}
		}
	}
	
	@Test
	public void CheckboxExampleTitle() {
		log.info("PracticePageTest.CheckboxExampleTitle");
		practicepageObjects1 objs = new practicepageObjects1(driver);
//		System.out.println(objs.getCheckboxTitle().getText());
		if (objs.getCheckboxTitle().getText().contains("Checkbox")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(true);
		}
	}
	
	@Test
	public void selectCheckbox() {
		log.info("PracticePageTest.selectCheckbox");
		practicepageObjects1 objs = new practicepageObjects1(driver);
		
		if(prop.getProperty("checkboxnumber").equals("1")) {
			objs.getCheckbox1().click();
		}else if(prop.getProperty("checkboxnumber").equals("2")) {
			objs.getCheckbox2().click();
		}else {
			objs.getCheckbox3().click();
		}
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		log.info("Closing the driver");
		driver.close();
		driver = null;
	}	
}