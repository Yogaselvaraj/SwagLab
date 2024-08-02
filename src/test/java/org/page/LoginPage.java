package org.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.baseclass.GlobalBase;

public class LoginPage extends GlobalBase {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='user-name']")
	private WebElement username;
	
	public WebElement getUserName() {
		return username;
	}
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	public WebElement getPassword() {
		return password;
	}
	
	@FindBy(xpath="//input[@id='login-button']")
	private WebElement login;
	
	public WebElement getLogin() {
		return login;
	}
	
	@FindBy(xpath="//h4[text()='Accepted usernames are:']")
	private WebElement userLoginPage;
	
	public WebElement getUserLoginPage() {
		return userLoginPage;
	}
}
