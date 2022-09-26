package testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Webpages.BaseTest;
import Webpages.Dashboard_Page;
import Webpages.LoginPage;


public class Dashboard_TestPage extends BaseTest {
	public Dashboard_Page dspage;
	public LoginPage loginpage;

	Logger log = Logger.getLogger(Dashboard_TestPage.class);
	public Dashboard_TestPage() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		dspage= new Dashboard_Page(driver);
	}
	@Test(priority=1)
	public void validateHomePageURL() {
		String pageurl= driver.getCurrentUrl();
		System.out.println("Page url is"+pageurl);
		Assert.assertEquals(pageurl, "http://38.143.106.237/qahrms/dashboard");
		log.info("URL is displayed");
	}
	
	@Test(priority=2)
	public void validateHomePage() throws InterruptedException{
		Thread.sleep(5000);
		//Actual Title
		String hometitle = driver.getTitle();
		System.out.println("title is" +hometitle);
		
		//Expected Title
		String Expected_Title = "HRMS | Dashboard";
Assert.assertEquals(hometitle, Expected_Title);
log.info("Homepage title Page is"+Expected_Title);
		System.out.println("Test Completed");
	}
	@Test(priority=3)
	public void ValidateLogo() throws InterruptedException {
		Thread.sleep(5000);
		boolean bs= dspage.verifytheLogo();
		System.out.println(bs);
		Assert.assertTrue(bs);
	}
	@Test(priority=4)
	public void allelementsTest() throws InterruptedException {
		Thread.sleep(5000);
		dspage.verifAllelements();
	}
	@Test(priority=5)
	public void alllinksTest() throws InterruptedException {
		Thread.sleep(5000);
		dspage.verifAlLinks();
	}
	@Test(priority=6)
	public void workLocationTest() throws InterruptedException {
		Thread.sleep(5000);
		dspage.workLocation();
	}
	@Test(priority=7)
	public void checkOutTest() {
		
	dspage.checkOut();
		
	}
	@Test(priority=8)
	public void clockOutTest() {
		dspage.clockOut();
		
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		log.info("Browser is Closed ");
	}
}
