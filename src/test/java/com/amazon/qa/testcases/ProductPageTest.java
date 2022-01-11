package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.ProductPage;
import com.amazon.qa.pages.SearchPage;
import com.amazon.qa.pages.ShoppingCartPage;

public class ProductPageTest extends TestBase{
	
	HomePage homePage;
	SearchPage searchPage;
	ProductPage productPage;
	
	public ProductPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		searchPage = homePage.searchFor(prop.getProperty("product"));
		productPage = searchPage.clickOnProduct(prop.getProperty("product"));
	}
	
	
	@Test
	public void productPageTitleTest() {
		String title = productPage.getProductPageTitle();
		Assert.assertEquals(title, "Amazon.com: " + prop.getProperty("product") + " : Electronics");
	}
	
	@Test
	public void productNameTest() {
		String name = productPage.getProductName();
		Assert.assertEquals(name, prop.getProperty("product"));
	}
	
	@Test
	public void productBrandTest() {
		String brand = productPage.getBrand();
		Assert.assertEquals(brand, "Apple");
	}
	
	@Test
	public void productPriceTest() {
		String price = productPage.getPrice();
		Assert.assertEquals(price, prop.getProperty("price"));
	}
	
	@Test
	public void productAvailability() {
		String available = productPage.getAvailability();
		Assert.assertEquals(available, "In Stock.");
	}
	
	@Test
	public void productDescriptionTest() {
		String description = productPage.getDescription();
		Assert.assertEquals(description, "Active Noise Cancellation blocks outside noise, so you can immerse yourself in music");
	}
	
	@Test
	public void addOneToCartTest() throws InterruptedException {
		ShoppingCartPage shoppingCartPage = productPage.clickAddToCart();
	}
	
	@Test
	public void addTwoToCartTest() throws InterruptedException {
		productPage.selectQuantity(2);
		ShoppingCartPage shoppingCartPage = productPage.clickAddToCart();
	}
	
	@Test
	public void addThreeToCartTest() throws InterruptedException {
		productPage.selectQuantity(3);
		ShoppingCartPage shoppingCartPage = productPage.clickAddToCart();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
