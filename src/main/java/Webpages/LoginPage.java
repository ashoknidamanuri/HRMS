package Webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {
	@FindBy(xpath = "//input[contains(@type,'email')]")
	WebElement user;
	
	@FindBy(xpath = "//input[contains(@name,'password')]")
	WebElement pass;
	
	@FindBy(xpath = "//input[contains(@name,'submit')]")
	WebElement submit;

	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	public String  validatetheURL() {
		return driver.getCurrentUrl();
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public  void login(String un, String pwd) throws InterruptedException{
		Thread.sleep(1000);
		
		user.sendKeys(un);
		Thread.sleep(1000);
		pass.sendKeys(pwd);
		Thread.sleep(1000);
	    submit.isDisplayed();
		submit.click();
		
		
		
	}


}
