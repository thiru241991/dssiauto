using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using SeleniumExtras.WaitHelpers;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ACD.Tests.Modules
{
    class ACD
    {
        IWebDriver driver;
        public IJavaScriptExecutor js;
        public string fileNum;
        /*public string strfunction(string input)
        {
            string strmessage = input;
            return strmessage;
        }*/
        [Test, Order(1)]
        public void startTest()
        {
            driver = new ChromeDriver();
            driver.Manage().Window.Maximize();
            driver.Url = "https://devdirect.acheckamerica.com/Acheckdirect20/";
            driver.FindElement(By.Id("Username")).SendKeys("tteam02");
            driver.FindElement(By.Id("Password")).SendKeys("Tester1@");
            Thread.Sleep(4000);
            driver.FindElement(By.XPath("//*[@id='loginForm']/form/div[3]/div/input")).Click();
            Thread.Sleep(16000);
            IWebElement classicDash = null;
            try
            {
                classicDash = driver.FindElement(By.XPath("//*[contains(text(),' Switch to Classic Dashboard ')]"));
                if (classicDash.Displayed)
                {
                    classicDash.Click();
                    Thread.Sleep(5000);
                }
                else
                {
                    driver.FindElement(By.XPath("//*[contains(@id,'lnkNewRequest')]")).Click();
                    Thread.Sleep(5000);
                }
                Thread.Sleep(7000);
            }
            catch (Exception e)
            {
            }
        }

        [Test, Order(2)]
        public void FileCreation()
        {

            try
            {
                // submit-request
                driver.FindElement(By.XPath("//*[contains(@id,'lnkNewRequest')]")).Click();
            }
            catch (Exception e)
            {
                // TODO: handle exception
            }

            // A LA CARTE
            Thread.Sleep(5000);
            driver.FindElement(By.XPath("//*[contains(@id,'lnkAlaCart')]")).Click();
            Thread.Sleep(2000);
            driver.FindElement(By.XPath("//label[contains(text(),'EDUCATION VERIFICATION')]//preceding::input[1]")).Click();
            driver.FindElement(By.XPath("//label[contains(text(),'PRIORITY STATUS')]//preceding::input[1]")).Click();
            driver.FindElement(By.XPath("//*[contains(@id,'cmdNewRequest')]")).Click();

            // Applicant-Basic details Page
            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
            Thread.Sleep(22000);
            driver.FindElement(By.XPath("//*[contains(@id,'txtFirstName')]")).SendKeys("firstName");
            Thread.Sleep(5000);
            driver.FindElement(By.XPath("//*[contains(@id,'txtMiddleName')]")).SendKeys("middleName");
            Thread.Sleep(5000);
            driver.FindElement(By.XPath("//*[contains(@id,'txtLastName')]")).SendKeys("lastName");
            IWebElement ctry = driver.FindElement(By.XPath("//*[contains(@id,'ddlCountry')]"));
            SelectElement s = new SelectElement(ctry);
            s.SelectByText("UNITED STATES");
            // new Select(ctry).selectByVisibleText("UNITED STATES");
            ctry.SendKeys(Keys.Tab);
            Thread.Sleep(8000);
            IWebElement SSN = driver.FindElement(By.XPath("//*[contains(@id,'maskTxtSSN_text')]"));
            SSN.SendKeys("555555555");
            SSN.SendKeys(Keys.Tab);
            // Thread.Sleep(16000);
            // ssn window box
            new WebDriverWait(driver, TimeSpan.FromSeconds(20)).Until(ExpectedConditions.ElementToBeClickable(By.XPath(
                    "//*[@id='ctl00_SecureClientPlaceHolder_BgdNewRequestContainer1_BgdNewRequestWizard1_ctl00_ctl01_imgCloseThis']")));
            IWebElement newWinChkBox2 = null;
            try

            {
                newWinChkBox2 = driver.FindElement(By.XPath(
                        "//*[@id=\'ctl00_SecureClientPlaceHolder_BgdNewRequestContainer1_BgdNewRequestWizard1_ctl00_ctl01_imgCloseThis\']"));
                // WebDriverWait wait = new WebDriverWait(driver,17);
                // wait.until(ExpectedConditions.visibilityOfElementLocated(By.XPath("//*[@id=\'ctl00_SecureClientPlaceHolder_BgdNewRequestContainer1_BgdNewRequestWizard1_ctl00_ctl01_imgCloseThis\']")));
                if (newWinChkBox2.Enabled)
                {

                    newWinChkBox2.Click();
                    Thread.Sleep(10000);
                }
            }
            catch (Exception e)
            {
            }
            // js.executeScript("arguments[0].Click();",
            // driver.FindElement(By.XPath("(//*[contains(@id,'imgCloseThis')])[2]")));
            Thread.Sleep(10000);
            IWebElement SSNRe = driver.FindElement(By.XPath("//*[contains(@id,'maskTxtSSNReEnter_text')]"));
            SSNRe.SendKeys("555555555");
            SSNRe.SendKeys(Keys.Tab);
            driver.FindElement(By.XPath("//*[contains(@id,'cbxNoValidSSN')]")).SendKeys(Keys.Tab);
            IWebElement DOB = driver.FindElement(By.XPath("//*[contains(@id,'maskTxtDob_text')]"));
            DOB.SendKeys("08091991");
            DOB.SendKeys(Keys.Tab);
            driver.FindElement(By.XPath("//*[contains(@id,'txtAddress')]")).SendKeys(Keys.Tab);
            IWebElement ZIpCode = driver.FindElement(By.XPath("//*[contains(@id,'ZipCode_text')]"));
            ZIpCode.SendKeys("12205");
            ZIpCode.SendKeys(Keys.Tab);

            Thread.Sleep(20000);
            // zip windowbox
            IWebElement newWinChkBox = null;
            try

            {

                newWinChkBox = driver.FindElement(By.XPath(
                        "//*[@id=\'ctl00_SecureClientPlaceHolder_BgdNewRequestContainer1_BgdNewRequestWizard1_ctl00_ctl01_UcZipCodeLookUp1_imgClose\']"));
                // WebDriverWait wait = new WebDriverWait(driver,12);
                // wait.until(ExpectedConditions.visibilityOfElementLocated(By.XPath("//*[@id=\'ctl00_SecureClientPlaceHolder_BgdNewRequestContainer1_BgdNewRequestWizard1_ctl00_ctl01_UcZipCodeLookUp1_imgClose\']")));
                if (newWinChkBox.Enabled)
                {
                    driver.FindElement(By.XPath(
                            "//*[@id='ctl00_SecureClientPlaceHolder_BgdNewRequestContainer1_BgdNewRequestWizard1_ctl00_ctl01_UcZipCodeLookUp1_grdSearchResults_ctl02_chkSelected']"))
                            .Click();
                    driver.FindElement(By.XPath(
                            "//*[@id=\'ctl00_SecureClientPlaceHolder_BgdNewRequestContainer1_BgdNewRequestWizard1_ctl00_ctl01_UcZipCodeLookUp1_cmdSelectCounty\']"))
                            .Click();
                    // newWinChkBox.Click();
                    Thread.Sleep(10000);
                }
            }
            catch (Exception e)
            {
            }
            // driver.FindElement(By.XPath("//*[contains(@id,'grdSearchResults')]//following::input[1]")).Click();
            // driver.FindElement(By.XPath("//*[contains(@id,'grdSearchResults')]//following::input[@value='Select']")).Click();
            Thread.Sleep(20000);
            IWebElement ele = driver.FindElement(By.XPath("//*[contains(@id,'cmdContinue')]"));
            js.ExecuteScript("arguments[0].scrollIntoView(true);", ele);
            Thread.Sleep(2000);
            ele.Click();
            Thread.Sleep(22000);

            // nextPage
            // js.executeScript("arguments[0].scrollIntoView(true);",
            // driver.FindElement(By.XPath("//*[contains(@id,'ddlStateList')]")));
            driver.FindElement(By.XPath("//*[contains(@id,'cmdContinue')]")).Click();
            Thread.Sleep(29000);

            // Educational Page
            driver.FindElement(By.XPath("//*[contains(@id,'txtSchool')]")).SendKeys("school");
            driver.FindElement(By.XPath("//*[contains(@id,'txtCity')]")).SendKeys("eduCity");
            js.ExecuteScript("arguments[0].scrollIntoView(true);",
                    driver.FindElement(By.XPath("//*[contains(@id,'btnTabBgdComEdu')]")));
            new SelectElement(driver.FindElement(By.XPath("//*[contains(@id,'ddlState')]"))).SelectByValue("DC");
            new SelectElement(driver.FindElement(By.XPath("//*[contains(@id,'ddlCountry')]"))).SelectByText("UNITED STATES");
            js.ExecuteScript("arguments[0].scrollIntoView(true);",
                    driver.FindElement(By.XPath("//*[contains(@id,'lblSchoolEmail')]")));
            new SelectElement(driver.FindElement(By.XPath("//*[contains(@id,'ddlDegree')]"))).SelectByText("PHD");
            new SelectElement(driver.FindElement(By.XPath("//*[contains(@id,'ddlGraduated')]"))).SelectByText("YES");
            Thread.Sleep(28000);
            IWebElement graddate = driver.FindElement(By.XPath("//*[contains(@id,'txtGraduationDate')]"));
            graddate.SendKeys("02/2009");
            graddate.SendKeys(Keys.Enter);

            // js.executeScript("arguments[0].scrollIntoView(true);",
            // driver.FindElement(By.XPath("//*[contains(@id,'lbTitle')]")));
            Thread.Sleep(35000);
            driver.FindElement(By.XPath("//*[contains(@id,'cmdContinue')]")).Click();
            Thread.Sleep(23000);
            try
            {

                driver.SwitchTo().Alert().Accept();
            }
            catch (Exception e)
            {
                try
                {
                    if (e.ToString().Contains("org.openqa.selenium.UnhandledAlertException"))
                    {
                        IAlert alert = driver.SwitchTo().Alert();

                        alert.Accept();
                    }
                }
                catch (NoAlertPresentException e1)
                {
                    //e.StackTrace();
                }
            }
            Thread.Sleep(5000);
            try
            {

                driver.SwitchTo().Alert().Accept();
            }
            catch (Exception e)
            {
                try
                {
                    if (e.ToString().Contains("org.openqa.selenium.UnhandledAlertException"))
                    {
                        IAlert alert = driver.SwitchTo().Alert();

                        alert.Accept();
                    }
                }
                catch (NoAlertPresentException e1)
                {
                    //e.printStackTrace();
                }
            }
            Thread.Sleep(5000);

            // Billing Page
            // driver.FindElement(By.XPath("//*[contains(text(),'ACCOUNT
            // CODE')]//following::img[1]")).Click();
            // driver.FindElement(By.XPath("//*[contains(@id,'rcbCodeValues_c1')]")).Click();
            // driver.FindElement(By.XPath("//*[contains(text(),'COST
            // CENTER')]//following::img[1]")).Click();
            // -->driver.FindElement(By.XPath("//*[contains(@id,'ctl03_rcbCodeValues_Input')]")).SendKeys("1");
            // driver.FindElement(By.XPath("//*[contains(text(),'RECRUITING
            // AREA')]//following::input[1]")).SendKeys(rectArea);

            // js.executeScript("arguments[0].scrollIntoView(true);",
            // driver.FindElement(By.XPath("//*[contains(text(),'COST CENTER')]")));
            // driver.FindElement(By.XPath("//*[contains(@id,'txtInvoiceNotes')]")).SendKeys(invoiceNotes);
            driver.FindElement(By.XPath("//*[contains(@id,'cmdSubmit')]")).Click();
            Thread.Sleep(28000);

            fileNum = driver.FindElement(By.XPath("//*[contains(@id,'lblFileNumber')]")).Text;
            // return fileNum;
            Console.WriteLine("ACD-File Number is Successfully created -->" + fileNum);
            //return fileNum

            //SetAttribute("fileNum", fileNum);
            // addReport(fileNum);
            // driver.FindElement(By.XPath("//*[contains(@id,'lnkHome')]")).Click();
            Thread.Sleep(16000);

        }

        /*
         * //@Test(priority = 1)public static void test(ITestContext ctx) throws
         * InterruptedException { ctx.setAttribute("fileNum", fileNum); String fileNum =
         * "23ee"; System.out.println("File Number->"+fileNum);
         * 
         * //this.fileNum=filenNum; //addReport(fileNum); }
         */

        [Test, Order(3)]
        public void addReport()
        {
            /*
             * driver.FindElement(By.XPath("//*[contains(@id,'lnkHome')]")).Click();
             * Thread.Sleep(6000);
             * driver.FindElement(By.XPath("//*[contains(text(),'Draft - DFT')]")).Click();
             * Thread.Sleep(6000);
             * 
             * IWebElement DisputedFiles=
             * driver.FindElement(By.XPath("//*[contains(text(),'Disputed Files')]"));
             * Actions actions = new Actions(driver); // Scroll Down using Actions class
             * actions.doubleClick(DisputedFiles).perform(); Thread.Sleep(3000);
             * ((JavascriptExecutor)
             * driver).executeScript("arguments[0].scrollIntoView(true);",DisputedFiles);
             * DisputedFiles.Click(); Thread.Sleep(3000);
             */
            //String fNum = (String) ctx.getAttribute("fileNum");
            driver.FindElement(By.XPath("//*[contains(@id,'lnkRequests')]")).Click();
            driver.FindElement(By.XPath("//*[contains(@id,'txtFileNo')]")).SendKeys(fileNum);
            driver.FindElement(By.XPath("//*[contains(@id,'cmdSearch')]")).Click();
            Thread.Sleep(4000);

            IWebElement filelink = driver.FindElement(By.XPath("//*[contains(@id,'cmdFileSelected')]"));
            ((IJavaScriptExecutor)driver).ExecuteScript("arguments[0].scrollIntoView(true);", filelink);
            Thread.Sleep(1000);
            filelink.Click();
            Thread.Sleep(4000);
            driver.FindElement(By.XPath("//span[contains(text(),'Actions')]")).Click();
            Thread.Sleep(2000);
            driver.FindElement(By.XPath("//span[contains(text(),'Add Report')]")).Click();
            Thread.Sleep(4000);
            /*
             * //>>Add report ->2 Components driver.FindElement(By.
             * XPath("//label[contains(text(),'ADDRESS HISTORY')]//preceding::input[1]")).
             * Click(); driver.FindElement(By.
             * XPath("//label[contains(text(),'CONSOLidATED SCREENING LIST')]//preceding::input[1]"
             * )).Click();
             * driver.FindElement(By.XPath("//*[contains(@id,'lnkAdd')]")).Click();
             * Thread.Sleep(5000);
             * 
             * driver.FindElement(By.XPath("//*[contains(@id,'lnkContinue')]")).Click();
             * Thread.Sleep(5000);
             * driver.FindElement(By.XPath("//*[contains(@id,'lnkContinue')]")).Click();
             * Thread.Sleep(5000);
             * driver.FindElement(By.XPath("//*[contains(@id,'lnkContinue')]")).Click();
             * Thread.Sleep(5000);
             * driver.FindElement(By.XPath("//*[contains(@id,'lnkContinue')]")).Click();
             * Thread.Sleep(7000); //>>Add report ->3 Components
             * //driver.FindElement(By.XPath("//span[contains(text(),'Actions')]")).Click();
             * driver.FindElement(By.XPath("//span[contains(text(),'Add Report')]")).Click()
             * ; Thread.Sleep(4000);
             */
            // driver.FindElement(By.XPath("//label[contains(text(),'DOT DRUG
            // SCREEN')]//preceding::input[1]")).Click();
            // driver.FindElement(By.XPath("//label[contains(text(),'FEDERAL BUREAU OF
            // PRISONS')]//preceding::input[1]")).Click();
            // driver.FindElement(By.XPath("//label[contains(text(),'INTERPOL')]//preceding::input[1]")).Click();
            // driver.FindElement(By.XPath("//label[contains(text(),'ADDRESS
            // HISTORY')]//preceding::input[1]")).Click();
            driver.FindElement(By.XPath("//label[contains(text(),'AUDIOGRAM')]//preceding::input[1]")).Click();
            driver.FindElement(By.XPath("//label[contains(text(),'EVIDENTIAL BREATH TESTING')]//preceding::input[1]"))
                    .Click();
            driver.FindElement(By.XPath("//*[contains(@id,'lnkAdd')]")).Click();
            Thread.Sleep(5000);

            // driver.FindElement(By.XPath("//*[contains(@id,'chkPaperECOC')]")).Click();
            driver.FindElement(By.XPath("//*[contains(@id,'lnkContinue')]")).Click();
            Thread.Sleep(5000);
            driver.FindElement(By.XPath("//*[contains(@id,'lnkContinue')]")).Click();
            Thread.Sleep(5000);
            driver.FindElement(By.XPath("//*[contains(@id,'lnkContinue')]")).Click();
            Thread.Sleep(5000);
            driver.FindElement(By.XPath("//*[contains(@id,'lnkContinue')]")).Click();
            /*
             * Thread.Sleep(5000);
             * driver.FindElement(By.XPath("//*[contains(@id,'lnkContinue')]")).Click();
             * Thread.Sleep(5000);
             * driver.FindElement(By.XPath("//*[contains(@id,'lnkContinue')]")).Click();
             */
            Thread.Sleep(7000);
            IWebElement totalprice = driver.FindElement(By.XPath("//span[contains(text(),'Total Price')]"));
            ((IJavaScriptExecutor)driver).ExecuteScript("arguments[0].scrollIntoView(true);", totalprice);
            Console.WriteLine("-->Add Report-Method is Executed Successfully");
            Thread.Sleep(7000);
        }

        [Test, Order(4)]
        public void docUpload()
        {

            // driver.FindElement(By.XPath("//*[contains(@id,'lnkHome')]")).Click();
            /*
             * Thread.Sleep(6000);
             * driver.FindElement(By.XPath("//*[contains(text(),'Draft - DFT')]")).Click();
             * Thread.Sleep(6000);
             * 
             * IWebElement DisputedFiles=
             * driver.FindElement(By.XPath("//*[contains(text(),'Disputed Files')]"));
             * Actions actions = new Actions(driver); // Scroll Down using Actions class
             * actions.doubleClick(DisputedFiles).perform(); Thread.Sleep(3000);
             * ((JavascriptExecutor)
             * driver).executeScript("arguments[0].scrollIntoView(true);",DisputedFiles);
             * DisputedFiles.Click(); Thread.Sleep(3000);
             */
            //String fNum = (String) ctx.getAttribute("fileNum");
            driver.FindElement(By.XPath("//*[contains(@id,'lnkRequests')]")).Click();
            driver.FindElement(By.XPath("//*[contains(@id,'txtFileNo')]")).SendKeys(fileNum);
            driver.FindElement(By.XPath("//*[contains(@id,'cmdSearch')]")).Click();
            Thread.Sleep(4000);

            IWebElement filelink = driver.FindElement(By.XPath("//*[contains(@id,'cmdFileSelected')]"));
            ((IJavaScriptExecutor)driver).ExecuteScript("arguments[0].scrollIntoView(true);", filelink);
            Thread.Sleep(1000);
            filelink.Click();
            // driver.FindElement(By.XPath("//*[contains(@id,'cmdFileSelectElemented')]")).Click();

            Thread.Sleep(4000);
            driver.FindElement(By.XPath("//span[contains(text(),'File Info')]")).Click();
            driver.FindElement(By.XPath("//span[contains(text(),'Documents')]")).Click();
            Thread.Sleep(4000);
            // ->Documents uploding
            driver.FindElement(By.XPath("//*[contains(text(),'Add Document')]")).Click();
            Thread.Sleep(14000);
            string folder = Path.GetDirectoryName(Assembly.GetExecutingAssembly().Location);
            string file1 = Path.Combine(folder, "data/Testing PDF.pdf");
            //File file1 = new File("data/Testing PDF.pdf");
            driver.FindElement(By.XPath("//*[contains(@id,'fileToUpload')]")).SendKeys(file1);
            Thread.Sleep(4000);
            new SelectElement(driver.FindElement(By.XPath("//*[contains(@id,'ddlDocDesc')]"))).SelectByText("AFFIDAVITS");
            driver.FindElement(By.XPath("//*[contains(@id,'cmdUploadDocument')]")).Click();
            Thread.Sleep(25000);
            driver.FindElement(By.XPath("//*[contains(text(),'Add Document')]")).Click();
            Thread.Sleep(14000);
            string file2 = Path.Combine(folder, "data/Testing JPEG.jpg");
            //File file2 = new File("data/Testing JPEG.jpg");
            driver.FindElement(By.XPath("//*[contains(@id,'fileToUpload')]")).SendKeys(file2);
            Thread.Sleep(4000);
            new SelectElement(driver.FindElement(By.XPath("//*[contains(@id,'ddlDocDesc')]"))).SelectByValue("DOC021");
            driver.FindElement(By.XPath("//*[contains(@id,'cmdUploadDocument')]")).Click();
            Thread.Sleep(25000);
            driver.FindElement(By.XPath("//*[contains(text(),'Add Document')]")).Click();
            Thread.Sleep(14000);
            string file3 = Path.Combine(folder, "data/Testing Excel.xlsx");
            //File file3 = new File("data/Testing Excel.xlsx");
            driver.FindElement(By.XPath("//*[contains(@id,'fileToUpload')]")).SendKeys(file3);
            Thread.Sleep(4000);
            new SelectElement(driver.FindElement(By.XPath("//*[contains(@id,'ddlDocDesc')]"))).SelectByValue("DOC040");
            driver.FindElement(By.XPath("//*[contains(@id,'cmdUploadDocument')]")).Click();
            Thread.Sleep(25000);
            driver.FindElement(By.XPath("//*[contains(text(),'Add Document')]")).Click();
            Thread.Sleep(14000);
            string file4 = Path.Combine(folder, "data/Test WordDocx.doc");
            //File file4 = new File("data/Test WordDocx.doc");
            driver.FindElement(By.XPath("//*[contains(@id,'fileToUpload')]")).SendKeys(file4);
            Thread.Sleep(4000);
            new SelectElement(driver.FindElement(By.XPath("//*[contains(@id,'ddlDocDesc')]"))).SelectByValue("DOC012");
            driver.FindElement(By.XPath("//*[contains(@id,'cmdUploadDocument')]")).Click();
            Thread.Sleep(25000);
            // ->view documents
            driver.FindElement(By.XPath("//*[contains(@id,'ctl02_cmdViewPrint')]")).Click();
            Thread.Sleep(6000);
            driver.FindElement(By.XPath("//*[contains(@id,'ctl03_cmdViewPrint')]")).Click();
            Thread.Sleep(6000);
            driver.FindElement(By.XPath("//*[contains(@id,'ctl04_cmdViewPrint')]")).Click();
            Thread.Sleep(6000);
            driver.FindElement(By.XPath("//*[contains(@id,'ctl05_cmdViewPrint')]")).Click();
            Thread.Sleep(8000);

            // ->Edit documents
            driver.FindElement(By.XPath("//*[contains(@id,'ctl02_cmdEdit')]")).Click();
            Thread.Sleep(6000);
            IWebElement editdoc1 = driver.FindElement(By.XPath("//*[contains(@id,'txtEditFileDescription')]"));
            editdoc1.Clear();
            editdoc1.SendKeys("111File-Edited");
            new SelectElement(driver.FindElement(By.XPath("//*[contains(@id,'ddlDocCatEdit')]"))).SelectByValue("DOCCATEGORY005");
            new SelectElement(driver.FindElement(By.XPath("//*[contains(@id,'ddlEditDocDesc')]"))).SelectByValue("G000000034");
            driver.FindElement(By.XPath("//*[contains(@id,'cmdSaveChanges')]")).Click();
            Thread.Sleep(8000);
            driver.FindElement(By.XPath("//*[contains(@id,'ctl03_cmdEdit')]")).Click();
            Thread.Sleep(6000);
            IWebElement editdoc2 = driver.FindElement(By.XPath("//*[contains(@id,'txtEditFileDescription')]"));
            editdoc2.Clear();
            editdoc2.SendKeys("222File-Edited");
            new SelectElement(driver.FindElement(By.XPath("//*[contains(@id,'ddlDocCatEdit')]"))).SelectByValue("DOCCATEGORY004");
            new SelectElement(driver.FindElement(By.XPath("//*[contains(@id,'ddlEditDocDesc')]"))).SelectByValue("G000000024");
            driver.FindElement(By.XPath("//*[contains(@id,'cmdSaveChanges')]")).Click();
            Thread.Sleep(8000);
            IWebElement totalprice = driver.FindElement(By.XPath("//span[contains(text(),'Total Price')]"));
            ((IJavaScriptExecutor)driver).ExecuteScript("arguments[0].scrollIntoView(true);", totalprice);
            Console.WriteLine("-->Document Upload-Method is Executed Successfully");
            Thread.Sleep(10000);
        }
        [Test, Order(5)]
        public void ACDQuicklinks() 
        {
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
			} catch (NoAlertPresentException e1)
{
    e.printStackTrace();
}
		}
		Thread.sleep(5000);
// driver.switchTo().alert().accept();
// Thread.sleep(4000);
try
{

    driver.switchTo().alert().accept();
}
catch (Exception e)
{
    try
    {
        if (e.toString().contains("org.openqa.selenium.UnhandledAlertException"))
        {
            Alert alert = driver.switchTo().alert();

            alert.accept();
        }
    }
    catch (NoAlertPresentException e1)
    {
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
((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles2);
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

((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", DisputedFiles3);
DisputedFiles3.click();
System.out.println("-->ACD_Quicklinks-Method is Executed Successfully");
Thread.sleep(9000);

	}
}
}
