package testCases;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.TestUtil;
import Webpages.BaseTest;
import Webpages.DepartmentName_Page;
import Webpages.LoginPage;

public class DepartmentName_PageTest extends BaseTest {
	public LoginPage loginpage;
	public DepartmentName_Page deptname;
	public TestUtil testutil;
	
	Logger log = Logger.getLogger(DepartmentName_Page.class);
	public DepartmentName_PageTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Login Suceesfully");
		deptname= new DepartmentName_Page();
		

}

	@DataProvider()
	public Object[][] readexcel() throws InvalidFormatException, com.fasterxml.jackson.databind.exc.InvalidFormatException {
		String SheetName="DeptName";
		Object data[] []=TestUtil.getTestData(SheetName);
		return data;
		
	}
	@Test(dataProvider="readexcel")
	public void DepartmentData(String DepartmentName, String Description) {
		deptname.DepartmentData(DepartmentName, Description);
		log.info("Data updated Successfully");
	}
	@Test(priority = 1)
	
	public void deleteDepartmentTest() throws InterruptedException {
		deptname.deleteDepartment();
		log.info("Data deleted Successfully");
		
	}
	@AfterMethod
	public void quit() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		log.info("Browser is closed");
	}

}
