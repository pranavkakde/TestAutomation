package com.test.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.common.BaseFunctions;

public class HomePage {
	private WebDriver driver;
	
	@FindBy(id="search_query_top")	
	WebElement searchBox;
	@FindBy(xpath="//*[@id=\"searchbox\"]/button")
	WebElement searchButton;

	BaseFunctions baseFunctions = new BaseFunctions(driver);
	
	public HomePage(WebDriver driver) {
		//constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean openURL(String url) {
		driver.get(url);
		return true;
	}
	public String getHomeTitle() {
		return driver.getTitle();
	}
	public void typeInSearch(String value) {
		assertEquals(true, baseFunctions.typeInInputXpath(searchBox, value));
	}
	public void clickOnSearch() {
		assertEquals(true, baseFunctions.clickXpath(searchButton)); 
	}
}
