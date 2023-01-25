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
import Webpages.DesignationMaster_Page;
import Webpages.LoginPage;

public class DesignationMaster_PageTest extends BaseTest{
	
	public LoginPage loginpage;
	public DesignationMaster_Page designationPage;
	public TestUtil testUtil;
	
	Logger log = Logger.getLogger(DesignationMaster_Page.class);
	public DesignationMaster_PageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage=new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		designationPage =new DesignationMaster_Page();
		
	}
	@Test(priority=1)
	public void validateHomePageTestURL() throws InterruptedException {
		designationPage.validateHomePageURL();
		Thread.sleep(5000);
		String pageurl= driver.getCurrentUrl();
		System.out.println("Page url is"+pageurl);
		Assert.assertEquals(pageurl, "http://38.143.106.237/qahrms/eim/designations");
		log.info("URL is displayed");
	}
	

	@DataProvider()
	public Object[][] readexcel() throws InvalidFormatException, com.fasterxml.jackson.databind.exc.InvalidFormatException {
		String SheetName ="DesignationName";
		Object data[] []=TestUtil.getTestData(SheetName);
		log.info("URL is displayed");
		return data;
		
	}
	@Test(priority =2, dataProvider="readexcel")
	public void DesignationMasterDataTest(String desCode,String desiName, String DeptName) throws InterruptedException {
		designationPage.DesignationMasterData(desCode, desiName, DeptName);
		log.info("Data updated Successfully");
	}
	@Test(priority = 3)
	public void deleteDesignation() throws InterruptedException {
		designationPage.deleteDesignation();
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
	
}
