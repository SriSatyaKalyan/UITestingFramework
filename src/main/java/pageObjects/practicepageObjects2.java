/**
 * Author: Satya 
 * Purpose: This (second)file is the POM for practicepage
*/

package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class practicepageObjects2 {
	
	public WebDriver driver;
	
	By switchwindowtitle       = By.xpath("//*[contains(text(),'Switch Window')]");
	By openwindowbutton        = By.id("openwindow");
	By switchtabtitle          = By.xpath("//*[contains(text(),'Switch Tab')]");
	By opentabbutton           = By.id("opentab");
	By switchalerttitle        = By.xpath("//*[contains(text(),'Switch To Alert')]");
	By alertnamebox            = By.xpath("//input[@name='enter-name']");
	By alertbox                = By.id("alertbtn");
	By confirmbox              = By.id("confirmbtn");
	By webtabletitle           = By.xpath("//*[contains(text(),'Web Table Example')]");
	By webtable                = By.xpath("//table[@class='table-display']");
	By elementexampletitle     = By.xpath("//*[contains(text(),'Element Displayed Example')]");
	By hidebutton              = By.id("hide-textbox");
	By showbutton              = By.id("show-textbox");
	By displayelement          = By.id("displayed-text");
	By mousehovertitle         = By.xpath("//*[contains(text(),'Mouse Hover')]");
	By mousehoverbutton        = By.id("mousehover");
	public By mousehovertopbutton     = By.xpath("//*[contains(text(),'Top')]");
	public By mousehoverreloadbutton  = By.xpath("//*[contains(text(),'Reload')]");
	By iframetitle             = By.xpath("//*[contains(text(),'iFrame')]");
	By iframeobject            = By.id("courses-iframe");
	By iframetext              = By.xpath("//div[@class='text-center']");
	By linksbox                = By.xpath("//*[@id='gf-BIG']/table/tbody/tr/td[1]/ul");
	
	public WebElement getAlertNameBox() {
		return driver.findElement(alertnamebox);
	}
	
	public WebElement clickAlertBox() {
		return driver.findElement(alertbox);
	}
	
	public WebElement clickConfirmBox() {
		return driver.findElement(confirmbox);
	}
	
	public practicepageObjects2(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSwitchWindowTitle() {
		return driver.findElement(switchwindowtitle);
	}
	
	public WebElement getWindowButton() {
		return driver.findElement(openwindowbutton);
	}

	public WebElement getSwitchTabTitle() {
		return driver.findElement(switchtabtitle);
	}
	
	public WebElement getTabButton() {
		return driver.findElement(opentabbutton);
	}

	public WebElement getSwitchAlertTitle() {
		return driver.findElement(switchalerttitle);
	}

	public WebElement getWebTableTitle() {
		return driver.findElement(webtabletitle);
	}
	
	public WebElement getWebTable() {
		return driver.findElement(webtable);
	}

	public WebElement getElementExampleTitle() {
		return driver.findElement(elementexampletitle);
	}
	
	public WebElement getHideButton() {
		return driver.findElement(hidebutton);
	}
	
	public WebElement getShowButton() {
		return driver.findElement(showbutton);
	}
	
	public WebElement getElementBox() {
		return driver.findElement(displayelement);
	}
	
	public WebElement getMouseHoverTitle() {
		return driver.findElement(mousehovertitle);
	}
	
	public WebElement getMouseButton() {
		return driver.findElement(mousehoverbutton);
	}
	
	public WebElement getMouseHoverTopButton() {
		return driver.findElement(mousehovertopbutton);
	}
	
	public WebElement getMouseHoverReloadButton() {
		return driver.findElement(mousehoverreloadbutton);
	}
	
	public WebElement getiFrameTitle() {
		return driver.findElement(iframetitle);
	}
	
	public WebElement getiFrame() {
		return driver.findElement(iframeobject);
	}
	
	public WebElement getiFrameText() {
		return driver.findElement(iframetext);
	}
	
	public WebElement getLinksBox() {
		return driver.findElement(linksbox);
	}
	
	public int getNumberofLinks() {
		practicepageObjects2 objs = new practicepageObjects2(driver);
		return objs.getLinksBox().findElements(By.tagName("a")).size();
	}	
}
