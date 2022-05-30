package pages.MyAcheck.BulkInvite;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Commonaction;

public class Createinvitationpage2 extends Commonaction{

	public Createinvitationpage2() {
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath = "//*[contains(@id,'lnkAlaCart')]")
	    public WebElement Alacarte;
	  
	  @FindBy(xpath = "//*[contains(text(),'EDUCATION VERIFICATION')]/parent::td/input")
	    public WebElement educationverification;
	//*[contains(@id,'ctl55_chkSelect')]
	  @FindBy(xpath = "//input[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_txtFName']")
	    public WebElement firstname;
	  
	  @FindBy(xpath = "//input[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_txtLName']")
	    public WebElement lastname;
	  
	  @FindBy(xpath = "//input[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_txtEmailAdd']")
	    public WebElement emailaddress;
	  
	  @FindBy(xpath = "//a[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_lnkSBilling']")
	    public WebElement Assign;
	  
	  @FindBy(xpath = "//*[contains(@id,'ctl01_rcbCodeValues')]")
	    public WebElement accountcodeclick;
	  
	  @FindBy(xpath = "//div[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_UcAppSpecialBilling_dlsAppReportList_ctl01_rcbCodeValues_c1']")
	    public WebElement accountcodevalue;
	  
	  @FindBy(xpath = "//input[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_UcAppSpecialBilling_dlsAppReportList_ctl02_rcbCodeValues_Input']")
	    public WebElement recrutingarea;
	  
	  @FindBy(xpath = "//input[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_UcAppSpecialBilling_dlsAppReportList_ctl03_rcbCodeValues_Input']")
	    public WebElement assignmentnumber;
	  
	  @FindBy(xpath = "//*[contains(@id,'ctl02_rcbCodeValues')]")
	    public WebElement costcenterclick;
	  
	  @FindBy(xpath = "//div[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_UcAppSpecialBilling_dlsAppReportList_ctl04_rcbCodeValues_c1']")
	    public WebElement costcentervalue;
	
	  @FindBy(xpath = "//*[contains(@id,'cmdValidate')]")
	    public WebElement sendinvitation;
	  	  
	  public void clickEducationVerification() throws InterruptedException {
		  Thread.sleep(5000);
		  scrollToElement(educationverification);
		  educationverification.click();
	  }
	  

	  public void fillBillingCode() throws InterruptedException {
		  Thread.sleep(6000);
		  scrollToElement(accountcodeclick);
		  //accountcodeclick.click();
		  //dropdownSelect(accountcodeclick,"111");
		  
		 //accountcodevalue.click();
		 // recrutingarea.sendKeys("1");
		  //assignmentnumber.sendKeys("1");
		  scrollToElement(costcenterclick);
		  //costcenterclick.click();
		  dropdownSelect(costcenterclick,"11111");
		  //dropdownbytext(costcenterclick, "11111");
		  //tabKey();
		  
		sleep(2000);
		tabKey();
		//costcenterclick.sendKeys(Keys.TAB).sendKeys(Keys.ENTER);
		
		 // accountcodeclick.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER);
		Thread.sleep(28000);
		
		//
	  }
	  
	  public void sendInvitation() throws InterruptedException {
		  sendinvitation.click();
		  sleep(16000);
		  driver.switchTo().alert().accept();
		  Thread.sleep(6000);
		  driver.findElement(By.xpath("//*[contains(@id,'cmdStartProcess')]")).click();
		  sleep(16000);
		  driver.switchTo().alert().accept();
		  Thread.sleep(6000);
		  driver.close();
		  Thread.sleep(4000);
	  }

	public void clickAlacarte() throws InterruptedException {
		Thread.sleep(8000);
		Alacarte.click();	
		Thread.sleep(14000);
	}
	  
	  
	  
}
