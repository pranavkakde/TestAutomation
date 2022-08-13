package com.test.common;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverManager {
    private static WebDriver driver = null;
	ConfigManager config= null;
	private static DriverManager instance = null;  

	private DriverManager(){

	}
	public WebDriver getDriver(){
        setUpDriver();
		return driver;
	}
	public static DriverManager getInstance() {  
        if (instance == null){  
            instance = new DriverManager();  
        }  
        return instance;  
    }
    private void setUpDriver(){
		config = ConfigManager.getInstance();
		String headless = config.config().getBrowserSettings().getHeadless().toString();
		switch(config.config().getBrowserSettings().getBrowserType().toLowerCase()){
			case "chrome":
				ChromeOptions options = new ChromeOptions();
				List<String> arguments = new ArrayList<String>();
				String isHeadless = headless.equalsIgnoreCase("true")?"--headless":"";
				if(!isHeadless.isEmpty()){
					arguments.add(isHeadless);
				}
				arguments.add("--window-size=1920,1080");
				arguments.add("--user-agent=Mozilla/5.0 (X11; Linux aarch64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0 Safari/537.36");
				options.addArguments(arguments);		
				driver = WebDriverManager.chromedriver().capabilities(options).create();
				Reporter.log("Created Web Driver for Chrome");
			break;
			case "firefox":
				FirefoxOptions fireFoxOptions = new FirefoxOptions();
				fireFoxOptions.setHeadless(headless.equalsIgnoreCase("true")?true:false);
				fireFoxOptions.setAcceptInsecureCerts(true);
				driver = WebDriverManager.firefoxdriver().capabilities(fireFoxOptions).create();
				Reporter.log("Created Web Driver for Firefox");
			break;
			case "edge":
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.setAcceptInsecureCerts(true);
				edgeOptions.setHeadless(headless.equalsIgnoreCase("true")?true:false);
				driver = WebDriverManager.edgedriver().capabilities(edgeOptions).create();
				Reporter.log("Created Web Driver for Edge");
			break;
		}		
    }
	
	public void closeBrowser(){
		driver.close();
	}
	public void quitDriver(){
		driver.quit();
	}

   	public void saveScreenshot(String methodName){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        File scrFile = ((TakesScreenshot)DriverManager.driver).getScreenshotAs(OutputType.FILE);
        try {
            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports";
            Boolean folderCreated = new File(reportDirectory+"/failedScreenshots/").mkdirs();
            Reporter.log("Report folder created " + folderCreated);
            File destFile = new File((String) reportDirectory+"/failedScreenshots/"+methodName+"_"+formater.format(calendar.getTime())+".png");
            Files.copy(scrFile, destFile);
            Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
