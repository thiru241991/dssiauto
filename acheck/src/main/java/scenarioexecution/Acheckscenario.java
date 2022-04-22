package scenarioexecution;


import org.testng.ITestContext;
import org.testng.annotations.Test;

import pages.*;
import utilities.Baseclass;

public class Acheckscenario extends Baseclass{
	
	
	
  @Test	  
  public void executeAcheckScenario(ITestContext ctx) throws InterruptedException {
	  
	  Acheckloginpage acheckloginpage=new Acheckloginpage();
	  Createinvitationpage createinvitationpage=new Createinvitationpage();
		Devdirectloginpage devdirectloginpage=new Devdirectloginpage();
		Mainpage mainpage=new Mainpage();
		Acheckapplicationpage acheckapplicationpage =new Acheckapplicationpage();
  Thread.sleep(10000);
  //<----------------------------MyAcheck-Create Invite- Method---------------->
	  acheckloginpage.login();
	  mainpage.clickMyACheck();
	  mainpage.clickCreateInvitation();
	  createinvitationpage.clickAlacarte();
	  createinvitationpage.clickEducationVerification();
	  createinvitationpage.fillApplicantInformation();
	  //createinvitationpage.fillBillingCode();
	  createinvitationpage.sendInvitation();
	  devdirectloginpage.login();
	  acheckapplicationpage.startApplication();
	  acheckapplicationpage.personalInformation();
	  acheckapplicationpage.education();
	  acheckapplicationpage.auditReview();
	  //acheckapplicationpage.consumerReport();
	  //acheckapplicationpage.investigativeConsumerReport();
	  //acheckapplicationpage.stateNotice();
	  //acheckapplicationpage.consumerReportAuth();
	 // acheckapplicationpage.summaryOfRights();
	  acheckapplicationpage.esign(ctx);
	  System.out.println("MyAcheck-Create Invite- Method is Executed Successfully");
	  Thread.sleep(10000);
	}


}
