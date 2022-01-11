package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;

	@FindBy(id = "nav-search-submit-button")
	WebElement searchSubmitBtn;

	@FindBy(id = "nav-cart")
	WebElement shoppingCartLink;

	// Initializing the Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public SearchPage searchFor(String product) {
		searchBox.sendKeys(product);
		searchSubmitBtn.click();
		return new SearchPage();
	}
}
