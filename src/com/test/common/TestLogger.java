package com.test.common;


import org.testng.ITestResult;

import org.testng.TestListenerAdapter;

public class TestLogger extends TestListenerAdapter{   
    
   @Override
   public void onTestFailure(ITestResult testResult) {
        
        if(!testResult.isSuccess()){
            DriverManager dm = DriverManager.getInstance();
            dm.saveScreenshot(testResult.getName());
        }
   }


}