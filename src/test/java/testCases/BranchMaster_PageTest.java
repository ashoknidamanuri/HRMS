package testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import Utilities.TestUtil;
import Webpages.BaseTest;
import Webpages.BranchMaster_Page;
import Webpages.DesignationMaster_Page;
import Webpages.LoginPage;

public class BranchMaster_PageTest extends BaseTest{

	public LoginPage loginpage;
	public BranchMaster_Page bmasterPage;
	public TestUtil testUtil;
	
	Logger log = Logger.getLogger(DesignationMaster_Page.class);
	
	public BranchMaster_PageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage=new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		bmasterPage =new BranchMaster_Page();
		
	}
	@Test(priority=1)
	public void validateHomePageTestURL() throws InterruptedException {
		bmasterPage.validateBranchMasterPageURL();
		Thread.sleep(5000);
		String pageurl= driver.getCurrentUrl();
		System.out.println("Page url is"+pageurl);
		Assert.assertEquals(pageurl, "http://38.143.106.237/qahrms/eim/branches");
		log.info("URL is displayed");
	}
	

	@DataProvider()
	public Object[][] readexcel() throws InvalidFormatException, com.fasterxml.jackson.databind.exc.InvalidFormatException {
		String SheetName ="BranchMaster";
		Object data[] []=TestUtil.getTestData(SheetName);
		log.info("BranchMaster Sheet is displayed");
		return data;
		
	}
	@Test(priority =2, dataProvider="readexcel")
	public void BranchMasterData(String BusiUnit,String BranchName, String LocationName) throws InterruptedException {
		bmasterPage.BranchMasterData(BusiUnit, BranchName, LocationName);
		log.info("Branch Master data added Successfully");
	}
	@Test(priority = 3)
	public void deletebranch() throws InterruptedException {
		bmasterPage.deleteBranch();
		log.info("Branch Master data Deleted Successfully");
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		log.info("Browser Closed");
	}

}
