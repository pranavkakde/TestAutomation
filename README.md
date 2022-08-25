[![Docker build](https://github.com/pranavkakde/TestAutomation/actions/workflows/docker-image.yml/badge.svg)](https://github.com/pranavkakde/TestAutomation/actions/workflows/docker-image.yml)


# TestAutomation
This is a Test Automation project using Selenium, Java and TestNG. It is built using Page Object pattern.

## Components

1. Test Classes - contains tests written using TestNG. The files are located under ***tests*** directory.

2. Pages - contains Page Objects. The files are located under ***pages*** directory.

3. Driver Manager - contains classes for managing Web Driver. The file is located in ***common*** directory.

4. Configuration - contains Singleton class for managing configuration as stated in config.json. The classes are placed in ***common*** directory.

5. Test Logger - Customer test logger in ***common*** directory.

6. Utility functions for wrapping Selenium WebDriver functions. BaseFunctions.java in ***common*** directory. 

## Getting Started

> Pre-requisite 
>> Install - Maven

>> Install Docker for desktop - for running tests using docker

### Build and run tests command line
1. Clone this repo and build the project using maven 

```bash
mvn compile
```
All the compiled code will be available in ***target*** folder. 

2. Run the tests using maven 



```bash
mvn test ./pom.xml -DgridUrl=http://<IP Address of Selenium Grid>:4444 -DbrowserName=firefox
```

If ```-DgridUrl``` is not provided, default gridUrl as provided in `config.json`.

If ```-DgridUrl``` is not provided, default browser as provided in `config.json`.  

Update `config.json` if you wish to run the tests without command line args. 
```json
{
    "baseUrl": "http://automationpractice.com/index.php/",
    "gridUrl": "http://127.0.0.1:4444",
    "browserSettings":{
        "browserType": "chrome",
        "headless": true
    }
}
```

### Build and run tests using docker and Selenium Grid

1. Build docker image for the project

```bash
docker build -t pranavkakde/seleniumframeworkjava .
```

2. Run tests with docker container

```bash
docker run --name seleniumjava_test_run pranavkakde/seleniumframeworkjava:latest -DgridUrl=http://<IP Address of Selenium Grid>:4444 -DbrowserName=firefox
```

3. Download results from test run. 

```
docker cp seleniumjava_test_run:/app/target/surefire-reports <host directory>
```

### Build Selenium Grid

> Pre-requisite - Install Docker Desktop

For setting up selenium grid using docker run;

```bash
docker compose up -d 
```
