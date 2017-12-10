package com.test.pages;

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
	/*@FindBy(xpath="//*[@id=\"center_column\"]/h1/span[2]")
	WebElement searchMsg;*/
	BaseFunctions bf = new BaseFunctions(driver);
	
	public HomePage(WebDriver driver) {
		//constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean openURL(String url) {
		boolean retVal=false;
		driver.get(url);
		retVal=true;
		return retVal;
	}
	public String getHomeTitle() {
		return driver.getTitle();
	}
	public void typeInSearch(String value) {
		bf.typeInInputXpath(searchBox, value);
	}
	public void clickOnSearch() {
		bf.clickXpath(searchButton);
	}
}
