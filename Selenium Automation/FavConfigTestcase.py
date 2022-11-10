import FavConfigTestcase
from HtmlTestRunner.runner import HTMLTestRunner
import unittest
from unittest.main import MODULE_EXAMPLES
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import Select
from selenium.webdriver.edge.options import Options as EdgeOptions
from selenium.common import exceptions
import time
from time import sleep


class Automation(unittest.TestCase):
    def wait(self):
            time.sleep(3)
    def pageloader(self): 
        WebDriverWait(self.driver, 3600).until(EC.invisibility_of_element_located((By.XPATH, '//*[contains(@id,"progressbar_disc")]')))
        self.wait()
        WebDriverWait(self.driver, 3600).until(EC.invisibility_of_element_located((By.XPATH, '//*[contains(@id,"pageloader")]')))
        #print('pageloader func executed')
    def bulkaddbtnwait(self):
            self.pageloader()
            WebDriverWait(self.driver, 3600).until(EC.visibility_of_element_located((By.XPATH, '//button[@id="bulkaddprd"]')))
    def addproductwait(self):
            self.pageloader()
            WebDriverWait(self.driver,60000).until(EC.element_to_be_clickable((By.XPATH, '//*[@id="addproducts"]')))

    @classmethod
    def setUpClass(inst):
        inst.username = "saitejareddy"
        inst.password = "Sai@8994"
        inst.domain = "agilenttechnologiesinc_tst1"
        edge_options = EdgeOptions()
        edge_options.add_argument("start-maximized")
        inst.driver = webdriver.Edge(options=edge_options, executable_path=r".\\msedgedriver.exe")
        inst.driver.get("https://rssandbox.webcomcpq.com/login.aspx")
        

    def test_001_login(self):
        self.driver.find_element(By.ID,"ctl00_MainContentPlaceHolder_txtUsername").send_keys(self.username)
        self.driver.find_element(By.ID,"ctl00_MainContentPlaceHolder_txtPassword").send_keys(self.password)
        self.driver.find_element(By.ID,"ctl00_MainContentPlaceHolder_txtDomainName").send_keys(self.domain)
        self.driver.find_element(By.ID,"ctl00_MainContentPlaceHolder_btnLogin").click()

        WebDriverWait(self.driver,3600).until(EC.presence_of_element_located((By.XPATH, '//*[@id="filllevel_container"]')))

        self.pageloader()
        allquotes = self.driver.find_element(By.XPATH,'//*[@id="fillallquote1"]/a')
        #print("Element is visible? " + str(allquotes.is_displayed()))
        ActionChains(self.driver).move_to_element(allquotes).click(allquotes).perform()
        self.pageloader()
        allquotesearch = self.driver.execute_script('return document.querySelector("#qterevall > div.search_button input")')
        self.driver.execute_script("arguments[0].click();", allquotesearch)
        self.driver.execute_script('return document.querySelector("#qterevall > div.search_button input").value = "05985096" ')
        #print('entered')
        
        allsearch = self.driver.find_element(By.XPATH,'//*[@id="Quote_tableall"]/thead/tr/th[1]/div[2]/button').click()
        self.pageloader()
        self.wait()
        WebDriverWait(self.driver,3600).until(EC.visibility_of_element_located((By.XPATH, '//*[@id="fillallquote1"]/a')))
        quoteclick = self.driver.find_element(By.XPATH,'/html/body/div[5]/div[1]/div[6]/div[2]/div[1]/div/div/div[2]/div/div[1]/table/tbody/tr/td[2]/a')
        self.driver.execute_script("arguments[0].click();", quoteclick)
        self.addproductwait()

        
    def test_002_addincompleteProd(self):    
        
        driver=self.driver

        def pageloader(): 
            WebDriverWait(driver, 3600).until(EC.invisibility_of_element_located((By.XPATH, '//*[contains(@id,"progressbar_disc")]')))
            self.wait()
            WebDriverWait(driver, 3600).until(EC.invisibility_of_element_located((By.XPATH, '//*[contains(@id,"pageloader")]')))
        #-->Adding first incomplete product
        addproduct = driver.find_element(By.XPATH,'//*[@id="addproducts"]')
        driver.execute_script('arguments[0].click()', addproduct)
        pageloader()

        favorites = driver.find_element(By.XPATH,'//*[@id="catExp_myTree"]/ul/li[1]').click()
        WebDriverWait(driver,60000).until(EC.element_to_be_clickable((By.XPATH, '//a[contains(text(),"G4513A")]')))
        
        partnoclick1 = driver.find_element(By.XPATH,'//a[contains(text(),"G4513A")]').click()
        pageloader()
        saveprod1 = driver.find_element(By.XPATH,'//*[@id="cat_configure_save"]').click()
        pageloader()
        #-->Adding second incomplete product
        addproduct = driver.find_element(By.XPATH,'//*[@id="addproducts"]')
        driver.execute_script('arguments[0].click()', addproduct)
        pageloader()

        favorites2 = driver.find_element(By.XPATH,'//*[@id="catExp_myTree"]/ul/li[1]').click()
        WebDriverWait(driver,60000).until(EC.element_to_be_clickable((By.XPATH, '//a[contains(text(),"G4513A")]')))
        
        partnoclick2 = driver.find_element(By.XPATH,'//a[contains(text(),"G4514A")]').click()
        pageloader()
        saveprod2 = driver.find_element(By.XPATH,'//*[@id="cat_configure_save"]').click()
        pageloader()
        

    def test_003_addCompleteProd(self):
        driver=self.driver
        def pageloader(): 
            WebDriverWait(self.driver, 3600).until(EC.invisibility_of_element_located((By.XPATH, '//*[contains(@id,"progressbar_disc")]')))
            self.wait()
            WebDriverWait(self.driver, 3600).until(EC.invisibility_of_element_located((By.XPATH, '//*[contains(@id,"pageloader")]')))
        def wait():
            time.sleep(3)
        
        WebDriverWait(driver, 3600).until(EC.element_to_be_clickable((By.XPATH, '(//span[contains(text(),"G4513A")])[1]')))
        config_prd = driver.find_element(By.XPATH,'(//span[contains(text(),"G4513A")])[1]').click()
        wait()
        pageloader() 
        attribdropdown =  Select(driver.find_element(By.XPATH,'(//select[@class="cart-transInfo-select-width form-yellow-bg"])[3]'))
        wait()
        attribdropdown.select_by_visible_text('YES - Yes Selected')
        pageloader()
        save2 = driver.find_element(By.XPATH,'//*[@id="cat_configure_save"]').click()
        pageloader()

        #-->Complete product is again replicated with diiferent Partno's

        WebDriverWait(driver, 3600).until(EC.element_to_be_clickable((By.XPATH, '(//span[contains(text(),"G4514A")])[2]')))
        config_prd2 = driver.find_element(By.XPATH,'(//span[contains(text(),"G4514A")])[2]').click()
        wait()
        pageloader() 
        attribdropdown2 =  Select(driver.find_element(By.XPATH,'(//select[@class="cart-transInfo-select-width form-yellow-bg"])[3]'))
        wait()
        attribdropdown2.select_by_visible_text('YES - Yes Selected')
        pageloader()
        save3 = driver.find_element(By.XPATH,'//*[@id="cat_configure_save"]').click()
        pageloader()
        
    def test_004_SavingProdFromFav(self):
        driver=self.driver
        addproduct3 = driver.find_element(By.XPATH,'//*[@id="addproducts"]')
        driver.execute_script('arguments[0].click()', addproduct3)
        self.pageloader()
        WebDriverWait(driver, 3600).until(EC.element_to_be_clickable((By.XPATH, '//input[@id="PART"]')))
        #addproduct.click()
        prdsearch3 = driver.find_element(By.XPATH,'//input[@id="PART"]')
        driver.execute_script("arguments[0].click();", prdsearch3)
        partno3 = "G4513A"
        self.wait()
        configprdsearch = driver.find_element(By.XPATH,'//input[@id="PART"]').send_keys(partno3)
        self.wait()
        partnosearch3 = driver.find_element(By.XPATH,'//*[@id="TH_ACTIONS"]/div[2]/button').click()
        self.pageloader()
        WebDriverWait(driver, 3600).until(EC.element_to_be_clickable((By.XPATH, '//td[@id="TD_PartNumber"]//a[1]')))
        config_prd3 = driver.find_element(By.XPATH,'//a[contains(text(),"G4513A")]').click()
        self.wait()
        self.pageloader() 
        attribdropdown3 =  Select(driver.find_element(By.XPATH,'(//select[@class="cart-transInfo-select-width form-yellow-bg"])[3]'))
        self.wait()
        attribdropdown3.select_by_visible_text('YES - Yes Selected')
        self.pageloader()
        Starbtnclick = driver.find_element(By.XPATH,'//*[contains(@src, "/mt/AGILENTTECHNOLOGIESINC_TST1/Additionalfiles/star_selected.svg")]').click()
        time.sleep(2)
        FavName = driver.find_element(By.XPATH,'//*[@id="configfavName"]')
        FavName.click()
        FavName.send_keys("-AUTOTEST")
        SaveFav = driver.find_element(By.XPATH,'//*[@id="configfavmoddialog"]/div/div[3]/button[2]').click()
        self.pageloader()
        Cancel = driver.find_element(By.XPATH,'//button[@id="cat_configure_cancel"]').click()
        self.pageloader()

        addproduct4 = driver.find_element(By.XPATH,'//*[@id="addproducts"]')
        driver.execute_script('arguments[0].click()', addproduct4)
        self.pageloader()

        favorites = driver.find_element(By.XPATH,'//*[@id="catExp_myTree"]/ul/li[1]').click()
        WebDriverWait(self.driver,60000).until(EC.element_to_be_clickable((By.XPATH, '//a[contains(text(),"G4513A")]')))
        
        partnoclick3 = driver.find_element(By.XPATH,'//a[contains(text(),"G4513A")]').click()
        self.pageloader()
        saveprod1 = driver.find_element(By.XPATH,'//*[@id="cat_configure_save"]').click()
        self.pageloader()
        time.sleep(5)
        BacktoList = driver.find_element(By.XPATH,'//a[contains(text(),"BACK TO LIST")]').click()
        self.pageloader()
        

'''if __name__ == '__main__':
    unittest.main(testRunner=HtmlTestRunner.HTMLTestRunner(output='Test Report2',report_title = 'Test Results',report_name = 'Test Report',open_in_browser=True))'''
 #from tests.test_1 import TestCase1
#from tests.test_2 import TestCase2


if __name__ == '__main__':
   
    test1 = unittest.TestLoader().loadTestsFromTestCase(FavConfigTestcase.Automation)
    #test2 = unittest.TestLoader().loadTestsFromTestCase(TestCase2)
    suite = unittest.TestSuite([test1])
    runner = HTMLTestRunner(output='Test Reports',report_title = 'Automation Test Results',report_name = 'Test Report',open_in_browser=True)
    runner.run(suite)