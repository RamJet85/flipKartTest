package com.qa.flipkart.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {
	
	WebDriver driver;

	public JavaScriptUtils(WebDriver driver) {

		this.driver = driver;
	}
	
	public void falsh(WebElement element) {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("background color");
		for(int i=0;i<10;i++) {
			changeColor("rgb(0,200,0)",element);
			changeColor(bgcolor, element);
		}
		
	}

	private void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor='" + color +"'", element);
		
		try{
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		}
		
		
	public void drawBorder(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border = '3px solid red'", element);
		
	}
	public void generateAlert(String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
		
	}
	public void clickElementByJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
		
	}
	public void refreshByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
		
	}
	public String getTilteByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	public String getPageInnerText() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String Pagetext = js.executeScript("return document.documentElement.innerText;").toString();
		return Pagetext;
	}
	public void scrollPagedown() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	public void sendKeysByJs(String id, String value) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + id + "').value ='" + value + "'");
	}

	

}
