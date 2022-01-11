package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.ProductPage;
import com.amazon.qa.pages.SearchPage;

public class SearchPageTest extends TestBase{

	HomePage homePage;
	SearchPage searchPage;
	ProductPage productPage;

	public SearchPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		searchPage = homePage.searchFor(prop.getProperty("product"));
		
	}
	
	@Test(priority=1)
	public void searchPageTitleTest() {
		String title = searchPage.getSearchPageTitle();
		Assert.assertEquals(title, "Amazon.com : " + prop.getProperty("product"));
	}
	
	@Test(priority=2)
	public void clickOnProductTest() {
		productPage = searchPage.clickOnProduct(prop.getProperty("product"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
