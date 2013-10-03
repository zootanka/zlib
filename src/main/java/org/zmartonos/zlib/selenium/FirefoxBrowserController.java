package org.zmartonos.zlib.selenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirefoxBrowserController {
	private WebDriver driver;
	private FirefoxBrowser browser;
	
	public FirefoxBrowserController(final FirefoxBrowser browser){
		this.browser= browser;
		this.driver= browser.getDriver();
	}
	
	public void gotoUrl(final String url){
		driver.get(url);
	}
	
	public void fillInputField(final By by, final String value){
		WebElement element= driver.findElement(by);
		
		element.sendKeys(value);
	}
	
	public void clickElement(final By by){
		WebElement element= driver.findElement(by);
		element.click();
	}
	
	public List<WebElement> findElements(final By by){
		return driver.findElements(by);
	}
	
	public void closeAllPopups(){
		String parentWindowHandle= driver.getWindowHandle();
		WebDriver popup = null;
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows){
	      	if(!window.equals(parentWindowHandle)){
				popup= driver.switchTo().window(window);
	      		popup.close();
	      	}
		}
	    driver.switchTo().window(parentWindowHandle);
	}
}
