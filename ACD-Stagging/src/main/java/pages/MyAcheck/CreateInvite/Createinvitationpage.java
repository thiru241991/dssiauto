package pages.MyAcheck.CreateInvite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Commonaction;

public class Createinvitationpage extends Commonaction{

	public Createinvitationpage() {
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath = "//*[contains(text(),'A LA CARTE')]")
	    public WebElement Alacarte;
	  
	  @FindBy(xpath = "//*[contains(text(),'EDUCATION VERIFICATION')]/parent::td/input")
	    public WebElement educationverification;
	  
	  @FindBy(xpath = "//input[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_txtFName']")
	    public WebElement firstname;
	  
	  @FindBy(xpath = "//input[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_txtLName']")
	    public WebElement lastname;
	  
	  @FindBy(xpath = "//input[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_txtEmailAdd']")
	    public WebElement emailaddress;
	  
	  @FindBy(xpath = "//a[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_lnkSBilling']")
	    public WebElement Assign;
	  
	  @FindBy(xpath = "//img[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_UcAppSpecialBilling_dlsAppReportList_ctl01_rcbCodeValues_Image']")
	    public WebElement accountcodeclick;
	  
	  @FindBy(xpath = "//div[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_UcAppSpecialBilling_dlsAppReportList_ctl01_rcbCodeValues_c1']")
	    public WebElement accountcodevalue;
	  
	  @FindBy(xpath = "//input[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_UcAppSpecialBilling_dlsAppReportList_ctl02_rcbCodeValues_Input']")
	    public WebElement recrutingarea;
	  
	  @FindBy(xpath = "//input[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_UcAppSpecialBilling_dlsAppReportList_ctl03_rcbCodeValues_Input']")
	    public WebElement assignmentnumber;
	  
	  @FindBy(xpath = "//img[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_UcAppSpecialBilling_dlsAppReportList_ctl04_rcbCodeValues_Image']")
	    public WebElement costcenterclick;
	  
	  @FindBy(xpath = "//div[@id='ctl00_SecureClientPlaceHolder_UcApplicant1_ucApplicant0_UcAppSpecialBilling_dlsAppReportList_ctl04_rcbCodeValues_c1']")
	    public WebElement costcentervalue;
	
	  @FindBy(xpath = "//a[@id='ctl00_SecureClientPlaceHolder_UcBgdFeeSummary1_cmdNewRequest2']")
	    public WebElement sendinvitation;
	  	  
	  public void clickEducationVerification() throws InterruptedException {
		  Thread.sleep(5000);
		  scrollToElement(educationverification);
		  educationverification.click();
		  Thread.sleep(5000);
	  }
	  
	  public void fillApplicantInformation() throws InterruptedException {
		  Thread.sleep(5000);
		  firstname.sendKeys("tester");
		  lastname.sendKeys("tester");
		  emailaddress.sendKeys("thiruvenkhadan1991@outlook.com");
		  Assign.click();		  
	  }
	  
	  public void fillBillingCode() {
		  accountcodeclick.click();
		  accountcodevalue.click();
		  recrutingarea.sendKeys("1");
		  assignmentnumber.sendKeys("1");
		  costcenterclick.click();
		  costcentervalue.click();
	  }
	  
	  public void sendInvitation() throws InterruptedException {
		  Thread.sleep(5000);
		  sendinvitation.click();
		  Thread.sleep(5000);
	  }

	public void clickAlacarte() throws InterruptedException {
		Thread.sleep(5000);
		Alacarte.click();	
		Thread.sleep(5000);
	}
	  
	  
	  
}
