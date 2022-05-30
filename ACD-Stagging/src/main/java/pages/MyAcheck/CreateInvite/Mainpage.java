package pages.MyAcheck.CreateInvite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Commonaction;

public class Mainpage extends Commonaction{
	
	
	public Mainpage() {
		PageFactory.initElements(driver, this);
	}
		
	  @FindBy(xpath = "//a[@id='ctl00_lnkAppPortal']")
	    public WebElement myAcheck;
	  
	  @FindBy(xpath = "//a[@id='ctl00_SecureClientPlaceHolder_lnkNewInvitation']")
	    public WebElement createInvitation;
	  
	 
	  public void clickCreateInvitation() throws InterruptedException {
		  Thread.sleep(5000);
		  createInvitation.click();
		  Thread.sleep(5000);
	  }

	public void clickMyACheck() throws InterruptedException {
		Thread.sleep(5000);
		  myAcheck.click();	
		  Thread.sleep(5000);
	}

}
