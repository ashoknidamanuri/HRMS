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
import Webpages.OrganizationMaster_Page;

public class OrganizationMaster_PageTest extends BaseTest {
	
	public LoginPage loginpage;
	public OrganizationMaster_Page Orgmasterpage;
	public TestUtil testUtil;
	

	Logger log = Logger.getLogger(OrganizationMaster_Page.class);
	
	public OrganizationMaster_PageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
	initialization();
		loginpage=new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Orgmasterpage =new OrganizationMaster_Page();
		
	}
	@Test(priority=1)
	public void ValidatetheOrgnanizationMasterURL() throws InterruptedException {
		Orgmasterpage.VlaidtetheOrgMasterURL();
		Thread.sleep(5000);
		String pageurl= driver.getCurrentUrl();
		System.out.println("Page url is"+pageurl);
		Assert.assertEquals(pageurl, "http://38.143.106.237/qahrms/eim/Organizations");
		log.info("URL is displayed");
		
	}
	@DataProvider()
	public Object[][] readexcel() throws InvalidFormatException, com.fasterxml.jackson.databind.exc.InvalidFormatException {
		String SheetName ="OrganizationName";
		Object data[] []=TestUtil.getTestData(SheetName);
		return data;
		
	}
	@Test(priority =2, dataProvider="readexcel")
	public void OrganizationMasterdata(String companyName,String companyPerfix, String Employeecode,String contactname,String companyAdress,String pincode, 
			String companyphone, String companyemail,String companywebsite,String companyvat) throws InterruptedException {
		
		Orgmasterpage.Organizationdata(companyName, companyPerfix, Employeecode, contactname, companyAdress, pincode, companyphone, companyemail, companywebsite, companyvat);
	
		
		log.info("OrgMaster Data updated Successfully");
	}
	@Test(priority = 3)
	public void DeleteOrgMaster() throws InterruptedException {
		Thread.sleep(5000);
		Orgmasterpage.deleteOrgMaster();
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
