package testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Webpages.BaseTest;

import Webpages.LoginPage;

public class LoginTest extends BaseTest {

	public LoginPage loginpage;

	//What is log? : capturing info/activities at the time of program execution. 
		// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
		//where to create: create inside resources folder
	Logger log = Logger.getLogger(LoginTest.class);
	
	public  LoginTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		log.info("Launching Browser URL");
	}
	
	@Test(priority=1)
	public void ValidateURL() {
		String URL= driver.getCurrentUrl();
		System.out.println("url is"+URL);
		
		Assert.assertEquals(URL, "http://38.143.106.237/qahrms/login");
		log.info("URL is displayed");
	}

	@Test(priority=2)
	public void loginPageTitleTest(){
		
		//Actual Title
		String logintitle = driver.getTitle();
		System.out.println("title is" +logintitle);
		
		//Expected Title
		String Expected_Title = "HRMS | Login";
Assert.assertEquals(logintitle, Expected_Title);
log.info("Login title Page is"+Expected_Title);
		System.out.println("Test Completed");
	}
	
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException{
		
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Username and Password is ");
		Thread.sleep(5000);
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("Browser is Closed ");
	}
	
	
	
	
			
	}





