package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.TestUtil;

public class SearchPage extends TestBase{
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public String getSearchPageTitle() {
		return driver.getTitle();
	}
	
	public ProductPage clickOnProduct(String product) {
		WebElement productLink = driver.findElement(By.linkText(product));
		TestUtil.scrollIntoView(productLink, driver);
		productLink.click();
		return new ProductPage();
	}
}
