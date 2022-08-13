package com.test.common;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Reporter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.ous.jtoml.ParseException;

public class ConfigManager {	    
    private final String configFile = "config.json";
    private Config configProp = null;
    private static ConfigManager instance = null;  
  
    private ConfigManager(){ 
        GetConfig();
    }

    public static ConfigManager getInstance() {  
        if (instance == null){  
            instance = new ConfigManager();  
        }  
        return instance;  
    }
    public Config config(){
        return this.configProp;
    }
    private void GetConfig(){         
        try {
            String projectDir = new File(System.getProperty("user.dir")).getAbsolutePath();
            Reporter.log(projectDir+"/"+configFile);
            byte[] encoded = Files.readAllBytes(Paths.get(projectDir+"/"+configFile));
            final ObjectMapper mapper = new ObjectMapper(); 
            this.configProp = mapper.reader().forType(Config.class).readValue(encoded);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();    
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
