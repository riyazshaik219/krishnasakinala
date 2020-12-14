import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingWebTable {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		 driver = new ChromeDriver();
		 driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	//handling company rows:
	//*[@id="customers"]/tbody/tr[2]/td[1]
	//*[@id="customers"]/tbody/tr[3]/td[1]
	//*[@id="customers"]/tbody/tr[4]/td[1]
	//*[@id="customers"]/tbody/tr[7]/td[1]
	//td means columns
	//tr means rows 
	//th means headers
	
	@Test
	public void WebTable()  {
		List<WebElement> rows=driver.findElements(By.xpath("//*[@id='customers']/tbody/tr"));
		int rowcount=rows.size();
		System.out.println("Total no. of rows:"+rowcount);
		
		//handling company rows:
		String beforexpath="//*[@id=\"customers\"]/tbody/tr[";
		String afterxpath="]/td[1]";
		for(int i=2;i<=rowcount;i++) {
			String actualxpath=beforexpath+i+afterxpath;
			WebElement element=driver.findElement(By.xpath(actualxpath));
			System.out.println(element.getText());
		}
		System.out.println("************");
		//handling Contact rows:
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[3]/td[2]
		String afterxpathforContact="]/td[2]";
		for(int i=2;i<=rowcount;i++) {
			String actualxpathforContact=beforexpath+i+afterxpathforContact;
			WebElement element=driver.findElement(By.xpath(actualxpathforContact));
			System.out.println(element.getText());
		}
		System.out.println("************");
		//handling company rows:
		//*[@id="customers"]/tbody/tr[2]/td[3]
		//*[@id="customers"]/tbody/tr[3]/td[3]
		String afterxpathforCountry="]/td[3]";
		for(int i=2;i<=rowcount;i++) {
			String actualxpathforCountry=beforexpath+i+afterxpathforCountry;
			WebElement element=driver.findElement(By.xpath(actualxpathforCountry));
			System.out.println(element.getText());
		}
		System.out.println("************");
		//handling columns:
		//*[@id="customers"]/tbody/tr[1]/th[1]
		//*[@id="customers"]/tbody/tr[1]/th[2]
		//*[@id="customers"]/tbody/tr[1]/th[3]
		String columnbeforexpath="//*[@id=\"customers\"]/tbody/tr[1]/th[";
		String columnafterxpath="]";
		List<WebElement> columns=driver.findElements(By.xpath("//*[@id='customers']/tbody/tr[1]/th"));
		int columnscount=columns.size();
		System.out.println("Total no. of column are:"+columnscount);
		
		System.out.println("*************");
		for(int i=1;i<=columnscount;i++) {
			WebElement element=driver.findElement(By.xpath(columnbeforexpath+i+columnafterxpath));
			System.out.println(element.getText());
		}
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}