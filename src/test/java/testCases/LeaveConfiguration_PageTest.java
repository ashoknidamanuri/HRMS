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
import Webpages.LeaveConfiguration_Page;
import Webpages.LoginPage;

public class LeaveConfiguration_PageTest extends BaseTest{
	public LoginPage loginpage;
	public LeaveConfiguration_Page leaveconfigpage;
	public TestUtil testUtil;
	
	Logger log= Logger.getLogger(LeaveConfiguration_Page.class);
	
	public LeaveConfiguration_PageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUP() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		leaveconfigpage = new LeaveConfiguration_Page();
		
	}
	@Test(priority=1)
	public void validateLeaveconfigpageURL() throws InterruptedException {
		leaveconfigpage.validateLeavecongigURL();
		Thread.sleep(5000);
		String pageurl= driver.getCurrentUrl();
		System.out.println("page url is :" +pageurl);
		Assert.assertEquals(pageurl, "http://38.143.106.237/qahrms/leave/Leaveconfigurations");
		log.info("URL is Matched");
		
	}
	@DataProvider()
	public Object[][] readexcel() throws InvalidFormatException, com.fasterxml.jackson.databind.exc.InvalidFormatException {
		String SheetName="LeaveConfiguration";
		Object data [][]=TestUtil.getTestData(SheetName);
		return data;
		
	}
	@Test(priority =2, dataProvider="readexcel")
	public void leaveConfigurationdata(String Bunit, String WEEK, String WeekEND) throws InterruptedException {
		leaveconfigpage.leaveConfigurationdata(Bunit, WEEK, WeekEND);
		
		log.info("LeaveConfiguration Data Added Successfully");
	}
	@Test(priority = 3)
	public void deletebranch() throws InterruptedException {
		leaveconfigpage.deleteLeaveConfig();
		log.info("LeaveConfiguration data Deleted Successfully");
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		log.info("Browser Closed");
	}


}
