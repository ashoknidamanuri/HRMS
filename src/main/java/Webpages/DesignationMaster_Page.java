package Webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DesignationMaster_Page extends BaseTest {
	
	@FindBy(xpath="//span[contains(.,'EIM Administration')]")
	
	WebElement eimlink;
	
	@FindBy(xpath= "//a[contains(.,'Designation Master')]")
	WebElement dgmaster;
	
	@FindBy(xpath="//a[contains(@href,'add')]")
	WebElement add;
	@FindBy(xpath="//input[contains(@id,'designation_code')]")
	WebElement desicode;
	@FindBy(xpath="//input[contains(@id,'designation_name')]")
	WebElement desName;
	@FindBy(xpath = "//select[contains(@id,'dept_id')]")
    WebElement deptName;
	
	@FindBy(xpath="//button[contains(@id,'reset-validation')]")
	WebElement cancel;
	@FindBy(xpath="//button[contains(.,'Add')]")
	WebElement submitbutton;
	@FindBy(xpath = "//button[contains(.,'Ok')]")
	WebElement Ok;

	@FindBy(xpath = "(//button[@data-placement='top'])[1]")
	WebElement delete;
	
	@FindBy(xpath = "//button[contains(.,'Cancel')]")
	WebElement cancelagain;
	
	@FindBy(xpath = "//button[contains(@class,'confirm')]")
	WebElement deleteagain;
	
	@FindBy(xpath = "//button[contains(.,'OK')]")
	WebElement OK;
	
	public DesignationMaster_Page() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateHomePageURL() throws InterruptedException {
		Thread.sleep(3000);
		eimlink.click();
		Thread.sleep(3000);
		dgmaster.click();
		return driver.getCurrentUrl();
	}
	
	public void DesignationMasterData(String desCode,String desiName, String DeptName) throws InterruptedException {
		Thread.sleep(3000);
		eimlink.click();
		Thread.sleep(3000);
		dgmaster.click();
		Thread.sleep(3000);
		add.click();
		Thread.sleep(3000);
		desicode.sendKeys(desCode);
		Thread.sleep(3000);
		desName.sendKeys(desiName);
		
		Select s=new Select(deptName);
		s.selectByVisibleText(DeptName);
		Thread.sleep(3000);
		cancel.click();
		Thread.sleep(3000);
		add.click();
		Thread.sleep(3000);
		 desicode.sendKeys(desCode); 
		
		 Thread.sleep(3000);
		 desName.sendKeys(desiName);
		 
		 Select ss=new Select(deptName); 
		 ss.selectByVisibleText(DeptName);
		 Thread.sleep(3000);
		submitbutton.click();
		Thread.sleep(3000);
		Ok.click();
		
	}
	public void deleteDesignation() throws InterruptedException {
		Thread.sleep(3000);
		eimlink.click();
		Thread.sleep(3000);
		dgmaster.click();
		Thread.sleep(3000);
		delete.click();
		Thread.sleep(3000);
		cancelagain.click();
		Thread.sleep(3000);
		delete.click();
		Thread.sleep(3000);
		deleteagain.click();
		Thread.sleep(3000);
		OK.click();
		
		
	}
}
