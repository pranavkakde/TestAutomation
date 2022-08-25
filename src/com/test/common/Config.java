package com.test.common;

public class Config{
    private String baseUrl = "";
    private String gridUrl = "";
    private BrowserSettings browserSettings = null;
    public Config(String baseUrl, BrowserSettings browserSettings){
        this.baseUrl = baseUrl;
        this.browserSettings = browserSettings;
    }
    public Config(){
        super();    
    }
    public void setBaseUrl(String baseUrl){
        this.baseUrl = baseUrl;
    }
    public String getBaseUrl(){
        return this.baseUrl;
    }
    public BrowserSettings getBrowserSettings(){
        return this.browserSettings;
    }
    public void setBrowserSettings(BrowserSettings browserSettings){
        this.browserSettings = browserSettings;
    }
    public void setGridUrl(String gridurl){
        this.gridUrl = gridurl;
    }
    public String getGridUrl(){
        return this.gridUrl;
    }
}