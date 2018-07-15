/**
 * Author: Satya 
 * Purpose: This file is the POM for homepage
*/

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homepageObjects {
	
	public WebDriver driver;
	By loginbutton = By.cssSelector("a[href*='sign_in']");
	By title       = By.xpath("//*[@id=\"content\"]/div/div/h2");
	By navigationbar = By.xpath("//nav[@class='navbar-collapse collapse']");
	By popup        =  By.xpath("//div[@class='sumome-react-wysiwyg-popup-animation-group']");
	By nothanks = By.xpath("//div[@class='sumome-react-wysiwyg-component sumome-react-wysiwyg-popup-button sumome-react-wysiwyg-button'] //*[contains(text(),'THANKS')]");
	By nothanksbutton    = By.xpath("//div[@class='sumome-react-wysiwyg-component sumome-react-wysiwyg-popup-button sumome-react-wysiwyg-button']//*[contains(text(),'THANKS')]");
	
	
	public homepageObjects(WebDriver driver) {
	// TODO Auto-generated constructor stub
		this.driver = driver;		
	}
	
	public WebElement getLogin() {
		return driver.findElement(loginbutton);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navigationbar);
	}
	
	public By findPopup() {
		return popup;
	}
	
	public By findNoThanks() {
		return nothanks;
	}
	
	public WebElement getNoThanksbutton() {
		return driver.findElement(nothanksbutton);
	}
}