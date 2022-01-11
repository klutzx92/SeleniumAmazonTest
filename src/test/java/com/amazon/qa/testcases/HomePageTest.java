package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.SearchPage;

public class HomePageTest extends TestBase{
	HomePage homePage;
	SearchPage searchPage;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test(priority = 1)
	public void validateHomePageTitleTest() {
		String homePageTitle = homePage.getHomePageTitle();
		Assert.assertEquals(homePageTitle, "Amazon.com. Spend less. Smile more.");
	}
	
	@Test(priority = 2)
	public void searchTest() {
		searchPage = homePage.searchFor("Airpods Pro");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
