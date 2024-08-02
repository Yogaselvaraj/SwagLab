package org.page;

import org.baseclass.GlobalBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends GlobalBase {
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Checkout: Your Information']")
	private WebElement userCheckoutPage;
	
	public WebElement getUserCheckoutPage() {
		return userCheckoutPage;
	}
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	private WebElement firstname;
	
	public WebElement getFirstname() {
		return firstname;
	}
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	private WebElement lastname;
	
	public WebElement getLastname() {
		return lastname;
	}
	
	@FindBy(xpath="//input[@placeholder='Zip/Postal Code']")
	private WebElement postcode;
	
	public WebElement getPostcode() {
		return postcode;
	}
	
	@FindBy(xpath="//input[@value='CONTINUE']")
	private WebElement continuebutton;
	
	public WebElement getContinuebutton() {
		return continuebutton;
	}
	
}
