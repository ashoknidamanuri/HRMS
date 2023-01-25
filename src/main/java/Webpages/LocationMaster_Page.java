package Webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocationMaster_Page extends BaseTest{
@FindBy(xpath="//span[contains(.,'EIM Administration')]")
	
	WebElement eimlink;
@FindBy(xpath = "//a[contains(.,'Location Master')]")

WebElement location;

@FindBy(xpath = "//a[contains(@href,'add')]")
WebElement add;

@FindBy(xpath = "//input[contains(@id,'location_name')]")
WebElement locationame;

@FindBy(xpath = "//textarea[contains(@id,'street_no')]")
WebElement streetno;
@FindBy(xpath = "//input[contains(@name,'pincode')]")
WebElement pincode;
@FindBy(xpath = "//button[@type='reset'][contains(.,'Clear')]")
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

public LocationMaster_Page() {
	PageFactory.initElements(driver, this);
}

public String VlidateLmasterUrl() throws InterruptedException {
	Thread.sleep(5000);
	eimlink.click();
	Thread.sleep(5000);
	location.click();
	return driver.getCurrentUrl();
}

public void LocationMasterData(String Lname, String StreetNum, String Pincode) throws InterruptedException {
	Thread.sleep(5000);
	eimlink.click();
	Thread.sleep(5000);
	location.click();
	Thread.sleep(5000);
	add.click();
	Thread.sleep(5000);
	locationame.sendKeys(Lname);
	Thread.sleep(2000);
	streetno.sendKeys(StreetNum);
	Thread.sleep(2000);
	streetno.clear();
	pincode.sendKeys(Pincode);
	Thread.sleep(2000);
	streetno.sendKeys(StreetNum);
	Thread.sleep(15000);
	Add.click();
	Thread.sleep(10000);
	Okalert.click();
}
public void deleteLacationMaster() throws InterruptedException {
	eimlink.click();
	Thread.sleep(5000);
	location.click();
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

