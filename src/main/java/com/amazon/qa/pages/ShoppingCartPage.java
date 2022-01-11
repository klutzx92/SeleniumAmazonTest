package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class ShoppingCartPage extends TestBase{
	
	@FindBy(xpath = "//div[@class='a-row a-spacing-mini sc-subtotal sc-subtotal-activecart sc-java-remote-feature']//child::span[@id='sc-subtotal-label-activecart']")
	WebElement subTotal;
	
	@FindBy(xpath = "//a[@class='a-link-normal sc-product-link']//child::span//child::span//child::span[2]")
	WebElement itemInCartTitle;
	
	@FindBy(id = "quantity")
	WebElement quantityDropDown;
	
	@FindBy(xpath = "//input[@class='a-color-link' and @type='submit' and @value='Delete']")
	WebElement deleteLink;
	
	public ShoppingCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getShoppingCartPageTitle() {
		return driver.getTitle();
	}
	
	public int getNumberOfItems() {
		return Integer.parseInt(subTotal.getText().substring(10, 11));
	}
	
	public String getItemTitle() {
		return itemInCartTitle.getText();
	}
	
	public void deleteItem() {
		deleteLink.click();
	}
}
