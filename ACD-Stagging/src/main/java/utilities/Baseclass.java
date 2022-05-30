package utilities;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class Baseclass {
	
	Commonaction commonaction=new Commonaction();
	
	public static WebDriver driver;
	
	@BeforeMethod (onlyForGroups = {"MyAcheck"})
	public void setUp() throws Exception {
		driver=commonaction.startBrowser("chrome");
	}
		


	@AfterMethod 
	public void tearDown() {
		//commonaction.closeBrowser();
	}
	
	
	

}
