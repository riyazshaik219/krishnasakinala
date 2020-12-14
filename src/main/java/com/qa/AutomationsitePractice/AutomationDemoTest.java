package com.qa.AutomationsitePractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomationDemoTest {

public static WebDriver driver;

	
	
	public static void main(String[] args) throws InterruptedException, AWTException {
			
		
		driver = new FirefoxDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	
	
	 
		
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("shaik");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("fahed");
		driver.findElement(By.tagName("textarea")).sendKeys("Ejipura,Bangalore");
		driver.findElement(By.xpath("\r\n" + 
				"//input[@ng-model='EmailAdress']")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("\r\n" + 
				"//input[@ng-model='Phone']")).sendKeys("1234567890");
		driver.findElement(By.cssSelector("input[name='radiooptions'][value='Male']")).click();
		driver.findElement(By.cssSelector("input[type='checkbox'][value='Movies']")).click();
		driver.findElement(By.cssSelector("#msdd")).click();
		//Languages:
		List<WebElement> list=driver.findElements(By.xpath("//ul[contains(@class,'ui-autocomplete')]//li//a"));
		System.out.println(list.size());
		
		for(int k=0;k<list.size();k++) {
			System.out.println(list.get(k).getText());
			if(list.get(k).getText().contains("English")) {
				list.get(k).click();
				break;
			}
		
		}
		
		//Date of Birth:
		
		Select year=new Select(driver.findElement(By.xpath("//select[@id='yearbox']")));
		year.selectByIndex(10);
		Select month=new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")));
		month.selectByValue("May");
		Select day=new Select(driver.findElement(By.xpath("//select[@placeholder='Day']")));
		day.selectByVisibleText("7");
		
		WebElement Btn=driver.findElement(By.cssSelector("#imagesrc"));
		 clickElementByJS(Btn,driver);
		StringSelection selection = new StringSelection("D:\\facebookimage.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Thread.sleep(5000);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	
		
		
		
		
		        
		  
		}
	
		
	
		//driver.findElement(By.xpath("//button[@id='submitbtn']")).submit();
		
	
	public static void clickElementByJS(WebElement element,WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}
}
