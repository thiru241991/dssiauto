package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commonaction {
	
	 public static WebDriver driver;
	
	 public WebDriver startBrowser(String browser) throws Exception {     
		 
		    switch(browser.toLowerCase()) {  
		    	   
		    case "chrome": 
		    	
		   	System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			driver=new ChromeDriver();	
			 
		    break;  
		    
		    case "firefox": 
		    	
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		    driver=new ChromeDriver();	
				 
			break; 
			
		    case "ie": 
		    	
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			driver=new ChromeDriver();	
					 
		    break; 
				    
		    }
	
			driver.manage().window().maximize();
			implicitWait(60);
			
			return driver;
		}
	 


		public void closeBrowser() {
			driver.quit();
		}
		public void implicitWait(long milliseconds) {
			driver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
		}
		
		public void openUrl(String url) {
			driver.get(url);		
		}
		
		public void sleep(long millisecond) throws InterruptedException {
			Thread.sleep(millisecond);
		}
		
		public void waitForElementToBeClickable(WebElement element, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			}
		
		public void scrollToElement(WebElement element) throws InterruptedException {
	          sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
          sleep(1000);
			}
		
		public void jsSendKeys(WebElement element,String inputText) {
			String js = "arguments[0].setAttribute('value','"+inputText+"')";
			((JavascriptExecutor) driver).executeScript(js, element);
		}
		public void pageRefresh() {
			driver.navigate().refresh();
		}
		
		public void scrollPage(int scrollheight) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,"+scrollheight+")", "");
					
		}
		
	
	
		public void pageDownScroll() {
			 Actions actions = new Actions(driver);
		      // Scroll Down using Actions class
		      actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();			
		}
		
		public void tabKey() {
			 Actions actions = new Actions(driver);
		      actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB)	.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();

		}
		
		public void alert(String alert) {
			
			switch(alert.toLowerCase()) {
			case "accept":
			driver.switchTo().alert().accept();
			break;
			case "dismiss":
			driver.switchTo().alert().dismiss();	
			break;
			}
		}
		
		public void dropdownSelect(WebElement element,String value) {
			Select select=new Select(element);
			select.selectByValue(value);		
		}
}
