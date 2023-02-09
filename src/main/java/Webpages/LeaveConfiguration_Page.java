package Webpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LeaveConfiguration_Page extends BaseTest{
	
	@FindBy(xpath = "//span[contains(.,'Leave Management')]")
	WebElement leamag;
	@FindBy(xpath = "//a[contains(.,'Leave Configuration')]")
	
	WebElement Lconfiguration;
	@FindBy(xpath = "//a[contains(@href,'add')]")
	WebElement add;
	@FindBy(xpath = "//select[contains(@id,'branch_id')]")
	WebElement bunit;
	@FindBy(xpath = "//input[contains(@id,'start_month')]")
	WebElement sartmonth;
	@FindBy(xpath = "(//th[@class='prev'][contains(.,'«')])[1]")
	WebElement prev;
	@FindBy(xpath = "(//td[@class='day'][contains(.,'8')])[1]")
	WebElement stdtclick;
	@FindBy(xpath = "//input[contains(@id,'end_month')]")
	WebElement endmonth;
	@FindBy(xpath = "//th[contains(.,'January 2023')]")
	WebElement calclcik;
	@FindBy(xpath = "(//span[contains(@class,'month')])[12]")
	WebElement next;
	@FindBy(xpath = "/html/body/div[3]/div[1]/table/tbody/tr[2]/td[4] ")
	WebElement enddate;
	@FindBy(xpath = "//select[contains(@id,'weekend_1')]")
	WebElement week;
	@FindBy(xpath = "//select[contains(@id,'weekend_2')]")
	WebElement weekend;
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Add')]")
	WebElement Add;
	@FindBy(xpath = "//h2[contains(.,'Added Successfully')]")
	WebElement text;
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

public LeaveConfiguration_Page() {
	PageFactory.initElements(driver, this);
}
public String validateLeavecongigURL() throws InterruptedException {
	leamag.click();
	Thread.sleep(5000);
	Lconfiguration.click();
	return driver.getCurrentUrl();
	
}
public void leaveConfigurationdata(String Bunit, String WEEK, String WeekEND) throws InterruptedException {
	leamag.click();
	Thread.sleep(10000);
	Lconfiguration.click();
	Thread.sleep(10000);
	add.click();
	Thread.sleep(10000);
	Select bs=new Select(bunit);
	bs.selectByVisibleText(Bunit);
	Thread.sleep(10000);
	sartmonth.click();
	Thread.sleep(10000);
	prev.click();
	Thread.sleep(10000);
	stdtclick.click();
	Thread.sleep(10000);
	endmonth.click();
	Thread.sleep(10000);
	calclcik.click();
	Thread.sleep(10000);
	next.click();
	
	
	Thread.sleep(5000);
	enddate.click();
	Thread.sleep(3000);
	Select wkend=new Select(week);
	wkend.selectByVisibleText(WEEK);
	Thread.sleep(5000);
	Select wend=new Select(weekend);
	wend.selectByVisibleText(WeekEND);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Add.click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	String msg=text.getText();

	Assert.assertEquals(text,"Added Successfully");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	Ok.click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
public void deleteLeaveConfig() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	leamag.click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Lconfiguration.click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	delete.click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	cancelagain.click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	delete.click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	deleteagain.click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	OK.click();
}
	
	

}
