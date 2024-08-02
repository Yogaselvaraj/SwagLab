package org.page;

import org.baseclass.GlobalBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends GlobalBase {
	public ConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Finish']")
	private WebElement confirm;
	
	public WebElement getConfirm() {
		return confirm;
	}
	
	@FindBy(xpath="//h2[text()='THANK YOU FOR YOUR ORDER']")
	private WebElement message;
	
	public WebElement getMessage() {
		return message;
	}
	
	@FindBy(xpath="//button[text()='Open Menu']")
	private WebElement burgerButton;
	
	public WebElement getBurgerButton() {
		return burgerButton;
	}
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logOut;
	
	public WebElement getLogOut() {
		return logOut;
	}
}
