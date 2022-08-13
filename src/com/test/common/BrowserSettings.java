package com.test.common;

public class BrowserSettings{
    private String browserType="";
    private Boolean headless=null;
    
    public BrowserSettings(){

    }
    public BrowserSettings(String browserType, Boolean headless){
        this.browserType = browserType;
        this.headless = headless;
    }
    public String getBrowserType(){
        return browserType;
    }
    public Boolean getHeadless(){
        return headless;
    }
    public void setBrowserType(String browserType){
        this.browserType = browserType;
    }
    public void setHeadless(Boolean headless){
        this.headless = headless;
    }
}