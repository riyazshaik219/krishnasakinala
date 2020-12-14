package com.qa.AutomationsitePractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUpload {
	public static void main(String[] args) throws AWTException, InterruptedException {

		  WebDriver driver = new FirefoxDriver();
		  driver.navigate().to("http://demo.automationtesting.in/Register.html");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
		  //open upload window
		     WebElement Btn=driver.findElement(By.xpath("//input[@type='file']"));
		     
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
	public static void clickElementByJS(WebElement element,WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}
}
