package pages.MyAcheck.CreateInvite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Commonaction;

public class Acheckloginpage extends Commonaction{
	


	public Acheckloginpage() {
	
		PageFactory.initElements(driver, this);
	}
		
  @FindBy(xpath = "//input[@id='Username']")
    public WebElement username;
  
  @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;
  
  @FindBy(xpath = "//input[@id='login-btn']")
    public WebElement login;
  

public void login() throws InterruptedException {
	  openUrl("https://devdirect.acheckamerica.com/Acheckdirect20/");
	  username.sendKeys("tteam02");
	  password.sendKeys("Tester1@");
	  //login.click();
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
	  Thread.sleep(5000);
}

}
