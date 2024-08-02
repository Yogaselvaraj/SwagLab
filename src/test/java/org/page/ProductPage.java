package org.page;

import org.baseclass.GlobalBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends GlobalBase{
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Products']")
	private WebElement userProductPage;
	
	public WebElement getUserProductPage() {
		return userProductPage;
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
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	private WebElement addToCart;
	
	public WebElement getAddToCart() {
		return addToCart;
	}

	
	@FindBy(xpath="//span[@class='fa-layers-counter shopping_cart_badge']")
	private WebElement cart;
	
	public WebElement getCart() {
		return cart;
	}
	
	
	
}
