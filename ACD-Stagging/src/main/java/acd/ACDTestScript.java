package acd;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ACDTestScript {
	static WebDriver driver;
	static JavascriptExecutor js;
	//public String dataSheet, sheetName;

	//@BeforeClass
	public void startTest() throws MalformedURLException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(new URL("https://devdirect.acheckamerica.com/Acheckdirect20/"));
		driver.findElement(By.id("Username")).sendKeys("tteam02");
		driver.findElement(By.id("Password")).sendKeys("Tester1@");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='loginForm']/form/div[3]/div/input")).click();
		Thread.sleep(16000);
		WebElement classicDash = null;
		try {
			classicDash = driver.findElement(By.xpath("//*[contains(text(),' Switch to Classic Dashboard ')]"));
			if (classicDash.isDisplayed()) {
				classicDash.click();
				Thread.sleep(5000);
			} else {
				driver.findElement(By.xpath("//*[contains(@id,'lnkNewRequest')]")).click();
				Thread.sleep(5000);
			}
			Thread.sleep(7000);
		} catch (Exception e) {
		}
	}

	//@Test(priority = 1)
	public void basicDetail(ITestContext ctx) throws InterruptedException {

		try {
			// submit-request
			driver.findElement(By.xpath("//*[contains(@id,'lnkNewRequest')]")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}

		// A LA CARTE
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@id,'lnkAlaCart')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'EDUCATION VERIFICATION')]//preceding::input[1]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'PRIORITY STATUS')]//preceding::input[1]")).click();
		driver.findElement(By.xpath("//*[contains(@id,'cmdNewRequest')]")).click();

		// Applicant-Basic details Page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[contains(@id,'txtFirstName')]")).sendKeys("firstName");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@id,'txtMiddleName')]")).sendKeys("middleName");
		driver.findElement(By.xpath("//*[contains(@id,'txtLastName')]")).sendKeys("lastName");
		WebElement ctry = driver.findElement(By.xpath("//*[contains(@id,'ddlCountry')]"));
		new Select(ctry).selectByVisibleText("UNITED STATES");
		ctry.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@id,'maskTxtSSN_text')]")).sendKeys("555555555", (Keys.TAB));
		// Thread.sleep(16000);
		// ssn window box
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id='ctl00_SecureClientPlaceHolder_BgdNewRequestContainer1_BgdNewRequestWizard1_ctl00_ctl01_imgCloseThis']")));
		WebElement newWinChkBox2 = null;
		try

		{
			newWinChkBox2 = driver.findElement(By.xpath(
					"//*[@id=\'ctl00_SecureClientPlaceHolder_BgdNewRequestContainer1_BgdNewRequestWizard1_ctl00_ctl01_imgCloseThis\']"));
			// WebDriverWait wait = new WebDriverWait(driver,17);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'ctl00_SecureClientPlaceHolder_BgdNewRequestContainer1_BgdNewRequestWizard1_ctl00_ctl01_imgCloseThis\']")));
			if (newWinChkBox2.isEnabled()) {

				newWinChkBox2.click();
				Thread.sleep(10000);
			}
		} catch (Exception e) {
		}
		// js.executeScript("arguments[0].click();",
		// driver.findElement(By.xpath("(//*[contains(@id,'imgCloseThis')])[2]")));
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[contains(@id,'maskTxtSSNReEnter_text')]")).sendKeys("555555555", (Keys.TAB));
		driver.findElement(By.xpath("//*[contains(@id,'cbxNoValidSSN')]")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//*[contains(@id,'maskTxtDob_text')]")).sendKeys("08091991", (Keys.TAB));
		driver.findElement(By.xpath("//*[contains(@id,'txtAddress')]")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//*[contains(@id,'ZipCode_text')]")).sendKeys("12205", (Keys.TAB));

		Thread.sleep(20000);
		// zip windowbox
		WebElement newWinChkBox = null;
		try

		{

			newWinChkBox = driver.findElement(By.xpath(
					"//*[@id=\'ctl00_SecureClientPlaceHolder_BgdNewRequestContainer1_BgdNewRequestWizard1_ctl00_ctl01_UcZipCodeLookUp1_imgClose\']"));
			// WebDriverWait wait = new WebDriverWait(driver,12);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'ctl00_SecureClientPlaceHolder_BgdNewRequestContainer1_BgdNewRequestWizard1_ctl00_ctl01_UcZipCodeLookUp1_imgClose\']")));
			if (newWinChkBox.isEnabled()) {
				driver.findElement(By.xpath(
						"//*[@id='ctl00_SecureClientPlaceHolder_BgdNewRequestContainer1_BgdNewRequestWizard1_ctl00_ctl01_UcZipCodeLookUp1_grdSearchResults_ctl02_chkSelected']"))
						.click();
				driver.findElement(By.xpath(
						"//*[@id=\'ctl00_SecureClientPlaceHolder_BgdNewRequestContainer1_BgdNewRequestWizard1_ctl00_ctl01_UcZipCodeLookUp1_cmdSelectCounty\']"))
						.click();
				// newWinChkBox.click();
				Thread.sleep(10000);
			}
		} catch (Exception e) {
		}
		// driver.findElement(By.xpath("//*[contains(@id,'grdSearchResults')]//following::input[1]")).click();
		// driver.findElement(By.xpath("//*[contains(@id,'grdSearchResults')]//following::input[@value='Select']")).click();
		Thread.sleep(20000);
		WebElement ele = driver.findElement(By.xpath("//*[contains(@id,'cmdContinue')]"));
		js.executeScript("arguments[0].click();", ele);
		Thread.sleep(22000);

		// nextPage
		// js.executeScript("arguments[0].scrollIntoView(true);",
		// driver.findElement(By.xpath("//*[contains(@id,'ddlStateList')]")));
		driver.findElement(By.xpath("//*[contains(@id,'cmdContinue')]")).click();
		Thread.sleep(29000);

		// Educational Page
		driver.findElement(By.xpath("//*[contains(@id,'txtSchool')]")).sendKeys("school");
		driver.findElement(By.xpath("//*[contains(@id,'txtCity')]")).sendKeys("eduCity");
		js.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//*[contains(@id,'btnTabBgdComEdu')]")));
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlState')]"))).selectByValue("DC");
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlCountry')]"))).selectByVisibleText("UNITED STATES");
		js.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//*[contains(@id,'lblSchoolEmail')]")));
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlDegree')]"))).selectByVisibleText("PHD");
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlGraduated')]"))).selectByVisibleText("YES");
		Thread.sleep(28000);
		WebElement graddate = driver.findElement(By.xpath("//*[contains(@id,'txtGraduationDate')]"));
		graddate.sendKeys("02/2009", Keys.ENTER);

		// js.executeScript("arguments[0].scrollIntoView(true);",
		// driver.findElement(By.xpath("//*[contains(@id,'lbTitle')]")));
		Thread.sleep(35000);
		driver.findElement(By.xpath("//*[contains(@id,'cmdContinue')]")).click();
		Thread.sleep(23000);
		try {

			driver.switchTo().alert().accept();
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}
		}
		Thread.sleep(5000);
		try {

			driver.switchTo().alert().accept();
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}
		}
		Thread.sleep(5000);

		// Billing Page
		// driver.findElement(By.xpath("//*[contains(text(),'ACCOUNT
		// CODE')]//following::img[1]")).click();
		// driver.findElement(By.xpath("//*[contains(@id,'rcbCodeValues_c1')]")).click();
		// driver.findElement(By.xpath("//*[contains(text(),'COST
		// CENTER')]//following::img[1]")).click();
		// -->driver.findElement(By.xpath("//*[contains(@id,'ctl03_rcbCodeValues_Input')]")).sendKeys("1");
		// driver.findElement(By.xpath("//*[contains(text(),'RECRUITING
		// AREA')]//following::input[1]")).sendKeys(rectArea);

		// js.executeScript("arguments[0].scrollIntoView(true);",
		// driver.findElement(By.xpath("//*[contains(text(),'COST CENTER')]")));
		// driver.findElement(By.xpath("//*[contains(@id,'txtInvoiceNotes')]")).sendKeys(invoiceNotes);
		driver.findElement(By.xpath("//*[contains(@id,'cmdSubmit')]")).click();
		Thread.sleep(28000);
		String fileNum = driver.findElement(By.xpath("//*[contains(@id,'lblFileNumber')]")).getText();
		// return fileNum;
		System.out.println("ACD-File Number is Successfully created -->" + fileNum);
		ctx.setAttribute("fileNum", fileNum);
		// addReport(fileNum);
		// driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		Thread.sleep(16000);

	}

	/*
	 * //@Test(priority = 1)public static void test(ITestContext ctx) throws
	 * InterruptedException { ctx.setAttribute("fileNum", fileNum); String fileNum =
	 * "23ee"; System.out.println("File Number->"+fileNum);
	 * 
	 * //this.fileNum=filenNum; //addReport(fileNum); }
	 */

	//@Test(priority = 2)
	public void addReport(ITestContext ctx) throws InterruptedException {
		/*
		 * driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		 * Thread.sleep(6000);
		 * driver.findElement(By.xpath("//*[contains(text(),'Draft - DFT')]")).click();
		 * Thread.sleep(6000);
		 * 
		 * WebElement DisputedFiles=
		 * driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		 * Actions actions = new Actions(driver); // Scroll Down using Actions class
		 * actions.doubleClick(DisputedFiles).perform(); Thread.sleep(3000);
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);",DisputedFiles);
		 * DisputedFiles.click(); Thread.sleep(3000);
		 */
		String fNum = (String) ctx.getAttribute("fileNum");
		driver.findElement(By.xpath("//*[contains(@id,'lnkRequests')]")).click();
		driver.findElement(By.xpath("//*[contains(@id,'txtFileNo')]")).sendKeys(fNum);
		driver.findElement(By.xpath("//*[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(4000);

		WebElement filelink = driver.findElement(By.xpath("//*[contains(@id,'cmdFileSelected')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", filelink);
		Thread.sleep(1000);
		filelink.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'Actions')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Add Report')]")).click();
		Thread.sleep(4000);
		/*
		 * //>>Add report ->2 Components driver.findElement(By.
		 * xpath("//label[contains(text(),'ADDRESS HISTORY')]//preceding::input[1]")).
		 * click(); driver.findElement(By.
		 * xpath("//label[contains(text(),'CONSOLIDATED SCREENING LIST')]//preceding::input[1]"
		 * )).click();
		 * driver.findElement(By.xpath("//*[contains(@id,'lnkAdd')]")).click();
		 * Thread.sleep(5000);
		 * 
		 * driver.findElement(By.xpath("//*[contains(@id,'lnkContinue')]")).click();
		 * Thread.sleep(5000);
		 * driver.findElement(By.xpath("//*[contains(@id,'lnkContinue')]")).click();
		 * Thread.sleep(5000);
		 * driver.findElement(By.xpath("//*[contains(@id,'lnkContinue')]")).click();
		 * Thread.sleep(5000);
		 * driver.findElement(By.xpath("//*[contains(@id,'lnkContinue')]")).click();
		 * Thread.sleep(7000); //>>Add report ->3 Components
		 * //driver.findElement(By.xpath("//span[contains(text(),'Actions')]")).click();
		 * driver.findElement(By.xpath("//span[contains(text(),'Add Report')]")).click()
		 * ; Thread.sleep(4000);
		 */
		// driver.findElement(By.xpath("//label[contains(text(),'DOT DRUG
		// SCREEN')]//preceding::input[1]")).click();
		// driver.findElement(By.xpath("//label[contains(text(),'FEDERAL BUREAU OF
		// PRISONS')]//preceding::input[1]")).click();
		// driver.findElement(By.xpath("//label[contains(text(),'INTERPOL')]//preceding::input[1]")).click();
		// driver.findElement(By.xpath("//label[contains(text(),'ADDRESS
		// HISTORY')]//preceding::input[1]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'AUDIOGRAM')]//preceding::input[1]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'EVIDENTIAL BREATH TESTING')]//preceding::input[1]"))
				.click();
		driver.findElement(By.xpath("//*[contains(@id,'lnkAdd')]")).click();
		Thread.sleep(5000);

		// driver.findElement(By.xpath("//*[contains(@id,'chkPaperECOC')]")).click();
		driver.findElement(By.xpath("//*[contains(@id,'lnkContinue')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@id,'lnkContinue')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@id,'lnkContinue')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@id,'lnkContinue')]")).click();
		/*
		 * Thread.sleep(5000);
		 * driver.findElement(By.xpath("//*[contains(@id,'lnkContinue')]")).click();
		 * Thread.sleep(5000);
		 * driver.findElement(By.xpath("//*[contains(@id,'lnkContinue')]")).click();
		 */
		Thread.sleep(7000);
		WebElement totalprice = driver.findElement(By.xpath("//span[contains(text(),'Total Price')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", totalprice);
		System.out.println("-->Add Report-Method is Executed Successfully");
		Thread.sleep(5000);
	}

	//@Test(priority = 6)
	public void ACDQuicklinks() throws InterruptedException {
		// -->Quick Links
		driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		Thread.sleep(18000);
		driver.findElement(By.xpath("//*[contains(text(),'For Client Review - FCR')]")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		Thread.sleep(18000);
		driver.findElement(By.xpath("//*[contains(text(),'Recently Closed - RC')]")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		Thread.sleep(18000);
		driver.findElement(By.xpath("//*[contains(text(),'Unread Messages - UM')]")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		Thread.sleep(18000);
		driver.findElement(By.xpath("//*[contains(text(),'Interim - IM')]")).click();
		Thread.sleep(9000);
		// -->All Requests HyperLinks
		driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		Thread.sleep(27000);
		// driver.findElement(By.xpath("//*[contains(text(),'Closed - C')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Draft - DFT')]")).click();
		Thread.sleep(9000);

		WebElement DisputedFiles = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		Actions actions = new Actions(driver);
		// Scroll Down using Actions class
		actions.doubleClick(DisputedFiles).perform();
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles);
		DisputedFiles.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(text(),'Summary')]")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//*[contains(@id,'UcBgdReqViewer1_imgClose')]")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[contains(text(),'View/Print')]")).click();
		Thread.sleep(16000);
		driver.findElement(By.xpath("//*[@id='ctl00_ClientMasterBody']/div[6]/div[1]/a/span")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[contains(@id,'cmdSend')]")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@id='ctl00_SecureClientPlaceHolder_UcBgdReqViewer1_imgClose']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[contains(@id,'cmdArchive')]")).click();
		Thread.sleep(8000);
		// driver.switchTo().alert().accept();
		// Thread.sleep(4000);
		try {

			driver.switchTo().alert().accept();
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}
		}
		Thread.sleep(5000);
		// driver.switchTo().alert().accept();
		// Thread.sleep(4000);
		try {

			driver.switchTo().alert().accept();
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}
		}
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE).sendKeys(Keys.ESCAPE).build().perform();
		// Thread.sleep(3000);
		// driver.switchTo().alert().accept();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(text(),'PDF Report')]")).click();
		Thread.sleep(5000);
		ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs_windows.get(1));
		Thread.sleep(27000);
		driver.close();
		driver.switchTo().window(tabs_windows.get(0));
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		Thread.sleep(18000);
		driver.findElement(By.xpath("//*[contains(text(),'In-Progress - IP')]")).click();
		Thread.sleep(9000);
		WebElement DisputedFiles2 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		Thread.sleep(18000);
		// driver.findElement(By.xpath("//*[contains(text(),'Draft - DFT')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Closed - C')]")).click();
		Thread.sleep(9000);
		WebElement DisputedFiles3 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		// Actions actions = new Actions(driver);
		// Scroll Down using Actions class
		actions.doubleClick(DisputedFiles3).perform();
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles3);
		DisputedFiles3.click();
		System.out.println("-->ACD_Quicklinks-Method is Executed Successfully");
		Thread.sleep(9000);

	}

	//@Test(priority = 3)
	public void docUpload(ITestContext ctx) throws InterruptedException {

		// driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		/*
		 * Thread.sleep(6000);
		 * driver.findElement(By.xpath("//*[contains(text(),'Draft - DFT')]")).click();
		 * Thread.sleep(6000);
		 * 
		 * WebElement DisputedFiles=
		 * driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		 * Actions actions = new Actions(driver); // Scroll Down using Actions class
		 * actions.doubleClick(DisputedFiles).perform(); Thread.sleep(3000);
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);",DisputedFiles);
		 * DisputedFiles.click(); Thread.sleep(3000);
		 */
		String fNum = (String) ctx.getAttribute("fileNum");
		driver.findElement(By.xpath("//*[contains(@id,'lnkRequests')]")).click();
		driver.findElement(By.xpath("//*[contains(@id,'txtFileNo')]")).sendKeys(fNum);
		driver.findElement(By.xpath("//*[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(4000);

		WebElement filelink = driver.findElement(By.xpath("//*[contains(@id,'cmdFileSelected')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", filelink);
		Thread.sleep(1000);
		filelink.click();
		// driver.findElement(By.xpath("//*[contains(@id,'cmdFileSelected')]")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'File Info')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Documents')]")).click();
		Thread.sleep(4000);
		// ->Documents uploding
		driver.findElement(By.xpath("//*[contains(text(),'Add Document')]")).click();
		Thread.sleep(14000);
		File file1 = new File("data/Testing PDF.pdf");
		driver.findElement(By.xpath("//*[contains(@id,'fileToUpload')]")).sendKeys(file1.getAbsolutePath());
		Thread.sleep(4000);
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlDocDesc')]"))).selectByVisibleText("AFFIDAVITS");
		driver.findElement(By.xpath("//*[contains(@id,'cmdUploadDocument')]")).click();
		Thread.sleep(25000);
		driver.findElement(By.xpath("//*[contains(text(),'Add Document')]")).click();
		Thread.sleep(14000);
		File file2 = new File("data/Testing JPEG.jpg");
		driver.findElement(By.xpath("//*[contains(@id,'fileToUpload')]")).sendKeys(file2.getAbsolutePath());
		Thread.sleep(4000);
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlDocDesc')]"))).selectByValue("DOC021");
		driver.findElement(By.xpath("//*[contains(@id,'cmdUploadDocument')]")).click();
		Thread.sleep(25000);
		driver.findElement(By.xpath("//*[contains(text(),'Add Document')]")).click();
		Thread.sleep(14000);
		File file3 = new File("data/Testing Excel.xlsx");
		driver.findElement(By.xpath("//*[contains(@id,'fileToUpload')]")).sendKeys(file3.getAbsolutePath());
		Thread.sleep(4000);
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlDocDesc')]"))).selectByValue("DOC040");
		driver.findElement(By.xpath("//*[contains(@id,'cmdUploadDocument')]")).click();
		Thread.sleep(25000);
		driver.findElement(By.xpath("//*[contains(text(),'Add Document')]")).click();
		Thread.sleep(14000);
		File file4 = new File("data/Test WordDocx.doc");
		driver.findElement(By.xpath("//*[contains(@id,'fileToUpload')]")).sendKeys(file4.getAbsolutePath());
		Thread.sleep(4000);
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlDocDesc')]"))).selectByValue("DOC012");
		driver.findElement(By.xpath("//*[contains(@id,'cmdUploadDocument')]")).click();
		Thread.sleep(25000);
		// ->view documents
		driver.findElement(By.xpath("//*[contains(@id,'ctl02_cmdViewPrint')]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[contains(@id,'ctl03_cmdViewPrint')]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[contains(@id,'ctl04_cmdViewPrint')]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[contains(@id,'ctl05_cmdViewPrint')]")).click();
		Thread.sleep(8000);

		// ->Edit documents
		driver.findElement(By.xpath("//*[contains(@id,'ctl02_cmdEdit')]")).click();
		Thread.sleep(6000);
		WebElement editdoc1 = driver.findElement(By.xpath("//*[contains(@id,'txtEditFileDescription')]"));
		editdoc1.clear();
		editdoc1.sendKeys("111File-Edited");
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlDocCatEdit')]"))).selectByValue("DOCCATEGORY005");
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlEditDocDesc')]"))).selectByValue("G000000034");
		driver.findElement(By.xpath("//*[contains(@id,'cmdSaveChanges')]")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[contains(@id,'ctl03_cmdEdit')]")).click();
		Thread.sleep(6000);
		WebElement editdoc2 = driver.findElement(By.xpath("//*[contains(@id,'txtEditFileDescription')]"));
		editdoc2.clear();
		editdoc2.sendKeys("222File-Edited");
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlDocCatEdit')]"))).selectByValue("DOCCATEGORY004");
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlEditDocDesc')]"))).selectByValue("G000000024");
		driver.findElement(By.xpath("//*[contains(@id,'cmdSaveChanges')]")).click();
		Thread.sleep(8000);
		WebElement totalprice = driver.findElement(By.xpath("//span[contains(text(),'Total Price')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", totalprice);
		System.out.println("-->Document Upload-Method is Executed Successfully");
		Thread.sleep(10000);
	}

	//@Test(priority = 7)
	public void SearchRequest() throws InterruptedException {
		driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		Thread.sleep(18000);
		driver.findElement(By.xpath("//*[contains(@id,'lnkSearchRequests')]")).click();
		// -->SEARCH BY FIRST NAME
		driver.findElement(By.xpath("//*[contains(@id,'txtFName')]")).sendKeys("T");
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlPageSize01')]"))).selectByValue("30");
		WebElement DisputedFiles = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		Actions actions = new Actions(driver);
		// Scroll Down using Actions class
		actions.doubleClick(DisputedFiles).perform();
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles);
		DisputedFiles.click();
		Thread.sleep(5000);
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlPageSize01')]"))).selectByValue("50");
		WebElement DisputedFiles15 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		actions.doubleClick(DisputedFiles15).perform();
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles15);
		DisputedFiles15.click();
		Thread.sleep(5000);
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlPageSize01')]"))).selectByValue("10");
		Thread.sleep(5000);
		WebElement DisputedFiles16 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		// Actions actions = new Actions(driver);
		// Scroll Down using Actions class
		actions.doubleClick(DisputedFiles16).perform();
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles16);
		DisputedFiles16.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@id,'cmdReset')]")).click();
		Thread.sleep(5000);
		// -->SEARCH BY LAST NAME
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(@id,'txtLName')]")).sendKeys("T");
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		WebElement DisputedFiles2 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		// Actions actions = new Actions(driver);
		// Scroll Down using Actions class
		actions.doubleClick(DisputedFiles2).perform();
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles2);
		DisputedFiles2.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@id,'cmdReset')]")).click();
		Thread.sleep(5000);
		// -->SEARCH BY SSN
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(@id,'txtLName')]")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//*[contains(@id,'txtSSN_text')]")).sendKeys("555555555", Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		WebElement DisputedFiles3 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		// Actions actions = new Actions(driver);
		// Scroll Down using Actions class
		actions.doubleClick(DisputedFiles3).perform();
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles3);
		DisputedFiles3.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@id,'cmdReset')]")).click();
		Thread.sleep(5000);
		// -->SEARCH BY STATUS
		Thread.sleep(4000);
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlStatus')]"))).selectByValue("INPROGRESS");
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		WebElement DisputedFiles4 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		// Actions actions = new Actions(driver);
		// Scroll Down using Actions class
		actions.doubleClick(DisputedFiles4).perform();
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles4);
		DisputedFiles4.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@id,'cmdReset')]")).click();
		Thread.sleep(5000);
		// -->SEARCH BY TYPE
		Thread.sleep(4000);
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlServiceType')]"))).selectByValue("BACK");
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		WebElement DisputedFiles5 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		// Actions actions = new Actions(driver);
		// Scroll Down using Actions class
		actions.doubleClick(DisputedFiles5).perform();
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles5);
		DisputedFiles5.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@id,'cmdReset')]")).click();
		Thread.sleep(5000);
		// -->SEARCH BY FILE NO
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(@id,'txtFileNo')]")).sendKeys("F");
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		WebElement DisputedFiles6 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		// Actions actions = new Actions(driver);
		actions.doubleClick(DisputedFiles6).perform();
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles6);
		DisputedFiles6.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@id,'cmdReset')]")).click();
		Thread.sleep(5000);
		// -->SEARCH BY SITE NO
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(@id,'ddlSiteNo_Input')]")).sendKeys("T");
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		WebElement DisputedFiles7 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		// Actions actions = new Actions(driver);
		// Scroll Down using Actions class
		actions.doubleClick(DisputedFiles7).perform();
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles7);
		DisputedFiles7.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@id,'cmdReset')]")).click();
		Thread.sleep(5000);
		// -->SEARCH BY DOB
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(@id,'ddlSiteNo_Input')]")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//*[contains(@id,'txtDOB_text')]")).sendKeys("08091991", Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		WebElement DisputedFiles8 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		// Actions actions = new Actions(driver);
		// Scroll Down using Actions class
		actions.doubleClick(DisputedFiles8).perform();
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles8);
		DisputedFiles8.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@id,'cmdReset')]")).click();
		Thread.sleep(5000);
		// -->SEARCH BY REQUESTOR
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(@id,'ddlRequestor_Input')]")).sendKeys("ACHECK TESTER");
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		WebElement DisputedFiles9 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		// Actions actions = new Actions(driver);
		// Scroll Down using Actions class
		actions.doubleClick(DisputedFiles9).perform();
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles9);
		DisputedFiles9.click();
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//a[contains(@id,'cmdReset')]")).click();
		// Thread.sleep(5000);
		WebElement reqinput = driver.findElement(By.xpath("//*[contains(@id,'ddlRequestor_Input')]"));
		actions.doubleClick(reqinput).perform();
		reqinput.clear();
		reqinput.sendKeys(" ");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		// -->SEARCH BY CONTAINS
		Thread.sleep(4000);
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlRptType')]")))
				.selectByVisibleText("EDUCATION VERIFICATION");
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		WebElement DisputedFiles10 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		// Actions actions = new Actions(driver);
		// Scroll Down using Actions class
		actions.doubleClick(DisputedFiles10).perform();
		// actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles10);
		DisputedFiles10.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@id,'cmdReset')]")).click();
		Thread.sleep(5000);

		// --> START DATE & END DATE
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(@id,'txtFileNo')]")).sendKeys("F", Keys.TAB);
		driver.findElement(By.xpath("//*[contains(@id,'chkArchieved')]")).sendKeys(Keys.TAB, "01012020", Keys.TAB,
				"01012022");
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		WebElement DisputedFiles11 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		// Actions actions = new Actions(driver);
		actions.doubleClick(DisputedFiles11).perform();
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles11);
		DisputedFiles11.click();
		Thread.sleep(5000);
		// --> PAGE NAVIGATION
		driver.findElement(By.xpath("//tbody/tr/td[3]/a[contains(text(),'3')]")).click();
		Thread.sleep(3000);
		WebElement DisputedFiles12 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		// Actions actions = new Actions(driver);
		actions.doubleClick(DisputedFiles12).perform();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles12);
		DisputedFiles12.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tbody/tr/td[5]/a[contains(text(),'5')]")).click();
		Thread.sleep(5000);
		WebElement DisputedFiles13 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		// Actions actions = new Actions(driver);
		actions.doubleClick(DisputedFiles13).perform();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles13);
		DisputedFiles13.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tbody/tr/td[7]/a[contains(text(),'7')]")).click();
		Thread.sleep(5000);
		WebElement DisputedFiles14 = driver.findElement(By.xpath("//*[contains(text(),'Disputed Files')]"));
		// Actions actions = new Actions(driver);
		actions.doubleClick(DisputedFiles14).perform();
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles14);
		DisputedFiles14.click();
		System.out.println("-->Search Request-Method is Executed Successfully");
		Thread.sleep(5000);
	}

	//@Test(priority = 4)
	public void FileInfo(ITestContext ctx) throws InterruptedException {
		// driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		// Thread.sleep(6000);
		/*
		 * driver.findElement(By.xpath("//*[contains(text(),'In-Progress - IP')]")).
		 * click(); Thread.sleep(6000); WebElement filelink=
		 * driver.findElement(By.xpath("//*[contains(@id,'cmdFileSelected')]"));
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);",filelink);
		 * Thread.sleep(1000); filelink.click();
		 */
		String fNum = (String) ctx.getAttribute("fileNum");
		driver.findElement(By.xpath("//*[contains(@id,'lnkRequests')]")).click();
		driver.findElement(By.xpath("//*[contains(@id,'txtFileNo')]")).sendKeys(fNum);
		driver.findElement(By.xpath("//*[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(4000);

		WebElement filelink = driver.findElement(By.xpath("//*[contains(@id,'cmdFileSelected')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", filelink);
		Thread.sleep(1000);
		filelink.click();
		Thread.sleep(4000);
		WebElement InvgtSummary1 = driver.findElement(By.xpath("//span[contains(text(),'Investigation Summary')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", InvgtSummary1);
		if (InvgtSummary1.isDisplayed()) {
			System.out.println("Investigation Summary is Displayed");
			InvgtSummary1.click();
		} else {
			driver.findElement(By.xpath("//span[contains(text(),'File Info')]")).click();
			Thread.sleep(4000);
			WebElement InvgtSummary2 = driver.findElement(By.xpath("//span[contains(text(),'Investigation Summary')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", InvgtSummary2);
			InvgtSummary2.click();
		}

		// driver.findElement(By.xpath("//span[contains(text(),'Investigation
		// Summary')]")).click();
		Thread.sleep(8000);
		WebElement totalprice = driver.findElement(By.xpath("//span[contains(text(),'Total Price')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", totalprice);
		/*
		 * WebElement imgMSG =
		 * driver.findElement(By.xpath("//*[contains(@id,'imgMSG')]")); Actions act =
		 * new Actions(driver); //actions.doubleClick(imgMSG).perform();
		 * 
		 * Thread.sleep(4000); //Thread.sleep(3000); ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", imgMSG);
		 * Thread.sleep(1000); imgMSG.click(); //-->INVESTIGATION SUMMARY
		 * //driver.findElement(By.xpath("//*[contains(@id,'imgMSG')]")).click();
		 * Thread.sleep(26000); JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView(true);",
		 * driver.findElement(By.xpath("//*[contains(@id,'btnAdd')]")));
		 * Thread.sleep(8000);
		 * driver.findElement(By.xpath("//*[contains(@id,'btnAdd')]")).click();
		 * Thread.sleep(10000);
		 * driver.findElement(By.xpath("//*[contains(@id,'btnYes')]")).sendKeys(Keys.TAB
		 * ); driver.findElement(By.xpath("//*[contains(@id,'txtFileMess')]")).
		 * sendKeys("TeST Message111"); Thread.sleep(4000);
		 * driver.findElement(By.xpath("//*[contains(@id,'btnYes')]")).click();
		 * Thread.sleep(4000); //Actions act=new Actions(driver);
		 * act.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.
		 * ENTER). build().perform(); Thread.sleep(9000);
		 * //driver.switchTo().alert().accept(); try {
		 * 
		 * driver.switchTo().alert().accept(); } catch (Exception e) { try {
		 * if(e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
		 * Alert alert = driver.switchTo().alert();
		 * 
		 * alert.accept(); } } catch (NoAlertPresentException e1) { e.printStackTrace();
		 * } }
		 */
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'SCHOOL')]//parent::td//preceding::a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='mainBox']")).click();
		Actions act = new Actions(driver);
		/*
		 * act.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform(); Thread.sleep(8000);
		 * 
		 * driver.findElement(By.xpath("//*[contains(@id,'btnAdd')]")).click();
		 * Thread.sleep(10000); try {
		 * 
		 * driver.switchTo().alert().accept(); } catch (Exception e) { try {
		 * if(e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
		 * Alert alert = driver.switchTo().alert();
		 * 
		 * alert.accept(); } } catch (NoAlertPresentException e1) { e.printStackTrace();
		 * } }Thread.sleep(10000);
		 * //driver.findElement(By.xpath("//*[contains(@id,'ctl03_txtFileMessage')]")).
		 * click();
		 * driver.findElement(By.xpath("//*[contains(@id,'btnYes')]")).sendKeys(Keys.TAB
		 * ); WebElement Msgfield=
		 * driver.findElement(By.xpath("//*[contains(@id,'ctl02_txtFileMessage')]"));
		 * Msgfield.sendKeys("TeST Message222",Keys.ENTER); Thread.sleep(3000);
		 * driver.findElement(By.xpath("//*[contains(@id,'btnYes')]")).click();
		 * Thread.sleep(4000);
		 * driver.findElement(By.xpath("//*[contains(@id,'lblSave')]")).click();
		 * Thread.sleep(12000); //driver.switchTo().alert().accept(); try {
		 * 
		 * driver.switchTo().alert().accept(); } catch (Exception e) { try {
		 * if(e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
		 * Alert alert = driver.switchTo().alert();
		 * 
		 * alert.accept(); } } catch (NoAlertPresentException e1) { e.printStackTrace();
		 * } }
		 */
		Thread.sleep(5000);

		// -->Applicant Details
		driver.findElement(By.xpath("//span[contains(text(),'Applicant Details')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='mainBox']")).click();
		act.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);

		// -->Request Info
		driver.findElement(By.xpath("//span[contains(text(),'Request Info')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='mainBox']")).click();
		act.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);

		// -->Status
		driver.findElement(By.xpath("//span[contains(text(),'Status')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='mainBox']")).click();
		act.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);

		// -->Notes
		driver.findElement(By.xpath("//span[contains(text(),'Notes')]")).click();
		Thread.sleep(5000);
		// driver.findElement(By.xpath("//*[@id='mainBox']")).click();
		// act.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		driver.findElement(By.xpath("//*[contains(@id,'btnAdd')]")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[contains(@id,'btnYes')]")).sendKeys(Keys.TAB);
		// driver.findElement(By.xpath("//*[contains(@id,'ctl04_txtFileMessage')]")).sendKeys("TeST
		// Message333",Keys.ENTER);
		driver.findElement(By.xpath("//*[contains(@id,'ctl02_txtFileMessage')]")).sendKeys("TeST Message333",
				Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@id,'btnYes')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(@id,'lblSave')]")).click();
		Thread.sleep(20000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		try {

			driver.switchTo().alert().accept();
			Thread.sleep(7000);
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
					Thread.sleep(3000);
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}

		}
		Thread.sleep(5000);try {

			driver.switchTo().alert().accept();
			Thread.sleep(7000);
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
					Thread.sleep(3000);
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}

		}
		Thread.sleep(5000);
		System.out.println("-->'File info_fuctionality'-Method is Executed Successfully");
		Thread.sleep(7000);
	}

	//@Test(priority = 5)
	public void Actions(ITestContext ctx) throws InterruptedException {
		// driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		// Thread.sleep(6000);
		/*
		 * driver.findElement(By.xpath("//*[contains(text(),'In-Progress - IP')]")).
		 * click(); Thread.sleep(6000); WebElement filelink=
		 * driver.findElement(By.xpath("//*[contains(@id,'cmdFileSelected')]"));
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);",filelink);
		 * Thread.sleep(1000); filelink.click();
		 */
		String fNum = (String) ctx.getAttribute("fileNum");
		driver.findElement(By.xpath("//*[contains(@id,'lnkRequests')]")).click();
		driver.findElement(By.xpath("//*[contains(@id,'txtFileNo')]")).sendKeys(fNum);
		driver.findElement(By.xpath("//*[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(4000);

		WebElement filelink = driver.findElement(By.xpath("//*[contains(@id,'cmdFileSelected')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", filelink);
		Thread.sleep(1000);
		filelink.click();
		Thread.sleep(4000);
		// -->View/Print Report
		WebElement viewReport = driver.findElement(By.xpath("//span[contains(text(),'View/Print Report')]"));

		if (viewReport.isDisplayed()) {
			System.out.println("View/Print Report is Displayed");
			viewReport.click();
		} else {
			driver.findElement(By.xpath("//span[contains(text(),'Actions')]")).click();
			Thread.sleep(2000);
			viewReport.click();
		}
		Thread.sleep(12000);
		driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
		Thread.sleep(3000);
		// -->Download Report
		driver.findElement(By.xpath("//span[contains(text(),'Download Report')]")).click();
		Thread.sleep(30000);
		// -->Print Component(s)
		driver.findElement(By.xpath("//span[contains(text(),'Print Component(s)')]")).click();
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[contains(@id,'UcPrintComponents1_imgClose')]")));
			driver.findElement(By.xpath("//*[contains(@id,'chkSelectReport')]")).click();
			System.out.println("Print Component(s) is triggered");
			driver.findElement(By.xpath("//*[contains(@id,'cmdPrint')]")).click();
			Thread.sleep(12000);
			driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// -->Print Order Summary
		driver.findElement(By.xpath("//span[contains(text(),'Print Order Summary')]")).click();
		Thread.sleep(22000);
		driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
		Thread.sleep(7000);
		// -->SAVE

		try {
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
			Thread.sleep(5000);
			driver.switchTo().alert().accept();
			Thread.sleep(20000);
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}
		}
		Thread.sleep(20000);
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}
		}

		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE).sendKeys(Keys.ESCAPE).build().perform();
		Thread.sleep(3000);
		// -->Mail Report to Applicant
		driver.findElement(By.xpath("//span[contains(text(),'Mail Report to Applicant')]")).click();
		Thread.sleep(11000);

		try {
			driver.switchTo().alert().accept();
			Thread.sleep(8000);
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}
		}Thread.sleep(5000);
		try {
			driver.switchTo().alert().accept();
			Thread.sleep(8000);
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}
		}Thread.sleep(5000);
		try {
			driver.switchTo().alert().accept();
			Thread.sleep(8000);
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}
		}
		// Actions act=new Actions(driver);
		act.sendKeys(Keys.ESCAPE).sendKeys(Keys.ESCAPE).build().perform();
		Thread.sleep(3000);
		Thread.sleep(2000);
		// -->Email Report
		driver.findElement(By.xpath("//span[contains(text(),'Email Report')]")).click();
		Thread.sleep(14000);
		driver.findElement(By.xpath("//*[contains(@id,'txtEmailAddresses')]")).sendKeys("tpalani@dssiindia.com");
		driver.findElement(By.xpath("//*[contains(@id,'txtEmailMessage')]")).sendKeys("Test-Message");

		WebElement totalprice = driver.findElement(By.xpath("//span[contains(text(),'Total Price')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", totalprice);
		driver.findElement(By.xpath("//*[contains(@id,'chkConfirm')]")).click();
		driver.findElement(By.xpath("//*[contains(@id,'cmdSendEmail')]")).click();
		Thread.sleep(30000);

		// -->REPORTS and Total Price
		WebElement totalprice2 = driver.findElement(By.xpath("//span[contains(text(),'Total Price')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", totalprice2);
		driver.findElement(By.xpath("//*[contains(@class,'RptTreeViewList')]")).click();
		Thread.sleep(10000);
		WebElement totalprice3 = driver.findElement(By.xpath("//span[contains(text(),'Total Price')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", totalprice3);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@class,'RptTreeViewList')]//following::span[1]")).click();
		Thread.sleep(10000);
		WebElement totalprice4 = driver.findElement(By.xpath("//span[contains(text(),'Total Price')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", totalprice4);
		Thread.sleep(5000);
		totalprice4.click();
		WebElement totalprice5 = driver.findElement(By.xpath("//span[contains(text(),'Total Price')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", totalprice5);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@class,'activeTabImgButton')]")).click();
		Thread.sleep(5000);
		System.out.println("-->'Actions_fuctionality'-Method is Executed Successfully");
		Thread.sleep(7000);
	}

	//@Test(priority = 8)
	public void OfflineReports() throws InterruptedException {
		driver.findElement(By.xpath("//*[contains(@id,'lnkRequests')]")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[contains(@id,'lnkOfflineReports')]")).click();
		Thread.sleep(8000);
		// -->SEARCH BY FIRST NAME
		driver.findElement(By.xpath("//*[contains(@id,'txtFName')]")).sendKeys("T");
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlPageSize01')]"))).selectByValue("30");
		Thread.sleep(5000);
		WebElement gridpage = driver.findElement(By.xpath(
				"//*[@id='ctl00_SecureClientPlaceHolder_UcArchivedBgdReqViewer1_pnArchivedFileSearchResultDetail']/div[4]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridpage);
		Thread.sleep(3000);
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlPageSize01')]"))).selectByValue("50");
		Thread.sleep(5000);
		WebElement gridpage2 = driver.findElement(By.xpath(
				"//*[@id='ctl00_SecureClientPlaceHolder_UcArchivedBgdReqViewer1_pnArchivedFileSearchResultDetail']/div[4]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridpage2);
		Thread.sleep(3000);
		new Select(driver.findElement(By.xpath("//*[contains(@id,'ddlPageSize01')]"))).selectByValue("10");
		WebElement gridpage3 = driver.findElement(By.xpath(
				"//*[@id='ctl00_SecureClientPlaceHolder_UcArchivedBgdReqViewer1_pnArchivedFileSearchResultDetail']/div[4]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridpage3);
		Thread.sleep(3000);
		// Clicking Print Link
		driver.findElement(By.xpath("//*[contains(@id,'cmdPrint')]")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
		Thread.sleep(3000);
		// Clicking Document Link
		driver.findElement(By.xpath("//*[contains(text(),'Document(s)')]")).click();
		Thread.sleep(35000);
		driver.findElement(By.xpath("//*[@id='floaterChild']")).click();
		driver.findElement(By.xpath("//*[@id='ctl00_SecureClientPlaceHolder_UcArchivedBgdReqViewer1_imgClose']"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(@id,'cmdReset')]")).click();
		Thread.sleep(5000);
		// -->SEARCH BY LAST NAME
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(@id,'txtLName')]")).sendKeys("T");
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		WebElement gridpage4 = driver.findElement(By.xpath(
				"//*[@id='ctl00_SecureClientPlaceHolder_UcArchivedBgdReqViewer1_pnArchivedFileSearchResultDetail']/div[4]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridpage4);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@id,'cmdReset')]")).click();
		Thread.sleep(5000);
		// -->SEARCH BY SSN
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(@id,'txtLName')]")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//*[contains(@id,'txtSSN_text')]")).sendKeys("555555555", Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		WebElement gridpage5 = driver.findElement(By.xpath(
				"//*[@id='ctl00_SecureClientPlaceHolder_UcArchivedBgdReqViewer1_pnArchivedFileSearchResultDetail']/div[4]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridpage5);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@id,'cmdReset')]")).click();
		Thread.sleep(5000);
		// -->SEARCH BY FILE NO
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(@id,'txtFileNo')]")).sendKeys("F");
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		WebElement gridpage6 = driver.findElement(By.xpath(
				"//*[@id='ctl00_SecureClientPlaceHolder_UcArchivedBgdReqViewer1_pnArchivedFileSearchResultDetail']/div[4]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridpage6);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(@id,'cmdReset')]")).click();
		Thread.sleep(5000);
		// -->SEARCH BY SITE NO
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[contains(@id,'ddlSiteNo_Input')]")).sendKeys("TEST111-1111");
		driver.findElement(By.xpath("//a[contains(@id,'cmdSearch')]")).click();
		Thread.sleep(5000);
		WebElement gridpage7 = driver.findElement(By.xpath(
				"//*[@id='ctl00_SecureClientPlaceHolder_UcArchivedBgdReqViewer1_pnArchivedFileSearchResultDetail']/div[4]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridpage7);
		Thread.sleep(3000);
		// --> PAGE NAVIGATION
		driver.findElement(By.xpath("//tbody/tr/td[3]/a[contains(text(),'3')]")).click();
		Thread.sleep(5000);
		WebElement gridpage8 = driver.findElement(By.xpath(
				"//*[@id='ctl00_SecureClientPlaceHolder_UcArchivedBgdReqViewer1_pnArchivedFileSearchResultDetail']/div[4]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridpage8);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tbody/tr/td[5]/a[contains(text(),'5')]")).click();
		Thread.sleep(5000);
		WebElement gridpage9 = driver.findElement(By.xpath(
				"//*[@id='ctl00_SecureClientPlaceHolder_UcArchivedBgdReqViewer1_pnArchivedFileSearchResultDetail']/div[4]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridpage9);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tbody/tr/td[7]/a[contains(text(),'7')]")).click();
		Thread.sleep(5000);
		WebElement gridpage10 = driver.findElement(By.xpath(
				"//*[@id='ctl00_SecureClientPlaceHolder_UcArchivedBgdReqViewer1_pnArchivedFileSearchResultDetail']/div[4]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gridpage10);
		System.out.println("-->Offline Reports-Method is Executed Successfully");
		Thread.sleep(7000);
	}

	//@Test(priority = 9)
	public void FileAdjud_FCRA() throws InterruptedException {
		/*
		 * driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		 * driver.findElement(By.xpath("//*[contains(@id,'lnkRequests')]")).click();
		 * driver.findElement(By.xpath("//*[contains(@id,'txtFileNo')]")).sendKeys(fNum)
		 * ; driver.findElement(By.xpath("//*[contains(@id,'cmdSearch')]")).click();
		 * Thread.sleep(4000); WebElement filelink=
		 * driver.findElement(By.xpath("//*[contains(@id,'cmdFileSelected')]"));
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);",filelink);
		 * Thread.sleep(1000); filelink.click();
		 */
		driver.findElement(By.xpath("//*[contains(@id,'lnkHome')]")).click();
		Thread.sleep(18000);
		driver.findElement(By.xpath("//*[contains(text(),'Closed - C')]")).click();
		Thread.sleep(9000);
		WebElement filelink = driver.findElement(By.xpath("//*[contains(@id,'cmdFileSelected')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", filelink);
		Thread.sleep(1000);
		filelink.click();
		Thread.sleep(8000);
		// -->File Adjudication
		WebElement FileAdjud1 = driver.findElement(By.xpath("//span[contains(text(),'File Adjudication')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FileAdjud1);
		if (FileAdjud1.isDisplayed()) {
			System.out.println("File Adjudication is Displayed");
			FileAdjud1.click();
		} else {
			driver.findElement(By.xpath("//span[contains(text(),'Actions')]")).click();
			Thread.sleep(4000);
			WebElement FileAdjud2 = driver.findElement(By.xpath("//span[contains(text(),'File Adjudication')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FileAdjud2);
			FileAdjud2.click();
		}
		Thread.sleep(18000);
		// 1st Adjudication
		driver.findElement(By.xpath("//*[contains(@class,'detailbutton')]")).click();
		Thread.sleep(40000);
		try {

			driver.switchTo().alert().accept();
			Thread.sleep(7000);
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
					Thread.sleep(3000);
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}

		}
		Thread.sleep(5000);try {

			driver.switchTo().alert().accept();
			Thread.sleep(7000);
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
					Thread.sleep(3000);
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}

		}
		Thread.sleep(5000);try {

			driver.switchTo().alert().accept();
			Thread.sleep(7000);
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
					Thread.sleep(3000);
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}

		}
		//Thread.sleep(5000);
		Thread.sleep(40000);
		new Select(driver.findElement(By.xpath("//select[contains(@id,'ddlAdjudication')]"))).selectByValue("YFLAG");
		WebElement emailTo = driver.findElement(By.xpath("//*[contains(@id,'txtEmailTo')]"));
		emailTo.clear();
		emailTo.sendKeys("tpalani@dssiindia.com");
		emailTo.sendKeys((Keys.TAB), "Test Message one", (Keys.TAB));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@id,'lblSave')]")).click();
		Thread.sleep(25000);
		// driver.switchTo().alert().accept();
		try {

			driver.switchTo().alert().accept();
			Thread.sleep(7000);
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
					Thread.sleep(3000);
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}

		}
		Thread.sleep(5000);
		try {

			driver.switchTo().alert().accept();
			Thread.sleep(7000);
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
					Thread.sleep(3000);
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}

		}
		Thread.sleep(5000);try {

			driver.switchTo().alert().accept();
			Thread.sleep(7000);
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
					Thread.sleep(3000);
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}

		}
		Thread.sleep(5000);
		// 2nd Adjudication
		driver.findElement(By.xpath("//*[contains(@class,'detailbutton')]")).click();
		Thread.sleep(55000);
		new Select(driver.findElement(By.xpath("//select[contains(@id,'ddlAdjudication')]"))).selectByValue("GFLAG");
		WebElement emailTo2 = driver.findElement(By.xpath("//*[contains(@id,'txtEmailTo')]"));
		emailTo2.clear();
		emailTo2.sendKeys("tpalani@dssiindia.com");
		emailTo2.sendKeys((Keys.TAB), "Test Message TWO", (Keys.TAB));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@id,'lblSave')]")).click();
		Thread.sleep(25000);
		// driver.switchTo().alert().accept();
		try {

			driver.switchTo().alert().accept();
			Thread.sleep(6000);
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
					Thread.sleep(3000);
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}
		}
		Thread.sleep(5000);
		try {

			driver.switchTo().alert().accept();
			Thread.sleep(6000);
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
					Thread.sleep(3000);
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}
		}
		Thread.sleep(5000);
		try {

			driver.switchTo().alert().accept();
			Thread.sleep(6000);
		} catch (Exception e) {
			try {
				if (e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
					Alert alert = driver.switchTo().alert();

					alert.accept();
					Thread.sleep(3000);
				}
			} catch (NoAlertPresentException e1) {
				e.printStackTrace();
			}
		}
		Thread.sleep(5000);

		// -->FCRA Post Activity/Adverse Notice
		driver.findElement(By.xpath("//span[contains(text(),'FCRA Post Activity/Adverse Notice')]")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[contains(@id,'cmdSelfAdverse')]")).click();
		Thread.sleep(11000);
		try {
		try {
			WebElement ReAdverse = driver.findElement(By.xpath("//*[contains(@id,'btnReprintPreAdverse')]"));

			if (ReAdverse.isDisplayed()) {
				ReAdverse.click();
				Thread.sleep(10000);
			} else {
				driver.findElement(By.xpath("//*[contains(@id,'cmdYesForAdverseQuestion')]")).click();
				Thread.sleep(10000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(10000);
		try {
			driver.findElement(By.xpath("//*[contains(@id,'cmdYesForAdverseQuestion')]")).click();
			Thread.sleep(6000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(10000);
		WebElement print = driver.findElement(By.xpath("//td/a[contains(@id,'cmdPrint')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", print);
		Thread.sleep(3000);
		print.click();
		Thread.sleep(30000);
		ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs_windows.get(1));
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(tabs_windows.get(0));
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id='ctl00_ClientMasterBody']/div[10]/div[11]/div/button/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ctl00_ClientMasterBody']/div[8]/div[11]/div/button/span")).click();
		}catch (Exception e) {}
		Thread.sleep(8000);
		System.out.println("-->'File Adjudication & FCRA'-Method is Executed Successfully");
		Thread.sleep(10000);
		driver.close();
		Thread.sleep(10000);

	}

	@AfterClass
	public void closeBrowser() {
		// driver.close();

	}

}