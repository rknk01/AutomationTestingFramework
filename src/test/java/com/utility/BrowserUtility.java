package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver>  driver=new ThreadLocal<WebDriver>();
	Logger logger=LogManager.getLogger(this.getClass());
	
	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
	
	public BrowserUtility(Browser browserName) {
		logger.info("Launching the Browser :"+browserName);
		if(browserName==Browser.CHROME) {
			driver.set(new ChromeDriver());
		}
		else if(browserName==Browser.EDGE) {
			driver.set(new EdgeDriver());
		}
		else if(browserName==Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
		else {
			System.err.println("Invalid browser name...");
		}
	}
	
	public BrowserUtility(Browser browserName,boolean isHeadlessMode) {
		logger.info("Launching the Browser :"+browserName);
		if(browserName==Browser.CHROME) {
			if(isHeadlessMode) {
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			}
			else {
			driver.set(new ChromeDriver());
			}
		}
		else if(browserName==Browser.EDGE) {
			driver.set(new EdgeDriver());
		}
		else if(browserName==Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		}
		else {
			System.err.println("Invalid browser name...");
		}
	}
	
	public void goToWebsite(String url) {
		logger.info("Visiting the website :"+url);
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		logger.info("Maximizing the window");
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		logger.info("Finding element with the locator :"+locator);
		WebElement element=driver.get().findElement(locator);
		logger.info("Found element with the locator :"+locator);
		logger.info("clicking on the found element");
		element.click();
	}
	
	public void enterText(By locator, String text) {
		WebElement element=driver.get().findElement(locator);
		logger.info("Entering the text");
		element.sendKeys(text);
	}
	
	public String getVisibleText(By locator) {
		WebElement element=driver.get().findElement(locator);
		logger.info("Extracting the visible text");
		return element.getText();
	}
	
	public String takeScreenshot(String name) {
		TakesScreenshot screenshot=(TakesScreenshot)driver.get();
		File screenshotData=screenshot.getScreenshotAs(OutputType.FILE);
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("HH-mm-ss");
		String timeStamp=format.format(date);
		String screenshotPath="./screenshots/"+name+timeStamp+".png";
		File screenshotFile=new File(screenshotPath);
		
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshotPath;
	}
}
