package pages.MyAcheck.CreateInvite;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Commonaction;
import utilities.Emailconfiguration;

public class Devdirectloginpage extends Commonaction{
	
	Emailconfiguration emailconfiguration=new Emailconfiguration();
	
	public Devdirectloginpage() {
		PageFactory.initElements(driver, this);
	}
		
  @FindBy(xpath = "//input[@id='username']")
    public WebElement username;
  
  @FindBy(xpath = "//input[@id='password']")
    public WebElement password;
  
  @FindBy(xpath = "//input[@id='confirmpassword']")
    public WebElement confirmpassword;

  @FindBy(xpath = "//button[@type='submit']")
  public WebElement submit;
  
  @FindBy(xpath = "//button[contains(text(),'Accept Cookies')]")
  public WebElement acceptcookies;
  

public void login() throws InterruptedException {
	  sleep(360000);

	  openUrl(emailconfiguration.readMails());
		if(acceptcookies!=null) {
			UUID.randomUUID().toString();
			String s= RandomStringUtils.randomAlphanumeric(10);
			  waitForElementToBeClickable(acceptcookies,15);
				username.sendKeys(s);
				  password.sendKeys("Tester1@");
				  confirmpassword.sendKeys("Tester1@");
				  Thread.sleep(6000);
				  acceptcookies.click();
				  sleep(4000);

			  submit.click();	
			  Thread.sleep(8000);
             }
		else {
			username.sendKeys("gopinath34");
			  password.sendKeys("Tester1@");
			  confirmpassword.sendKeys("Tester1@");
			  submit.click();
		}
}

}
