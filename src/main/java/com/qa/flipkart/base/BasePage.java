package com.qa.flipkart.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * FraudShareTest
 * @author rperabat
 *
 */
public class BasePage {
	
	public Properties prop;
	
	public WebDriver driver;
	
	public static String flashElement;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public static String Config_path = "./src/main/java/com/qa/flipkart/config/config.properties";
	
	public Properties init_properties(){
		
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream(Config_path);
			try {
				prop.load(fis);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return prop;
	}
	
	public WebDriver init_driver(Properties prop){
		
		flashElement = prop.getProperty("highlight").trim();
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			//driver= new ChromeDriver();
			tlDriver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browserName.equalsIgnoreCase("ie")){
			WebDriverManager.iedriver().setup();
			//driver = new InternetExplorerDriver();
			tlDriver.set(new InternetExplorerDriver());
		}
		
		else {
			System.out.println(browserName+ " Browser is not found" );
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}
	
	public static synchronized WebDriver getDriver(){
		return tlDriver.get();
	}
	
	public String getScreenshot(){
		
		TakesScreenshot ts = ((TakesScreenshot)getDriver());
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return path;
		
		
	}


}
