/**
 * Author: Satya 
 * Purpose: This (first)file is the POM for practicepage
*/

package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Project.listeners;

public class practicepageObjects1 {
	
	public WebDriver driver;
	By page                   = By.xpath("//a[@href='practice.php']");
	By title                  = By.xpath("//h1[text() = 'Practice Page']");
	By radiobuttonexample     = By.xpath("//*[contains(text(),'Radio Button')]");
	By suggestionclassexample = By.xpath("//*[contains(text(),'Suggession Class')]");
	By radiobutton1           = By.xpath("//input[@value='radio1']");
	By radiobutton2           = By.xpath("//input[@value='radio2']");
	By radiobutton3           = By.xpath("//input[@value='radio3']");
	By suggestionbox          = By.xpath("//input[@type='text'] [@placeholder='Select Countries']");
	By countrysuggestor       = By.xpath("(//li[@class='ui-menu-item'])");
	By dropdownexample        = By.xpath("//*[contains(text(), 'Dropdown Example')]");
	By dropdown               = By.xpath("//select[@id='dropdown-class-example']");
	By optionselector         = By.xpath("//*[contains(text(),'Option')]");
	By checkboxexample        = By.xpath("//*[contains(text(),'Checkbox')]");
	By checkbox1              = By.id("checkBoxOption1");
	By checkbox2              = By.id("checkBoxOption2");
	By checkbox3              = By.id("checkBoxOption3");
	
	public practicepageObjects1(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getPage() {
		return driver.findElement(page);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getRadioButtonTitle() {
		return driver.findElement(radiobuttonexample);
	}
	
	public WebElement getRadioButton1() {
		return driver.findElement(radiobutton1);
	}
	
	public WebElement getRadioButton2() {
		return driver.findElement(radiobutton2);
	}
	
	public WebElement getRadioButton3() {
		return driver.findElement(radiobutton3);
	}
	
	public WebElement getSuggestionClass() {
		return driver.findElement(suggestionclassexample);
	}
	
	public WebElement getSuggestionBox() {
		return driver.findElement(suggestionbox);
	}
	
	public List<WebElement> getCountrySuggestor() {
		return driver.findElements(countrysuggestor);
	}
	
	public WebElement getDropDownTitle() {
		return driver.findElement(dropdownexample);
	}
	
	public WebElement hitDropdownmenu() {
		return driver.findElement(dropdown);
	}
	
	public List<WebElement> selectDropdownOptions() {
		return driver.findElements(optionselector);
	}
	
	public WebElement getCheckboxTitle() {
		return driver.findElement(checkboxexample);
	}
	
	public WebElement getCheckbox1() {
		return driver.findElement(checkbox1);
	}
	
	public WebElement getCheckbox2() {
		return driver.findElement(checkbox2);
	}
	
	public WebElement getCheckbox3() {
		return driver.findElement(checkbox3);
	}
}






















