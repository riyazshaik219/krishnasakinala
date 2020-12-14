package com.qa.DemoAutomationSite;
//with using sendkeys method
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.get("http://demo.guru99.com/test/upload/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		}
	@Test
	public void fileuploadTest() {
		//No file chosen id:
		WebElement uploadElement=driver.findElement(By.id("uploadfile_0"));
		//enter the file path in input field:
		uploadElement.sendKeys("C:\\Users\\AM\\Desktop\\automationsitexpaths.txt");
		//I accept checkbox:
		driver.findElement(By.id("terms")).click();
		//submit button:
		driver.findElement(By.id("submitbutton")).click();
		
	}
}
