package com.qa.DemoAutomationSite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class switchTo {

	WebDriver driver;
	Alert alert;
	
	@BeforeMethod
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		}
	@Test
	public void switchToTest() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//button[contains(text(),'alert box:')]")).click();
		alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		driver.quit();
	}
}
