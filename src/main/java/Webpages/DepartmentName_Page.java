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
	
	
	public DepartmentName_Page() {
		PageFactory.initElements(driver, this);
	}

	
	public void DepartmentData(String DepartmentName, String Description) {
		EIMlink.click();
		DeptMaster.click();
		
		add.click();
		DeptName.sendKeys(DepartmentName);
		Des.sendKeys(Description);
		submit.click();
		
		Ok.click();
	}

}
