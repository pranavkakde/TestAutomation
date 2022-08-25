package com.test.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.test.common.ConfigManager;
import com.test.common.DriverManager;
import com.test.pages.HomePage;

public class RunTest {
    WebDriver driver=null;
    ConfigManager configManager= null;
    @BeforeSuite
    public void setUp() {         
    	configManager = ConfigManager.getInstance();
        Reporter.log("App URL " + configManager.config().getBaseUrl());
        driver = DriverManager.getInstance().getDriver();
        
    }

    @Test(description="Open Home Page for Test Site")
    public void testHomePage() {
        HomePage home = new HomePage(driver);
        Assert.assertEquals(true, home.openURL(configManager.config().getBaseUrl().toString()));
        Reporter.log("Application Launched successfully.");
        Assert.assertEquals(home.getHomeTitle(), "My Store");
        Reporter.log("Home page loaded successfully.");
        home.typeInSearch("Shoe");
        home.clickOnSearch();
        Reporter.log("Clicked on search button.");
    }
     
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
