package org.zmartonos.zlib.selenium;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * 
 * @author zootanka
 *
 */
public class FirefoxBrowser {
	WebDriver driver;

	public FirefoxBrowser(final String firefoxBinaryLocation, final String profileDir){
		FirefoxProfile profile= new FirefoxProfile(new File(profileDir));
		FirefoxBinary binary= new FirefoxBinary(new File(firefoxBinaryLocation));
		driver= new FirefoxDriver(binary,profile);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
