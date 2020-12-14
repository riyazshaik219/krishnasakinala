package com.qa.DemoAutomationSite;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class DownloadFile {
WebDriver driver;
File folder;
	
	@BeforeMethod
	public void setUp() {
		folder=new File(UUID.randomUUID().toString());
		folder.mkdir();
		ChromeOptions options = new ChromeOptions();
		Map<String,Object> prefs = new HashMap<String,Object>();
		prefs.put("profile.default_content_settings.popups", 0);//it should not display any popups
		prefs.put("download.default_directory", folder.getAbsolutePath());
		
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		
		driver = new ChromeDriver(cap);
		
		}
	@Test
	public void downloadFileTest() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("test-source-schema.xml")).click();
		
		//wait for few seconds to download
		Thread.sleep(5000);
		File listOfFiles[]=folder.listFiles();
		//make sure directory is not empty:
		Assert.assertTrue(listOfFiles.length>0);
		
		for(File file:listOfFiles) {
			//make sure downloaded file is not empty
			
			Assert.assertTrue(file.length()>0);
		}
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		for(File file:folder.listFiles()) {
			file.delete();
		}
		folder.delete();
	}
}
