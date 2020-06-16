package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.openqa.selenium.firefox.FirefoxDriver;



public class BaseTest {
	
    String driverPath = "C:\\geckodriver.exe";
    String chromedriverPath = "C:\\chromedriver.exe";
    String chromedriverPathLinux = "/usr/bin/chromedriver";
	 protected WebDriver driver;
	 @BeforeMethod
	    protected void setup() {
	    	//System.setProperty("webdriver.gecko.driver", driverPath); //check if necessary on AWS - set geckodriver en usr/bin
		 	// en setProperty agregar headless
	    	System.setProperty("webdriver.chrome.driver", chromedriverPathLinux);
	        //remote webdiver search
	        //driver = new FirefoxDriver();
	    	driver = new ChromeDriver();
	    	
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
	    @AfterMethod
	    protected void teardown() {
	        driver.quit();
	    }
}
