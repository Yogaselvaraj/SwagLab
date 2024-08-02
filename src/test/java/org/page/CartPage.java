package org.page;

import org.baseclass.GlobalBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends GlobalBase {
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Your Cart']")
	private WebElement yourCart;
	
	public WebElement getYourCart() {
		return yourCart;
	}
	
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	private WebElement backpack;
	
	public WebElement getBackpack() {
		return backpack;
	}
	
	@FindBy(xpath="//div[text()='Sauce Labs Bike Light']")
	private WebElement bikeLight;
	
	public WebElement getBikeLight() {
		return bikeLight;
	}
	
	@FindBy(xpath="//a[text()='CHECKOUT']")
	private WebElement checkout;
	
	public WebElement getCheckout() {
		return checkout;
	}
	
}
