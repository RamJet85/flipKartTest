package com.qa.flipkart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.flipkart.base.BasePage;
import com.qa.flipkart.pages.LoginPage;

public class LoginPageTest {
	
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeTest
	public void setUp(){
	basePage = new BasePage();
	prop = basePage.init_properties();
	driver = basePage.init_driver(prop);
	loginPage = new LoginPage(driver);
	
}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest(){
		
		String title = loginPage.loginPageTitle();
		System.out.println("The title is: "+title);
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		
	}
	
	@Test(priority=2)
	public void verifyLoginPageTest(){
		
		loginPage.doFlipkartLogin(prop.getProperty("username"), prop.getProperty("password").trim());
		
	}
	
	@Test(priority=3)
	public void verifyMenuTest() throws InterruptedException{
		
		loginPage.moveToElement();
		
	}
	
	@AfterTest
	public void teardown(){
		driver.quit();
		
	}
	
	
	
}