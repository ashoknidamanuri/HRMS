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
import Webpages.LocationMaster_Page;
import Webpages.LoginPage;


public class LocationMaster_PageTest extends BaseTest {
	
	public LoginPage loginpage;
	public LocationMaster_Page locmasterpage;
	public TestUtil testUtil;
	
	Logger log = Logger.getLogger(LocationMaster_Page.class);
	
	public LocationMaster_PageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
	initialization();
		loginpage=new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		locmasterpage =new LocationMaster_Page();
		
	}
	@Test(priority=1)
	public void ValidatethelocationMasterURL() throws InterruptedException {
		locmasterpage.VlidateLmasterUrl();
		Thread.sleep(5000);
		String pageurl= driver.getCurrentUrl();
		System.out.println("Page url is"+pageurl);
		Assert.assertEquals(pageurl, "http://38.143.106.237/qahrms/eim/locations");
		log.info("URL is displayed");
		
	}
	@DataProvider()
	public Object[][] readexcel() throws InvalidFormatException, com.fasterxml.jackson.databind.exc.InvalidFormatException {
		String SheetName ="LacationMaster";
		Object data[] []=TestUtil.getTestData(SheetName);
		return data;
		
	}
	@Test(priority =2, dataProvider="readexcel")
	public void LocationMasterData(String Lname, String StreetNum, String Pincode) throws InterruptedException {
		locmasterpage.LocationMasterData(Lname, StreetNum, Pincode);
		log.info(" Location Master Data Added Successfully");
	}
	@Test(priority = 3)
	public void DeleteOrgMaster() throws InterruptedException {
		Thread.sleep(5000);
		locmasterpage.deleteLacationMaster();
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
