package Webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepartmentName_Page extends BaseTest {
@FindBy(xpath= "//span[normalize-space()='EIM Administration']")
	
	WebElement EIMlink;
	
	@FindBy(xpath = "//a[contains(.,'Department Master')]")
	
	WebElement DeptMaster;
	
	@FindBy(xpath="//a[contains(@href, 'add')]")
	WebElement add;
	
	@FindBy(xpath="//input[contains(@id, 'dept_name')]")
	WebElement DeptName;
	
	@FindBy(xpath="//textarea[contains(@id, 'description')]")
	WebElement Des;
	
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	WebElement submit;
	
	@FindBy(xpath = "//button[contains(.,'Ok')]")
	WebElement Ok;
	
	@FindBy(xpath = "(//button[@data-placement='top'])[1]")
	WebElement delete;
	
	@FindBy(xpath = "//button[contains(.,'Cancel')]")
	WebElement cancel;
	
	@FindBy(xpath = "//button[contains(@class,'confirm')]")
	WebElement deleteagain;
	
	@FindBy(xpath = "//button[contains(.,'OK')]")
	WebElement OK;
	
	public DepartmentName_Page() {
		PageFactory.initElements(driver, this);
	}

	
	public void DepartmentData(String DepartmentName, String Description) {
		EIMlink.click();
		DeptMaster.click();
		
		add.click();
		DeptName.sendKeys(DepartmentName);
		Des.sendKeys(Description);
		Des.sendKeys();
		submit.click();
		
		Ok.click();
	}
	public void deleteDepartment() throws InterruptedException {
		Thread.sleep(3000);
		EIMlink.click();
		Thread.sleep(3000);
		DeptMaster.click();
		Thread.sleep(3000);
		delete.isEnabled();
		delete.click();
		Thread.sleep(3000);
		cancel.isEnabled();
		cancel.click();
		Thread.sleep(3000);
		delete.click();
		Thread.sleep(3000);
		deleteagain.isEnabled();
		deleteagain.click();
		OK.isEnabled();
		OK.click();
         
	}

}
