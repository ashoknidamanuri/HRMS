package Webpages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Utilities.TestUtil;
import Utilities.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;
	
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public BaseTest(){
		try{
			prop=new Properties();
			FileInputStream fis = new FileInputStream("D:\\Automation Scripts\\HRMSINDIA\\src\\main\\java\\configproperties\\config.properties");
			prop.load(fis);
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			
			WebDriverManager.chromedriver().setup();	
			driver = new ChromeDriver();
		  
		}
		else if(browserName.equals("FF")){
		System.setProperty("webdriver.gecko.driver", "‪C://Users//Ashok Nidamanuri//Downloads//geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equals("IE")){
			System.setProperty("webdriver.ie.driver", "‪‪E:\\office\\msedgedriver.exe");	
				driver = new InternetExplorerDriver(); 
			}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		

		
		driver.get(prop.getProperty("url"));
		
	}

}
