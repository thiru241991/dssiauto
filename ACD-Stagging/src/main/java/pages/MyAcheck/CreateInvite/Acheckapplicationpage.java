package pages.MyAcheck.CreateInvite;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;

import utilities.Commonaction;

public class Acheckapplicationpage extends Commonaction{
	
	public Acheckapplicationpage() {
		
		PageFactory.initElements(driver, this);
	}
	
	  @FindBy(xpath = "//input[@id='Zip']")
	    public WebElement zip;
	  
	  @FindBy(xpath = "//input[@id='City']")
	    public WebElement city;
	 
	  @FindBy(xpath = "(//input[@class='customCheckbox'])[1]")
	    public WebElement selectfirstzipcheckbox;
	  
	  @FindBy(xpath = "(//button[@class='btn btn-success btn-sm'])[2]")
	    public WebElement countylookupresultsok;
	  
	  @FindBy(xpath = "//select[@id='State']")
	    public WebElement state;
	  
	  @FindBy(xpath = "//button[@value='Start Application']")
	    public WebElement startapplication;
	  
	  @FindBy(xpath = "//input[@id='LegalFirstName']")
	    public WebElement legalfirstname;
	  
	  @FindBy(xpath = "//input[@id='LegalMiddleName']")
	    public WebElement legalmiddlename;
	  
	  @FindBy(xpath = "//input[@id='DateOfBirth']")
	    public WebElement dateofbirth;
	  
	  @FindBy(xpath = "//input[@id='SocialSecurityNumber']")
	    public WebElement socialsecuritynumber;
	  
	  @FindBy(xpath = "//input[@id='ConfirmSSN']")
	    public WebElement confirmssn;
	  
	  @FindBy(xpath = "//input[@id='txtPrimaryPhoneNumber']")
	    public WebElement primaryphonenumber;
	  
	  @FindBy(xpath = "//input[@id='Address_PrimaryAddress']")
	    public WebElement primarystreetaddress;
	  
	  @FindBy(xpath = "//input[@id='txtStartDateC']")
	    public WebElement fromdate;
	  
	  @FindBy(xpath = "(//button[@type='submit'])[2]")
	    public WebElement personalinfosubmit;
	  
	  @FindBy(xpath = "//input[@id='EducationList_0__SchoolAttended']")
	    public WebElement schoolname;
	  
	  @FindBy(xpath = "//select[@id='EducationList_0__DegreeIn']")
	    public WebElement selectdropdowndegree;
	  
	  @FindBy(xpath = "//select[@id='drpgraduate0']")
	    public WebElement selectdropdowndiploma;
	  
	  @FindBy(xpath = "//input[@id='txtStartDate0']")
	    public WebElement startdate;
	  
	  @FindBy(xpath = "//input[@id='txtEndDate0']")
	    public WebElement enddate;
	  
	  @FindBy(xpath = "//select[@id='dpState0']")
	    public WebElement selectdropdowneducationstate;
	    
	  @FindBy(xpath = "//input[@id='EducationList_0__GraduationDate']")
	    public WebElement graduationdate;
	  
	  @FindBy(xpath = "//input[@id='EducationList_0__Address_City']")
	    public WebElement educationcityname;
	  
	  @FindBy(xpath = "(//button[@type='submit'])[3]")
	    public WebElement educationnext;
	  
	  @FindBy(xpath = "//input[@type='checkbox']")
	    public WebElement checkboxconsumerreport;
	  
	  @FindBy(xpath = "(//input[@type='checkbox'])[64]")
	    public WebElement checkboxstatenotice;
	  
	  @FindBy(xpath = "//input[@id='StateChecked0']")
	    public WebElement selectvalueArmedForcesAmer;
	  
	  @FindBy(xpath = "(//p[contains(text(),'Canada Authorization form for e-signature')]/following::div[@class='Esign btns'])[1]/button")
	    public WebElement canadaauthorizationsignform;
	  
	  @FindBy(xpath = "(//p[contains(text(),'Authorization Form to Disclose PII - Canada')]/following::div[@class='Esign btns'])[1]/button")
	    public WebElement canadaauthorizationformsignbutton;
	  
	  @FindBy(xpath = "//input[@id='cp-SignBtn']")
	    public WebElement signform;
	  
	  @FindBy(xpath = "(//button[@type='submit'])[5]")
	    public WebElement authorizationmedicalsignform;
	  
	  
	  public void startApplication() throws InterruptedException {
		  Thread.sleep(10000);
		  scrollToElement(zip);
		  zip.sendKeys("80127");
		  city.click();
		  waitForElementToBeClickable(selectfirstzipcheckbox,15);
		  selectfirstzipcheckbox.click();
		  countylookupresultsok.click();
		  scrollToElement(startapplication);
		  startapplication.click();
	  }
	  
	  public void personalInformation() throws InterruptedException {
		  sleep(10000);
		  legalmiddlename.sendKeys("Tester");
		  waitForElementToBeClickable(dateofbirth,15);
		  dateofbirth.click();
		  dateofbirth.sendKeys("05051995");
		  sleep(4000);
		  socialsecuritynumber.click();
		  socialsecuritynumber.sendKeys("123456789");
		  sleep(7000);
		  confirmssn.click();
		  confirmssn.sendKeys("123456789");
		  scrollPage(200);
		  primaryphonenumber.click();
		  primaryphonenumber.sendKeys("1234567890");
		  scrollPage(200);
		  primarystreetaddress.sendKeys("Street address");
		  scrollPage(200);
		  fromdate.sendKeys("05051999");
		  scrollPage(200);   
		  sleep(3000);
		  personalinfosubmit.click();
	  }
	  
	  public void education() throws InterruptedException {
		  sleep(10000);
		  schoolname.sendKeys("Test");
		  dropdownSelect(selectdropdowndegree,"HIGH SCHOOL DIPLOMA");
		  dropdownSelect(selectdropdowndiploma,"GRADUATED");
		  startdate.sendKeys("06061996");
		  enddate.sendKeys("07071996");
		  graduationdate.sendKeys("07071996");
		  dropdownSelect(selectdropdowneducationstate,"AA");		  
		  educationcityname.sendKeys("test");
		  educationnext.click();
	  }
	  
	  public void auditReview() throws InterruptedException {
		  sleep(10000);
		  personalinfosubmit.click();
	  }
	  
	public void consumerReport() throws InterruptedException {
		  sleep(10000);
		checkboxconsumerreport.click();
		  personalinfosubmit.click();
	}
	
	public void investigativeConsumerReport() throws InterruptedException {
		
		  sleep(10000);
		checkboxconsumerreport.click();
		  personalinfosubmit.click();
	}
	
	public void stateNotice() throws InterruptedException {
		sleep(7000);
		selectvalueArmedForcesAmer.click();

		  sleep(7000);
		checkboxstatenotice.click();
		  personalinfosubmit.click();
		  
	}
	
	public void consumerReportAuth() throws InterruptedException{
		  sleep(10000);
		checkboxconsumerreport.click();
		
		  personalinfosubmit.click();
	}
	
	public void summaryOfRights() throws InterruptedException {
		  sleep(10000);

		checkboxconsumerreport.click();
		  personalinfosubmit.click();
	}
	
	public void esign(ITestContext ctx) throws InterruptedException {
		  sleep(10000);
		  try {
		  if(canadaauthorizationformsignbutton!=null) {
				canadaauthorizationformsignbutton.click();
				sleep(8000);
				  pageDownScroll();
				  //sleep(8000);
				  Thread.sleep(7000);
				  //driver.switchTo().frame("cp-navworkspace");
				  driver.switchTo().frame("cp-navworkspace");
				  new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cp-SignBtn']"))).click();
				  //Thread.sleep(10000);
				 // driver.findElement(By.xpath("//*[@id='cp-SignBtn']")).click();
				  sleep(20000);
				  driver.switchTo().defaultContent();
				  //tabKey();	
				//jsSendKeys(signform,ClickAction);
				  //signform.click();
				  //driver.findElement(By.xpath("//*[@id='BackButton']")).click();
				  
				 // js.executeScript("arguments[0].click();", signform);
			  
				  //signform.click();
			}
		  
		if(canadaauthorizationsignform!=null) {
			canadaauthorizationsignform.click();
			
			  sleep(8000);
			  pageDownScroll();
			  //sleep(8000);
			 // driver.findElement(By.xpath("//*[@id='cp-SignBtn']")).click();
			  //tabKey();
			  Thread.sleep(7000);
			  
			  //new WebDriverWait(driver, 3).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@id, 'sp_message_iframe')]")));
			  driver.switchTo().frame("cp-navworkspace");
			  new WebDriverWait(driver, 4).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cp-SignBtn']"))).click();
			  
			  sleep(4000);
			  sleep(20000);
			  //driver.findElement(By.xpath("//*[@id='cp-SignBtn']")).click();
			  driver.switchTo().defaultContent();
			  //js.executeScript("arguments[0].click();", signform);
			  //signform.click();
			  //driver.findElement(By.xpath("//*[@id='BackButton']")).click();
			  
			  }}catch (Exception e) {
				// TODO: handle exception
			}
		
		  driver.findElement(By.xpath("//*[@id='frmNextBtn']/div[2]/div/div[2]/button")).click();
		//personalinfosubmit.click();
		sleep(9000);
		driver.findElement(By.xpath("//*[@id='frmConfirmation']/div/button")).click();
		Thread.sleep(10000);
		/*ArrayList<String> tabs_windows = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs_windows.get(1));*/
	    Thread.sleep(8000);
		  String fileno=driver.findElement(By.xpath("//span[contains(text(),'File Number')]//following::strong")).getText();
		  System.out.println("MyAcheck-File Number is successfully created-->"+fileno);
		  //ISuite suite = ctx.getSuite();
		  ctx.setAttribute("fileno", fileno);
		  Thread.sleep(7000);
		 driver.quit();
		  
	}
	


	
	
	

}
