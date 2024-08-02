package org.script;


import org.baseclass.GlobalBase;
import org.openqa.selenium.By;
import org.page.CartPage;
import org.page.CheckOutPage;
import org.page.ConfirmationPage;
import org.page.LoginPage;
import org.page.OverviewPage;
import org.page.ProductPage;
import org.openqa.selenium.WebElement;

public class Execution extends GlobalBase{

	public static void main(String[] args) {
		GlobalBase base=new GlobalBase();
		//Get Driver
		base.getDriver(base.readExcel(3, 0));
		base.windowMx();
		
		//get URL
		base.url(base.readExcel(2, 1));
		
		if(base.readExcel(2,1).equals(base.currentURL())) {
			System.out.println("Brownser launched");
			//base.writeExcel(1, 7, "Browser Launched");
		}
		else {
			System.out.println("Brownser Not launched");
			//base.writeExcel(1, 7, "Browser Not Launched");
		}
		
		//base.screenshot("LoginPAge");
		base.load();
		
		//base.writeExcel(0, 8, "LoginPage Screenshot Succeeded");
		
		LoginPage loginpage=new LoginPage();
		
		if(loginpage.getUserLoginPage().isDisplayed()) {
			System.out.println("User is in Login Page");
			//base.writeExcel(2, 7, "User is in Login Page");
		}
		else {
			System.out.println("User is Not in Login Page");
		}
		
		
		base.sendkeys(loginpage.getUserName(),base.readExcel(1, 2));
		
	
		base.sendkeys(loginpage.getPassword(), base.readExcel(1, 3));
		
		base.clickbutton(loginpage.getLogin());
		
		base.load();
		
		ProductPage productPage=new ProductPage();
		
		if(productPage.getUserProductPage().isDisplayed()) {
			System.out.println("User is in Product Page");
			//base.writeExcel(4, 7, "User is in Product Page");
		}
		else {
			System.out.println("User is not in Product Page");
		}
		
		base.load();
		//base.screenshot("ProductPage");
		//base.writeExcel(4, 8, "Product Page ScreenShot Suceeded");
		
		if(productPage.getBackpack().isDisplayed()) {
			base.clickbutton(productPage.getAddToCart());
			// productPage.getAddToCart().click();
			// base.writeExcel(5, 7, "Backpack is Added");
			 
		 }
		
		if(productPage.getBikeLight().isDisplayed()) {
			base.clickbutton(productPage.getAddToCart());
			//productPage.getAddToCart().click();
			//base.writeExcelNewRow(6, 7, "Bike Light is Added");
		}
		
		
		if(productPage.getCart().isEnabled()) {
			base.clickbutton(productPage.getCart());
		}
		
		CartPage cartpage=new CartPage();
		
		if(cartpage.getYourCart().isDisplayed()) {
			System.out.println("User is in Cart Page");
			//base.writeExcelNewRow(8, 7, "User in in Cart Page");
		}
		else {
			System.out.println("User is not in Cart Page");
		}
		
		base.load();
		//base.screenshot("CartPage");
		//base.writeExcel(8, 8, "CartPage ScreenShot Succeeded");
		
		if(cartpage.getBackpack().isDisplayed()) {
			//base.writeExcelNewRow(9, 7, "Backpack Present");
		}
		
		if(cartpage.getBikeLight().isDisplayed()) {
			//base.writeExcelNewRow(10, 7, "BikeLight Present");
		}
		
		if(cartpage.getCheckout().isEnabled()) {
			//base.writeExcelNewRow(12, 7, "CheckOut Button is enable");
			cartpage.getCheckout().click();
		}
		
		base.load();
		
		CheckOutPage checkoutpage=new CheckOutPage();
		if(checkoutpage.getUserCheckoutPage().isDisplayed()) {
			System.out.println("User is in CheckOut Page");
			//base.writeExcelNewRow(13, 7,"User is in CheckOut Page");
		}
		else {
			System.out.println("User is not in CheckOut Page");
		}
		
		//base.screenshot("CheckOutPage");
		//base.writeExcel(13, 8, "Checkout Screenshot Succeeded");
		
		checkoutpage.getFirstname().sendKeys(base.readExcel(2,4));
		
		checkoutpage.getLastname().sendKeys(base.readExcel(2, 5));
		
		checkoutpage.getPostcode().sendKeys(base.readExcel(2, 6));
		
		checkoutpage.getContinuebutton().click();
		
		OverviewPage overviewpage =new OverviewPage();
		 
		if(overviewpage.getOverview().isDisplayed()) {
			System.out.println("User is in Checkout Overview Page");
			//base.writeExcelNewRow(15, 7,"User is in Checkout Overview Page");
		}
		else {
			System.out.println("User is not in Checkout Overview PAge");
		}
		
		//base.screenshot("OverviewPage");
		//base.writeExcel(15, 8, "Overview SCreenshot Succeeded");
		
		overviewpage.getFinishButton().click();
		
		ConfirmationPage confirmpage=new ConfirmationPage();
		
		if(confirmpage.getConfirm().isDisplayed()) {
			System.out.println("User is in Confirmation Page");
			base.writeExcelNewRow(17, 7, "User is in Confirmation Page");
		}
		else {
			System.out.println("User is not in Confirmation Page");
		}
		
		base.load();
		
		if(confirmpage.getMessage().isDisplayed()) {
			System.out.println("Message is Displayed");
			//base.writeExcelNewRow(18, 7, "Message is Displayed");
		}
		else {
			System.out.println("Message is not Displayed");
		}
		
		base.load();
		//base.screenshot("ConfirmPage");
		//base.writeExcel(17, 8, "Confirmation Page screenshot suceeded");
		
		confirmpage.getBurgerButton().click();
		base.load();
		confirmpage.getLogOut().click();
		
		base.load();
		
		if(loginpage.getUserLoginPage().isDisplayed()) {
			System.out.println("User is in Login Page");
			//base.writeExcelNewRow(20, 7, "Back to Home Page");
		}
		else {
			System.out.println("User is Not in Login Page");
		}
		
		//base.screenshot("HomePage");
	    //base.writeExcel(20,8,"BackToHomePage ScreenShot Succeeded");
		
		base.closeWindow();
	}

}
