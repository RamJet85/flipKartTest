package com.qa.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.flipkart.base.BasePage;
import com.qa.flipkart.utils.ElementUtils;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	
	ElementUtils elementUtils;
	
	String tilte = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";	
	//By locators
	
	By login = By.xpath("//a[text()='Login']");
	By userName = By.xpath("//input[@class='_2IX_2- VJZDxU']");
	By password = By.xpath("//input[@type='password']");
	By loginBtn = By.xpath("(//span[text()='Login'])[position()=2]");
	By close = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	
	By hovor = By.xpath("(//div[@class='_28p97w'])[position()='1']");
	By Profile = By.xpath("//div[text()='My Profile']");
	
	//text impact
	public LoginPage(WebDriver driver){
		
		this.driver =driver;
		elementUtils = new ElementUtils(driver);
	}
	
	
	public String loginPageTitle(){
		//elementUtils.waitForElementToBeClickable(close, 10);
		return elementUtils.waitForTitlePresent(tilte, 10);
		
		
	}
	
	public void doFlipkartLogin(String un, String pwd){
		//elementUtils.doClick(login);
		elementUtils.doSendKeys(userName, un);
		elementUtils.doSendKeys(password, pwd);
		elementUtils.doActionClick(loginBtn);
		
		
	}
	
	public void moveToElement() throws InterruptedException{
		
		Actions act = new Actions(driver);
		Thread.sleep(5000);
		act.moveToElement(driver.findElement(hovor)).click().perform();;
		
		
		
		
		
	}
	
	

	
	
	
	

}
