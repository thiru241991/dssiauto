package scenarioexecution;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ACDdashboard {
	static WebDriver driver;
	static JavascriptExecutor js;
	//@BeforeClass
	public void startTest() throws MalformedURLException, InterruptedException {

			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(new URL("https://devdirect.acheckamerica.com/Acheckdirect20/"));
			driver.findElement(By.id("Username")).sendKeys("tester1");
			driver.findElement(By.id("Password")).sendKeys("Tester1@");
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/div/input")).click();
			Thread.sleep(13000);
	}

	//@Test(priority = 1)
	public void searchCurrentDate() throws InterruptedException {
		 //DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		  LocalDate localDate = LocalDate.now();
		  //driver.findElement(fromDate).sendKeys(dtf.format(localDate));
		 // System.out.println(dtf.format(localDate));
		  WebElement SDate= driver.findElement(By.xpath("//*[contains(@class,'backgroundReportStartDatePicker k-input')]"));
		  SDate.clear();
		  SDate.sendKeys(dtf.format(localDate));
		  WebElement EDate= driver.findElement(By.xpath("//*[contains(@class,'backgroundReportEndDatePicker k-input')]"));
		  EDate.clear();
		  EDate.sendKeys(dtf.format(localDate),Keys.TAB);
		  Thread.sleep(12000);
		  WebElement fileno= driver.findElement(By.xpath("//*[contains(@class,'fileNoLink')]"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileno);
		  fileno.click();
			Thread.sleep(5000);
	}
	//@Test(priority = 2)
	public void upcomingEndDate() throws InterruptedException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate1 = LocalDate.now();
		  LocalDate localDate2 = LocalDate.now().plusDays(1);
		  //driver.findElement(fromDate).sendKeys(dtf.format(localDate));
		  //System.out.println(dtf.format(localDate1));
		 // System.out.println(dtf.format(localDate2));
		  WebElement SDate= driver.findElement(By.xpath("//*[contains(@class,'backgroundReportStartDatePicker k-input')]"));
		  SDate.clear();
		  SDate.sendKeys(dtf.format(localDate1));
		  WebElement EDate= driver.findElement(By.xpath("//*[contains(@class,'backgroundReportEndDatePicker k-input')]"));
		  EDate.clear();
		  EDate.sendKeys(dtf.format(localDate2),Keys.TAB);
		  Thread.sleep(16000);
		  WebElement fileno= driver.findElement(By.xpath("//*[contains(@class,'fileNoLink')]"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileno);
			Thread.sleep(7000);
			fileno.click();
			
	}
	//@Test(priority = 3)
	public void viewORprint() throws InterruptedException, MalformedURLException {
		driver.close();
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(new URL("https://devdirect.acheckamerica.com/Acheckdirect20/"));
		driver.findElement(By.id("Username")).sendKeys("tester1");
		driver.findElement(By.id("Password")).sendKeys("Tester1@");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/div/input")).click();
		Thread.sleep(13000);
		WebElement chkbox1= driver.findElement(By.xpath("//*[@id='backgroundReportDetailGrid']/div[4]/table/tbody/tr[1]/td[2]/input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", chkbox1);
		chkbox1.click();
		driver.findElement(By.xpath("//*[@id='backgroundReportDetailGrid']/div[4]/table/tbody/tr[2]/td[2]/input")).click();
		driver.findElement(By.xpath("//*[@id='backgroundReportDetailGrid']/div[4]/table/tbody/tr[3]/td[2]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@id,'fileViewMultiBackgroundReport')]")).click();
		Thread.sleep(37000);
		ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs_windows.get(1));
		String docno=driver.findElement(By.xpath("//*[@id='grdHtmlContent_ctl02_lblHeaderHtml']/table/tbody/tr[1]/td[2]/span[5]")).getText();
		System.out.println("Viewed file no -->"+docno);
		Thread.sleep(4000);
		driver.close();
		driver.switchTo().window(tabs_windows.get(0));
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[contains(@id,'fileDownloadMultiBackgroundReport')]")).click();
		Thread.sleep(45000);
		System.out.println("View/Print filno is different from Download fileno");
		driver.findElement(By.xpath("//*[contains(@id,'nolist')]")).click();
		
	}
	//@Test(priority = 4)
	public void sameUser() throws InterruptedException, MalformedURLException {
		Thread.sleep(5000);
		String a = "window.open('https://devdirect.acheckamerica.com/Acheckdirect20/','_blank');";
		((JavascriptExecutor)driver).executeScript(a);
		Thread.sleep(4000);
		ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs_windows.get(1));
		Thread.sleep(2000);
		driver.findElement(By.id("Username")).sendKeys("tteam02");
		driver.findElement(By.id("Password")).sendKeys("Tester1@");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/div/input")).click();
		Thread.sleep(13000);
		driver.switchTo().window(tabs_windows.get(0));
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(6000);
		String userN= driver.findElement(By.xpath("//*[@id='wel']/li[1]/a")).getText();
		System.out.println(userN);
		Thread.sleep(4000);
		String ExpUserN="Welcome, TESTER ONE";
		Assert.assertEquals(userN, ExpUserN);
		
	}
	//@Test(priority = 5)
	public void dashboardGridReset() throws InterruptedException, MalformedURLException {
		driver.quit();
		Thread.sleep(3000);
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(new URL("https://devdirect.acheckamerica.com/Acheckdirect20/"));
		driver.findElement(By.id("Username")).sendKeys("tester1");
		driver.findElement(By.id("Password")).sendKeys("Tester1@");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/div/input")).click();
		Thread.sleep(13000);
		WebElement gridno= driver.findElement(By.xpath("//*[@id='backgroundReportDetailGrid']/div[5]/span[1]/span/span/span[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridno);
		gridno.click();
		Thread.sleep(1500);
		//new Select(driver.findElement(By.xpath("//*[@id='backgroundReportDetailGrid']/div[5]/span[1]/span/select"))).selectByValue("500");
		driver.findElement(By.xpath("//li[contains(text(),'500')]")).click();
		//gridno.sendKeys(Keys.TAB);
		Thread.sleep(34000);
		driver.findElement(By.xpath("//*[contains(text(),'Sign Out')]")).click();
		Thread.sleep(7000);
		driver.findElement(By.id("Username")).sendKeys("tester1");
		driver.findElement(By.id("Password")).sendKeys("Tester1@");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/div/input")).click();
		Thread.sleep(13000);
		WebElement gridno2= driver.findElement(By.xpath("//*[@id='backgroundReportDetailGrid']/div[4]/span[1]/span/span"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridno2);Thread.sleep(5000);
		//String gridno3=driver.findElement(By.xpath("//*[@id='backgroundReportDetailGrid']/div[4]/span[1]/span/span/span[1]")).getText();
		//System.out.println("g3"+gridno3);
		String gridno4= driver.findElement(By.xpath("//*[@id='backgroundReportDetailGrid']/div[4]/span[1]/span/span")).getText();
		System.out.println("Grid value--"+gridno4);
		String Expgridno="10";
		Assert.assertEquals(gridno4, Expgridno);
	}
	
	//@Test(priority = 6)
	public void existingCountSearchResultTAB() throws MalformedURLException, InterruptedException {
		driver.quit();
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(new URL("https://devdirect.acheckamerica.com/Acheckdirect20/"));
		driver.findElement(By.id("Username")).sendKeys("tester1");
		driver.findElement(By.id("Password")).sendKeys("Tester1@");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/div/input")).click();
		Thread.sleep(16000);
		driver.findElement(By.xpath("//*[contains(text(),' Switch to Classic Dashboard ')]")).click();
		Thread.sleep(12000);
		driver.findElement(By.xpath("//*[contains(@id,'lnkRequests')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@id,'txtFName')]")).sendKeys("Thir");
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		WebElement DisputedFiles = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		Actions actions = new Actions(driver);
		// Scroll Down using Actions class
		actions.doubleClick(DisputedFiles).perform();
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles);
		DisputedFiles.click();
		driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		Thread.sleep(18000);
		driver.findElement(By.xpath("//*[contains(text(),' Switch to New Dashboard ')]")).click();
		Thread.sleep(14000);
		WebElement fileno= driver.findElement(By.xpath("//*[contains(@class,'fileNoLink')]"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileno);
		  fileno.click();
			Thread.sleep(8000);
		String searchTab=	driver.findElement(By.xpath("//*[contains(@id,'r1_cmdTabFileList')]")).getText();
		System.out.println(searchTab);
		String ExpsearchTab="Search Results";
		Assert.assertEquals(searchTab, ExpsearchTab);
	}
	
	//@Test(priority = 7)
	public void requestorCheck() throws MalformedURLException, InterruptedException {
		driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		Thread.sleep(18000);
		//driver.findElement(By.xpath("//*[contains(text(),' Switch to New Dashboard ')]")).click();
		//Thread.sleep(14000);
		/*System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(new URL("https://devdirect.acheckamerica.com/Acheckdirect20/"));
		driver.findElement(By.id("Username")).sendKeys("tester1");
		driver.findElement(By.id("Password")).sendKeys("Tester1@");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/div/input")).click();
		Thread.sleep(16000);*/
		
		WebElement SDate= driver.findElement(By.xpath("//*[contains(@class,'backgroundReportStartDatePicker k-input')]"));
		  SDate.clear();
		  SDate.sendKeys("01/01/2018");
		  driver.findElement(By.xpath("//*[@id='backgroundReportDetailGrid']/div[1]/div[2]/span/span/span[2]")).click();
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//*[@id='backgroundReportRequesterDDL_listbox']/li[9]")).click();
		  //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", drpdwnval);
		  //Thread.sleep(1500);
		  //drpdwnval.click();
		  SDate.sendKeys(Keys.TAB);
		  Thread.sleep(15000);
		  WebElement gridno= driver.findElement(By.xpath("//*[@id='backgroundReportDetailGrid']/div[4]/span[1]/span/span/span[2]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridno);
			gridno.click();
			Thread.sleep(1500);
			//new Select(driver.findElement(By.xpath("//*[@id='backgroundReportDetailGrid']/div[5]/span[1]/span/select"))).selectByValue("500");
			driver.findElement(By.xpath("//li[contains(text(),'500')]")).click();
			Thread.sleep(34000);
		 try { WebElement gridno2= driver.findElement(By.xpath("//*[@id='backgroundReportDetailGrid']/div[4]/span[1]/span/span"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridno2);
			Thread.sleep(5000);}catch (Exception e) {}
		 Thread.sleep(2000);
		 try{WebElement gridno3= driver.findElement(By.xpath("//*[@id='backgroundReportDetailGrid']/div[4]/span[1]/span/span/span[2]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridno3);
			Thread.sleep(5000);}catch (Exception e) {}
	}
	
	//@Test(priority = 8)
	public void backNavigation() throws MalformedURLException, InterruptedException {
		//driver.close();
		Thread.sleep(2000);
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		 driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.navigate().to(new URL("https://devdirect.acheckamerica.com/Acheckdirect20/"));
				driver.findElement(By.id("Username")).sendKeys("tester1");
				driver.findElement(By.id("Password")).sendKeys("Tester1@");
				Thread.sleep(4000);
				driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/div/input")).click();
				Thread.sleep(16000);
				driver.findElement(By.xpath("//*[contains(text(),'Sign Out')]")).click();
				Thread.sleep(6000);
				driver.navigate().back();
				Thread.sleep(6000);
				String loginpage=driver.findElement(By.xpath("//*[contains(text(),'Log In to A-Check Direct')]")).getText();
				String Exploginpage="Log In to A-Check Direct";
				Assert.assertEquals(loginpage, Exploginpage);
	}
	//@Test(priority = 9)
	public void recentFileDisplay() throws MalformedURLException, InterruptedException {
		//driver.close();
		Thread.sleep(2000);
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		 driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.navigate().to(new URL("https://devdirect.acheckamerica.com/Acheckdirect20/"));
				driver.findElement(By.id("Username")).sendKeys("tester1");
				driver.findElement(By.id("Password")).sendKeys("Tester1@");
				Thread.sleep(4000);
				driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/div/input")).click();
				Thread.sleep(16000);
				String RecentfileDate=driver.findElement(By.xpath("//*[@id='backgroundReportDetailGrid']/div[4]/table/tbody/tr[1]/td[5]")).getText();
				String RecentfileName=driver.findElement(By.xpath("//*[@id='backgroundReportDetailGrid']/div[4]/table/tbody/tr[1]/td[6]")).getText();
				System.out.println("Recently created File- Date & Name-->"+RecentfileDate      +RecentfileName);
	}
	
	@Test(priority = 10)
	public void fileStatusMouseHover() throws MalformedURLException, InterruptedException {
		//driver.close();
		Thread.sleep(2000);
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		 driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.navigate().to(new URL("https://devdirect.acheckamerica.com/Acheckdirect20/"));
				driver.findElement(By.id("Username")).sendKeys("tester1");
				driver.findElement(By.id("Password")).sendKeys("Tester1@");
				Thread.sleep(4000);
				driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/div/input")).click();
				Thread.sleep(16000);
				driver.findElement(By.xpath("//*[contains(text(),' Switch to Classic Dashboard ')]")).click();
				Thread.sleep(12000);
				driver.findElement(By.xpath("//*[contains(@id,'lnkRequests')]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[contains(@id,'txtFName')]")).sendKeys("T");
				driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
				Thread.sleep(5000);
				WebElement DisputedFiles = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
				Actions actions = new Actions(driver);
				// Scroll Down using Actions class
				actions.doubleClick(DisputedFiles).perform();
				// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				Thread.sleep(3000);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles);
				DisputedFiles.click();
				String hovertxt=driver.findElement(By.xpath("//*[contains(@id,'ctl02_lbStatus')]")).getAttribute("title");
				System.out.println(hovertxt);
				String Exphovertxt="Completed: 1/1/1900 12:00:00 AM";
				Assert.assertFalse(hovertxt.contains(Exphovertxt),"Failure message");
				//Assert.
		}
}
	
	
	
	
	
	
	
	
	


