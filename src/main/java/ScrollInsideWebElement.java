import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollInsideWebElement {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		 driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/WebTable.html");
	}
	@Test
	public void scrollElement() throws InterruptedException {
		WebElement itemsPerPageDropdown= driver.findElement(By.xpath("//body/section[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/select[1]"));
		Select select =new Select(itemsPerPageDropdown);
		select.selectByVisibleText("30");
		Thread.sleep(7000);
		
		EventFiringWebDriver eventfiringwebdriver=new EventFiringWebDriver(driver);
		eventfiringwebdriver.executeScript("document.querySelector('div[role=\"grid\"][class=\"ui-grid-render-container ng-isolate-scope ui-grid-render-container-body\"]').scrollTop=500");
		
	}
	/*@AfterMethod
	public void tearDown() {
		driver.close();
	}*/
	
}
