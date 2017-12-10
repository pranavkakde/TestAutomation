package com.test.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.pages.HomePage;

public class RunTest {
    WebDriver driver;
    
    @BeforeSuite
    public void setUp() {         
    	System.setProperty("webdriver.gecko.driver", "E:\\code\\seleniumlib\\geckodriver.exe");
    	driver = new FirefoxDriver();
    }
     //this is a test
    //@Parameters({"username","incorrectpassword"})
    @Test(description="Open Home Page for Test Site")
    public void testHomePage() {
         
        HomePage home = new HomePage(driver);
        Assert.assertEquals(true, home.openURL("http://automationpractice.com/index.php/"));
        Assert.assertEquals(home.getHomeTitle(), "My Store");
        home.typeInSearch("Shoe");
        home.clickOnSearch();
    }
     
    @AfterSuite
    public void tearDown() {
         
        driver.quit();
    }
}
