package com.nopcommerce.userTC;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserProductPageObject;

public class NopCommerce_005_Sort_Data_And_Display_Product extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserProductPageObject productPage;

	@Parameters({ "browser", "url" })

	@BeforeClass
	public void beforeClass(String browserName, String urlPage) {
		log.info("Pre-Condition - Step 01: Open browse and navigate to Homepage");
		driver = getBrowserDriver(browserName, urlPage);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-Condition - Step 02: Click to 'Notebooks' in Computer Header Menu");
		homePage.clickToLinkInMenuByText(driver, "Computers", "Notebooks");
		productPage = PageGeneratorManager.getUserProductPage(driver);

	}

	@Test
	public void SortData_01_By_Name_A_To_Z() {
		log.info("SortDataByNameAToZ - Step 01: Select 'Name: A to Z' from Position Dropdown");
		productPage.selectItemSortInDropdown("Sort by", "Name: A to Z");

		log.info("SortDataByNameAToZ - Step 02: Verify list product is sorted by name from A to Z");
		verifyTrue(productPage.isListItemSortedAscByName());

		log.info("SortDataByNameAToZ - Step 03: Click to 'Notebooks' in Computer Header Menu");
		productPage.clickToLinkInMenuByText(driver, "Computers", "Notebooks");
	}

	@Test
	public void SortData_02_By_Name_Z_To_A() {
		log.info("SortDataByNameZToA - Step 01: Select 'Name: Z to A' from Position Dropdown");
		productPage.selectItemSortInDropdown("Sort by", "Name: Z to A");

		log.info("SortDataByNameZToA - Step 02: Verify list product is sorted by name from Z to A");
		verifyTrue(productPage.isListItemSortedDescByName());

		log.info("SortDataByNameZToA - Step 03: Click to 'Notebooks' in Computer Header Menu");
		productPage.clickToLinkInMenuByText(driver, "Computers", "Notebooks");
	}

	@Test
	public void SortData_03_By_Price_Low_To_High() {
		log.info("SortDataByPriceLowToHigh - Step 01: Select 'Price: Low to High' from Position Dropdown");
		productPage.selectItemSortInDropdown("Sort by", "Price: Low to High");

		log.info("SortDataByPriceLowToHigh - Step 02: Verify list product is sorted by price from low to high");
		verifyTrue(productPage.isListItemSortedAscByPrice());

		log.info("SortDataByPriceLowToHigh - Step 03: Click to 'Notebooks' in Computer Header Menu");
		productPage.clickToLinkInMenuByText(driver, "Computers", "Notebooks");
	}

	@Test
	public void SortData_04_By_Price_High_To_Low() {
		log.info("SortDataByPriceHighToLow - Step 01: Select 'Price: High to Low' from Position Dropdown");
		productPage.selectItemSortInDropdown("Sort by", "Price: High to Low");

		log.info("SortDataByPriceHighToLow - Step 02: Verify list product is sorted by price from high to low");
		verifyTrue(productPage.isListItemSortedDescByPrice());

		log.info("SortDataByPriceHighToLow - Step 03: Click to 'Notebooks' in Computer Header Menu");
		productPage.clickToLinkInMenuByText(driver, "Computers", "Notebooks");
	}

	@Test
	public void DisplayProduct_01_With_3_Products() {
		log.info("DisplayWith3Products - Step 01: Select '3' from Display Dropdown");
		productPage.selectItemSortInDropdown("Display", "3");

		log.info("DisplayWith3Products - Step 02: Verify at most 3 products displayed");
		verifyTrue(productPage.isItemNumberAtMostNumberProductsDisplayed(3));

		log.info("DisplayWith3Products - Step 03: Verify next icon is displayed at page 1");
		verifyEquals(productPage.getCurrentPageNumber(), "1");
		verifyTrue(productPage.isNextPagingIconDisplayedAtPage1());

		log.info("DisplayWith3Products - Step 04: Paging to Page 2");
		productPage.pagingToNumberPage("2");

		log.info("DisplayWith3Products - Step 05: Verify previous icon is displayed at page 2");
		verifyEquals(productPage.getCurrentPageNumber(), "2");
		verifyTrue(productPage.isPreviousPagingIconDisplayedAtPage2());

		log.info("DisplayWith3Products - Step 06: Click to 'Notebooks' in Computer Header Menu");
		productPage.clickToLinkInMenuByText(driver, "Computers", "Notebooks");
	}

	@Test
	public void DisplayProduct_02_With_6_Products() {
		log.info("DisplayWith6Products - Step 01: Select '6' from Display Dropdown");
		productPage.selectItemSortInDropdown("Display", "6");

		log.info("DisplayWith6Products - Step 02: Verify at most 6 products displayed");
		verifyTrue(productPage.isItemNumberAtMostNumberProductsDisplayed(6));

		log.info("DisplayWith6Products - Step 03: Verify paging is not displayed");
		verifyTrue(productPage.isPagingIconNotDisplayed());

		log.info("DisplayWith6Products - Step 04: Click to 'Notebooks' in Computer Header Menu");
		productPage.clickToLinkInMenuByText(driver, "Computers", "Notebooks");
	}

	@Test
	public void DisplayProduct_03_With_9_Products() {
		log.info("DisplayWith9Products - Step 01: Select '9' from Display Dropdown");
		productPage.selectItemSortInDropdown("Display", "9");

		log.info("DisplayWith9Products - Step 02: Verify at most 9 products displayed");
		verifyTrue(productPage.isItemNumberAtMostNumberProductsDisplayed(9));

		log.info("DisplayWith9Products - Step 03: Verify paging is not displayed");
		verifyTrue(productPage.isPagingIconNotDisplayed());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
