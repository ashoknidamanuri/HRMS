package Webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BranchMaster_Page extends BaseTest{
@FindBy(xpath="//span[contains(.,'EIM Administration')]")
	
	WebElement eimlink;
@FindBy(xpath = "//a[contains(.,'Branch Master')]")
	WebElement Bmaster;
@FindBy(xpath="//a[contains(@href,'add')]")
	WebElement add;
@FindBy(xpath = "//select[contains(@id,'org_id')]")
	WebElement Bsunit;
@FindBy(xpath = "//input[contains(@id,'branch_name')]")
	WebElement Bname;
@FindBy(xpath = "//select[contains(@id,'location_id')]")
	WebElement LName;
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

public BranchMaster_Page() {
	PageFactory.initElements(driver, this);
}
public String validateBranchMasterPageURL() throws InterruptedException {
	Thread.sleep(3000);
	eimlink.click();
	Thread.sleep(3000);
	Bmaster.click();

	return driver.getCurrentUrl();
}
public void BranchMasterData(String BusiUnit,String BranchName, String LocationName) throws InterruptedException {
	Thread.sleep(3000);
	eimlink.click();
	Thread.sleep(3000);
	Bmaster.click();
	Thread.sleep(3000);
	add.click();
	Thread.sleep(3000);
	Select s=new Select(Bsunit);
	s.selectByVisibleText(BusiUnit);
	Bname.sendKeys(BranchName);
	Thread.sleep(3000);
	Select ss=new Select(LName);
	ss.selectByVisibleText(LocationName);
	 Thread.sleep(10000);
		submitbutton.click();
		Thread.sleep(8000);
		Ok.click();
}
public void deleteBranch() throws InterruptedException {
	Thread.sleep(3000);
	eimlink.click();
	Thread.sleep(5000);
	Bmaster.click();
	Thread.sleep(5000);
	delete.click();
	Thread.sleep(5000);
	cancelagain.click();
	Thread.sleep(5000);
	delete.click();
	Thread.sleep(3000);
	deleteagain.click();
	Thread.sleep(8000);
	OK.click();
	
	
}
}
