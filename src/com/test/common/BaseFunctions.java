package com.test.common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Reporter;


public class BaseFunctions {
	WebDriver driver;
	final int waitTime = 10;
	
	public BaseFunctions(WebDriver test){
		this.driver = test;
	}
	
	public Boolean typeInInputXpath(WebElement elem, String valueToType) {
		if(waitForElementVisible(elem)){
			elem.sendKeys(valueToType);
			return true;
		}else{
			return false;
		}
	}
	public Boolean clickXpath(WebElement elem) {
		if(waitForElementVisible(elem)){
			elem.click();
			return true;
		}else{
			Reporter.log("Element not clickable "+ elem.toString());
			return false;
		}
	}

	private boolean isElementVisible(WebElement elem){
		return elem.isDisplayed();
	}
	private Boolean waitForElementVisible(WebElement elem){
		try {
			int time = 0;
			Boolean found = false;
			while (time<=60) {
				try {
					found = isElementVisible(elem)? true: false;
				} catch (Exception e) {
					//Do not handle the exception
				}
				if (found) {
					System.out.println("Found element");
					// JavascriptExecutor js = (JavascriptExecutor) driver;
					// js.executeScript("arguments[0].scrollIntoView(true);", elem);
					break;
				}
				Thread.sleep(1000);
				time++;
			 }
			 if(time>60){
				Reporter.log("Element not visible on UI " + elem.toString());
				return false;
			 }
			 return true;
		} catch (Exception e) {
			Reporter.log(elem.toString() + " not found with exception " + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}
}
