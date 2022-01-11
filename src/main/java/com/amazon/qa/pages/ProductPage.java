package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.TestUtil;

public class ProductPage extends TestBase {

	@FindBy(id = "productTitle")
	WebElement productTitle;
	
	@FindBy(xpath = "//td[text()='Price:']//following-sibling::td//child::span[@class='a-price a-text-price a-size-medium apexPriceToPay']//child::span[2]")
	WebElement price;
	
	@FindBy(xpath = "//div[@id='availability']//span")
	WebElement availability;
	
	@FindBy(xpath = "//td[@class='a-span3']//child::span[contains(text(), 'Brand')]//parent::td//following-sibling::td//child::span")
	WebElement brand;
	
	@FindBy(xpath = "//div[@id='feature-bullets']//child::ul//child::li//child::span[@class='a-list-item']")
	WebElement description;
	
	@FindBy(id = "quantity")
	WebElement quantityDropDown;
	
	@FindBy(id = "add-to-cart-button")
	WebElement addToCartBtn;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	public String getProductPageTitle() {
		return driver.getTitle();
	}
	
	public String getProductName() {
		return productTitle.getText();
	}
	
	public String getPrice() {
		System.out.println(price.getText());
		return price.getText();
	}
	
	public String getAvailability() {
		return availability.getText();
	}
	
	public String getBrand() {
		return brand.getText();
	}
	
	public String getDescription() {
		return description.getText();
	}
	
	public void selectQuantity(int i) {
		Select select = new Select(quantityDropDown);
		select.selectByVisibleText(Integer.toString(i));
	}
	
	public ShoppingCartPage clickAddToCart() throws InterruptedException {
		addToCartBtn.click();
		WebElement noThanksButton = driver.findElement(By.xpath("//span[@id='attachSiNoCoverage-announce']//preceding-sibling::input"));
		TestUtil.clickOn(driver, noThanksButton, 2000);
		Thread.sleep(2000);
		WebElement cartBtn = driver.findElement(By.id("nav-cart"));
		TestUtil.clickOn(driver, cartBtn, 2000);
		return new ShoppingCartPage();
	}
}
