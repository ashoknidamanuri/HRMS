package Webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationMaster_Page extends BaseTest{
	
	@FindBy(xpath="//span[contains(.,'EIM Administration')]")
	WebElement Eimlink;
	
	@FindBy(xpath="//a[contains(.,'Organization Master')]")
	WebElement orgmaster;
	@FindBy(xpath = "//a[contains(@href,'add')]")
	WebElement add;
	@FindBy(xpath="//input[contains(@id,'company_name')]")
	WebElement cname;
	@FindBy(xpath="//input[contains(@id,'company_prefix')]")
	WebElement prefix;
	@FindBy(xpath="//input[contains(@id,'emp_start_code')]")
	WebElement empcode;
	@FindBy(xpath="//input[contains(@id,'contact_name')]")
	WebElement contname;
	@FindBy(xpath="//textarea[contains(@id,'company_address')]")
	WebElement address;
	
	@FindBy(xpath="//input[contains(@id,'pincode')]")
	WebElement code;
	@FindBy(xpath="//input[contains(@id,'company_phone')]")
	WebElement cmpphone;
	@FindBy(xpath="//input[contains(@id,'company_email')]")
	WebElement cmpemail;
	@FindBy(xpath="//input[contains(@id,'company_website')]")
	WebElement empwebsite;
	@FindBy(xpath="//input[contains(@id,'company_vat')]")
	WebElement cmpwat;
	@FindBy(xpath = "(//button[contains(@type,'reset')])[2]")
	WebElement clear;
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Add')]")
	WebElement Add;
	@FindBy(xpath = "//button[contains(.,'Ok')]")
	WebElement Okalert;

	@FindBy(xpath = "(//button[@data-placement='top'])[1]")
	WebElement delete;
	
	@FindBy(xpath = "//button[contains(.,'Cancel')]")
	WebElement cancelagain;
	
	@FindBy(xpath = "//button[contains(@class,'confirm')]")
	WebElement deleteagain;
	
	@FindBy(xpath = "//button[contains(.,'OK')]")
	WebElement OKass;
	
	public OrganizationMaster_Page() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String VlaidtetheOrgMasterURL() throws InterruptedException {
		Thread.sleep(5000);
		Eimlink.click();
		Thread.sleep(5000);
		orgmaster.click();
		return driver.getCurrentUrl();
		
	}
	
	public void Organizationdata(String companyName,String companyPerfix, String Employeecode,String contactname,String companyAdress,String pincode, 
			String companyphone, String companyemail,String companywebsite,String companyvat) throws InterruptedException {
		Thread.sleep(5000);
		Eimlink.click();
		Thread.sleep(5000);
		orgmaster.click();
		Thread.sleep(5000);
		add.click();
		Thread.sleep(5000);
		cname.sendKeys(companyName);
		prefix.sendKeys(companyPerfix);
		empcode.sendKeys(Employeecode);
		contname.sendKeys(contactname);
		address.sendKeys(companyAdress);
		code.sendKeys(pincode);
		Thread.sleep(5000);
		cmpphone.sendKeys(companyphone);
		cmpemail.sendKeys(companyemail);
		empwebsite.sendKeys(companywebsite);
		cmpwat.sendKeys(companyvat);
		Thread.sleep(10000);
		Add.click();
		Thread.sleep(10000);
		Okalert.click();
		
		
	}
	
	
	public void deleteOrgMaster() throws InterruptedException {
		Eimlink.click();
		Thread.sleep(5000);
		orgmaster.click();
		Thread.sleep(5000);
		delete.click();
		Thread.sleep(5000);
		cancelagain.click();
		Thread.sleep(5000);
		delete.click();
		Thread.sleep(5000);
		deleteagain.click();
		Thread.sleep(5000);
		OKass.click();
	}
	
	
	
	

}
