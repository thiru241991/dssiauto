package scenarioexecution;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ACDdashboard {
	static WebDriver driver;
	static JavascriptExecutor js;
	@BeforeClass
	public void startTest() throws MalformedURLException, InterruptedException {

			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(new URL("https://devdirect.acheckamerica.com/Acheckdirect20/"));
			driver.findElement(By.id("Username")).sendKeys("tester1");
			driver.findElement(By.id("Password")).sendKeys("Tester1@");
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/div/input")).click();
			Thread.sleep(16000);
	}

	@Test(priority = 1)
	public void searchCurrentDate() {
		 //DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		  LocalDate localDate = LocalDate.now();
		  //driver.findElement(fromDate).sendKeys(dtf.format(localDate));
		  System.out.println(dtf.format(localDate));
		  WebElement SDate= driver.findElement(By.xpath("//*[contains(@class,'backgroundReportStartDatePicker k-input')]"));
		  SDate.clear();
		  SDate.sendKeys(dtf.format(localDate));
		  WebElement EDate= driver.findElement(By.xpath("//*[contains(@class,'backgroundReportEndDatePicker k-input')]"));
		  EDate.clear();
		  EDate.sendKeys(dtf.format(localDate),Keys.TAB);
	}
	
}
	
	
	
	
	
	
	
	
	


