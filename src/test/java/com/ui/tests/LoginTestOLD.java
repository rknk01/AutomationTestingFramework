package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTestOLD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver wd=new ChromeDriver();
		
		BrowserUtility browserUtility=new BrowserUtility(wd);
		browserUtility.goToWebsite("http://www.automationpractice.pl/index.php");
		browserUtility.maximizeWindow();
		
		By signInLinkLocator=By.xpath("//a[contains(text(),'Sign in')]");
		browserUtility.clickOn(signInLinkLocator);
		
		By emailTextBoxLocator=By.id("email");
		browserUtility.enterText(emailTextBoxLocator, "pononic790@mucate.com");
		
		
		By passwordTextBoxLocator=By.id("passwd");
		browserUtility.enterText(passwordTextBoxLocator, "password");
		
		By signInButtonLocator=By.xpath("//button[@id='SubmitLogin']");
		browserUtility.clickOn(signInButtonLocator);
		
	}

}
