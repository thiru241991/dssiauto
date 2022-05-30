package pages.MyAcheck.BulkInvite;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Commonaction;

public class Mainpage2 extends Commonaction{
	
	
	public Mainpage2() {
		PageFactory.initElements(driver, this);
	}
		
	  @FindBy(xpath = "//*[contains(@id,'lnkAppPortal')]")
	    public WebElement myAcheck;
	  
	  @FindBy(xpath = "//*[contains(@id,'lnkBulkInvitation')]")
	    public WebElement createBulkInvitation;
	  
	 
	  public void clickCreateInvitation() throws InterruptedException {
		  Thread.sleep(4000);
		  createBulkInvitation.click();
		  Thread.sleep(5000);
	  }

	public void clickMyACheck() throws InterruptedException {
		Thread.sleep(4000);
		  myAcheck.click();	
		  Thread.sleep(4000);
	}

	public void fileUpload() throws InterruptedException {
		Thread.sleep(6000);
		//driver.findElement(By.xpath("//*[contains(@id,'FileUpload1')]")).sendKeys("C:\\Users\\tpalani\\Documents\\BulkInvitation-Template.xls");
		File file1 = new File("data/BulkInvitation-Template.xls");
		driver.findElement(By.xpath("//*[contains(@id,'FileUpload1')]")).sendKeys(file1.getAbsolutePath());
		//Thread.sleep(4000);
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[contains(@id,'cmdUpload')]")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[contains(@id,'chkAll')]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id='ctl00_PublicPlaceHolder_grvExcel']/tbody/tr[12]/td/table/tbody/tr/td[2]/a")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[contains(@id,'chkAll')]")).click();
		driver.findElement(By.xpath("//*[contains(@id,'cmdEditExcelData')]")).click();
		Thread.sleep(50000);
	}
}
