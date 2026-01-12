package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver>  driver=new ThreadLocal<WebDriver>();
	private Logger logger=LogManager.getLogger(this.getClass());
	private WebDriverWait wait;
	
	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(30L));
	}
	
	public BrowserUtility(Browser browserName) {
		logger.info("Launching the Browser :"+browserName);
		if(browserName==Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}
		else if(browserName==Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}
		else if(browserName==Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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
				wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
			else {
			driver.set(new ChromeDriver());
			wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		}
		else if(browserName==Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		}
		else if(browserName==Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
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
		//WebElement element=driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("Found element with the locator :"+locator);
		logger.info("clicking on the found element");
		element.click();
	}
	
	public void clickOn(WebElement element) {
		logger.info("clicking on the found element");
		element.click();
	}
	
	public void enterText(By locator, String text) {
		logger.info("Finding element with the locator :"+locator);
		//WebElement element=driver.get().findElement(locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Entering the text");
		element.sendKeys(text);
	}
	
	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Finding element with the locator :"+locator);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		//WebElement element=driver.get().findElement(locator);
		logger.info("Found the element and now press the key"+keyToEnter);
		element.sendKeys(keyToEnter);
	}
	
	public String getVisibleText(By locator) {
		WebElement element=driver.get().findElement(locator);
		logger.info("Extracting the visible text");
		return element.getText();
	}
	
	public String getVisibleText(WebElement element) {
		logger.info("Extracting the visible text");
		return element.getText();
	}
	
	public List<String> getAllVisibleText(By locator) {
		List<WebElement> elementsList=driver.get().findElements(locator);
		logger.info("Extracting the visible text value");
		List<String> visibleTextList=new ArrayList<String>();
		for(WebElement element:elementsList) {
			System.out.println(element.getText());
			visibleTextList.add(element.getText());
		}
		return visibleTextList;
	}
	
	public List<WebElement> getAllElements(By locator) {
		List<WebElement> elementsList=driver.get().findElements(locator);

		return elementsList;
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
	
	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding element for select locator : "+dropDownLocator);
		WebElement element=driver.get().findElement(dropDownLocator);
		Select select=new Select(element);
		logger.info("Clicked on select locator and now selecting the option "+optionToSelect);
		
		//select.selectByVisibleText(optionToSelect);
		select.selectByValue(optionToSelect);
		
	}
	
	public void selectAndClickOptionFromDropDown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding element for select locator : "+dropDownLocator);
		clickOn(dropDownLocator);
		logger.info("Clicked on select locator and now selecting the option "+optionToSelect);
		//select.selectByVisibleText(optionToSelect);
		//clickOn(optionToSelect);
		
	}
	
	public void clearText(By textLocator) {
		logger.info("Finding element for locator : "+textLocator);
		WebElement element=driver.get().findElement(textLocator);
		element.clear();
	}
}
