package Webpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class Dashboard_Page extends BaseTest {
	
	@FindBy(xpath = "//img[contains(@alt,'HRMS')]")
	
	WebElement logo;
	
	//@FindBy(xpath = "//*[@id=\"MainMenu\"]")
	
	List<WebElement> allelemts=driver.findElements(By.xpath("//*[@id=\"MainMenu\"]/div"));
	
	//@FindBy(xpath = "//*[@id=\"main-content\"]/div")
	
	List<WebElement> allink=driver.findElements(By.xpath("//*[@id=\"main-content\"]/div"));
	
	
	@FindBy(xpath = "//select[contains(@id,'worklocation')]")
	
	WebElement location;
	@FindBy(xpath = "//button[@id='button1']")
	WebElement click;
	
	@FindBy(xpath = "//div[contains(@id,'clock')]")
	WebElement checkout;
	
	@FindBy(xpath = "//a[contains(@class,'icon-menu')]")
	WebElement clockout;
	
	public Dashboard_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageURL() {
		return driver.getCurrentUrl();
	}
	
	
	public String validateHomePage() {
		return driver.getTitle();
	}
	
	public  boolean verifytheLogo() {
		return logo.isDisplayed();
		
	}
	public void verifAllelements() throws InterruptedException {
		Thread.sleep(5000);
		

		 System.out.println(allelemts.size());

	        for (WebElement webElement : allelemts) {
	            String name = webElement.getText();
	            System.out.println(name);
			}
		}
			
		
		
		public void verifAlLinks() throws InterruptedException {
			Thread.sleep(5000);
			System.out.println(allink.size());
			 for (WebElement webElement : allink) {
		            String name = webElement.getText();
		            System.out.println(name);
			}
		}
		public void workLocation() {
			location.click();
			
			Select ss= new Select(location);
			
			ss.selectByVisibleText("Work from Office");
			
			click.isSelected();
			click.click();
			
		
		
	}
		public void checkOut() {
			checkout.isEnabled();
			checkout.click();
			
		}
		public void clockOut() {
			clockout.isEnabled();
			clockout.click();
		}
	
	

}
