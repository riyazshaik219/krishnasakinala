package com.qa.DemoAutomationSite;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingWindows {
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {
		
		driver = new FirefoxDriver();
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		}
	@Test
	public void MultipleWindowsTest() throws InterruptedException {
		
		WebElement tabbedbutton=driver.findElement(By.cssSelector("#Tabbed>a>button"));
		tabbedbutton.click();
		Thread.sleep(5000);
		Set<String> windowsid=driver.getWindowHandles();
		Iterator<String> itr=windowsid.iterator();
		
		String mainwindow=itr.next();
		String childwindow=itr.next();
		driver.switchTo().window(childwindow);
		System.out.println(driver.getTitle());
		
		driver.close();
		
		Thread.sleep(3000);
		
		driver.switchTo().window(mainwindow);
		
		System.out.println(driver.getTitle());
		
}
	
}