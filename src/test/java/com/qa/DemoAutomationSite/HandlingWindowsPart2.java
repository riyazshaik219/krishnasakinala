package com.qa.DemoAutomationSite;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingWindowsPart2 {

public static WebDriver driver;
	
	
	
	public static void main(String[] args) throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		WebElement tabbedbutton=driver.findElement(By.cssSelector("#Tabbed>a>button"));
		tabbedbutton.click();
		Thread.sleep(5000);
		switchToWindow(2);
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		driver.close();
		
		switchToWindow(1);
		System.out.println(driver.getTitle());
}
	//If I give index as 1-->main window
	//If I give index as 2-->child window
	public  static void switchToWindow(int index) {
		String windowid=null;
		Set<String> windowsid=driver.getWindowHandles();
		Iterator<String> itr=windowsid.iterator();
		for(int i=1;i<=index;i++) {
			windowid=itr.next();
		}
		driver.switchTo().window(windowid);
	}
}