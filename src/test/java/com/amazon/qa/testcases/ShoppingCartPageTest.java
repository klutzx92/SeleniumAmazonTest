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

public class ShoppingCartPageTest extends TestBase{
	
	HomePage homePage;
	SearchPage searchPage;
	ProductPage productPage;
	ShoppingCartPage shoppingCartPage;
	
	public ShoppingCartPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		homePage = new HomePage();
		searchPage = homePage.searchFor(prop.getProperty("product"));
		productPage = searchPage.clickOnProduct(prop.getProperty("product"));
		try {
			shoppingCartPage = productPage.clickAddToCart();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void validateShoppingCartPageTitle() {
		String title = shoppingCartPage.getShoppingCartPageTitle();
		Assert.assertEquals(title, "Amazon.com Shopping Cart");
	}
	
	@Test
	public void validateShoppingCartItemTest() {
		String itemTitle = shoppingCartPage.getItemTitle();
		Assert.assertEquals(itemTitle, prop.getProperty("product"));
	}
	
	@Test
	public void shoppingCartQuantityTest() {
		int numItems = shoppingCartPage.getNumberOfItems();
		Assert.assertEquals(numItems, 1);
	}
	
	@Test
	public void deleteItemTest() {
		shoppingCartPage.deleteItem();
		int numItems = shoppingCartPage.getNumberOfItems();
		Assert.assertEquals(numItems,  0);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
