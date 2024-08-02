package org.page;

import org.baseclass.GlobalBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends GlobalBase {
	public OverviewPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Checkout: Overview']")
	private WebElement overview;
	
	public WebElement getOverview() {
		return overview;
	}
	
	@FindBy(xpath="//a[text()='FINISH']")
	private WebElement finishButton;
	
	public WebElement getFinishButton() {
		return finishButton;
	}

}
