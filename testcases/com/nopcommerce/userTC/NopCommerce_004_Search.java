package com.nopcommerce.userTC;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserSearchPageObject;

public class NopCommerce_004_Search extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserSearchPageObject searchPage;
	private String firstName, lastName, email, password;

	@Parameters({ "browser", "url" })

	@BeforeClass
	public void beforeClass(String browserName, String urlPage) {
		log.info("Pre-Condition - Step 01: Open browse and navigate to Homepage");
		driver = getBrowserDriver(browserName, urlPage);

		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		email = "automation" + generateFakeNumber() + "@gmail.com";
		password = "123456";

		log.info("Pre-Condition - Step 02: Navigate to Register page");
		registerPage = homePage.openRegisterPage();

		log.info("Pre-Condition - Step 03: Input to Firstname textbox with value: " + firstName);
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("Pre-Condition - Step 04: Input to Lastname textbox with value: " + lastName);
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Pre-Condition - Step 05: Input to Email textbox with value: " + email);
		registerPage.inputToEmailTextbox(email);

		log.info("Pre-Condition - Step 06: Input to Password textbox with value: " + password);
		registerPage.inputToPasswordTextbox(password);

		log.info("Pre-Condition - Step 07: Input to Confirm Password textbox with value: " + password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Pre-Condition - Step 08: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("Pre-Condition - Step 09: Verify Register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre-Condition - Step 10: Click to Search Page link");
		registerPage.openPageInFooterByPageName(driver, "Search");
		searchPage = PageGeneratorManager.getUserSearchPage(driver);

	}

	@Test
	public void Search_01_Empty_Data() {
		log.info("SearchWithEmptyData - Step 01: Click to SEARCH button");
		searchPage.clickToSearchButton();

		log.info("SearchWithEmptyData - Step 02: Verify 'Search term minimum length is 3 characters' message is displayed");
		verifyEquals(searchPage.getSearchLengthWarningMessage(), "Search term minimum length is 3 characters");

		log.info("SearchWithEmptyData - Step 03: Click to Search Page link");
		searchPage.openPageInFooterByPageName(driver, "Search");

	}

	@Test
	public void Search_02_Data_Not_Exist() {
		log.info("SearchWithDataNOtExist - Step 01: Input to Search keyword textbox with value: " + "MacBook Pro 2050");
		searchPage.inputToTextboxByLabel(driver, "Search keyword", "MacBook Pro 2050");

		log.info("SearchWithDataNOtExist - Step 02: Click to SEARCH button");
		searchPage.clickToSearchButton();

		log.info("SearchWithDataNOtExist - Step 03: Verify 'No products were found that matched your criteria.' message is displayed");
		verifyTrue(searchPage.isNoResultsMessageDisplayed());

		log.info("SearchWithDataNOtExist - Step 04: Click to Search Page link");
		searchPage.openPageInFooterByPageName(driver, "Search");

	}

	@Test
	public void Search_03_Short_Product_Name() {
		log.info("SearchWithShortProductName - Step 01: Input to Search keyword textbox with value: " + "Lenovo");
		searchPage.inputToTextboxByLabel(driver, "Search keyword", "Lenovo");

		log.info("SearchWithShortProductName - Step 02: Click to SEARCH button");
		searchPage.clickToSearchButton();

		log.info("SearchWithShortProductName - Step 03: Verify 2 products is displayed");
		verifyEquals(searchPage.getProductNumberSearchBySearchKeyword("Lenovo"), 2);

		log.info("SearchWithShortProductName - Step 04: Click to Search Page link");
		searchPage.openPageInFooterByPageName(driver, "Search");

	}

	@Test
	public void Search_04_Full_Product_Name() {
		log.info("SearchWithFullProductName - Step 01: Input to Search keyword textbox with value: " + "Thinkpad X1 Carbon");
		searchPage.inputToTextboxByLabel(driver, "Search keyword", "Thinkpad X1 Carbon");

		log.info("SearchWithFullProductName - Step 02: Click to SEARCH button");
		searchPage.clickToSearchButton();

		log.info("SearchWithFullProductName - Step 03: Verify 1 products is displayed");
		verifyEquals(searchPage.getProductNumberSearchBySearchKeyword("Thinkpad X1 Carbon"), 1);

		log.info("SearchWithFullProductName - Step 04: Click to Search Page link");
		searchPage.openPageInFooterByPageName(driver, "Search");

	}

	@Test
	public void Search_05_Advanced_Parent_Categories() {
		log.info("AdvancedSearchWithParentCategories - Step 01: Input to Search keyword textbox with value: " + "Apple MacBook Pro");
		searchPage.inputToTextboxByLabel(driver, "Search keyword", "Apple MacBook Pro");

		log.info("AdvancedSearchWithParentCategories - Step 02: Check to 'Advanced search' checkbox");
		searchPage.checkToCheckboxByLabel("Advanced search");

		log.info("AdvancedSearchWithParentCategories - Step 03: Select 'Computers' At Category Dropdown");
		searchPage.selectItemInDropdownByLabel(driver, "Category", "Computers");

		log.info("AdvancedSearchWithParentCategories - Step 04: Uncheck to 'Automatically search sub categories' checkbox");
		searchPage.unCheckToCheckboxByLabel("sub categories");

		log.info("AdvancedSearchWithParentCategories - Step 05: Click to SEARCH button");
		searchPage.clickToSearchButton();

		log.info("AdvancedSearchWithParentCategories - Step 06: Verify 'No products were found that matched your criteria.' message is displayed");
		verifyTrue(searchPage.isNoResultsMessageDisplayed());

		log.info("AdvancedSearchWithParentCategories - Step 07: Click to Search Page link");
		searchPage.openPageInFooterByPageName(driver, "Search");
	}

	@Test
	public void Search_06_Advanced_Sub_Categories() {
		log.info("AdvancedSearchWithSubCategories - Step 01: Input to Search keyword textbox with value: " + "Apple MacBook Pro");
		searchPage.inputToTextboxByLabel(driver, "Search keyword", "Apple MacBook Pro");

		log.info("AdvancedSearchWithSubCategories - Step 02: Check to 'Advanced search' checkbox");
		searchPage.checkToCheckboxByLabel("Advanced search");

		log.info("AdvancedSearchWithSubCategories - Step 03: Select 'Computers' At Category Dropdown");
		searchPage.selectItemInDropdownByLabel(driver, "Category", "Computers");

		log.info("AdvancedSearchWithSubCategories - Step 04: Check to 'Automatically search sub categories' checkbox");
		searchPage.checkToCheckboxByLabel("sub categories");

		log.info("AdvancedSearchWithSubCategories - Step 05: Click to SEARCH button");
		searchPage.clickToSearchButton();

		log.info("AdvancedSearchWithSubCategories - Step 06: Verify 1 products is displayed");
		verifyEquals(searchPage.getProductNumberSearchBySearchKeyword("Apple MacBook Pro"), 1);

		log.info("AdvancedSearchWithSubCategories - Step 07: Click to Search Page link");
		searchPage.openPageInFooterByPageName(driver, "Search");

	}

	@Test
	public void Search_07_Advanced_Incorrect_Manufacturer() {
		log.info("AdvancedSearchWithIncorrectManufacturer - Step 01: Input to Search keyword textbox with value: " + "Apple MacBook Pro");
		searchPage.inputToTextboxByLabel(driver, "Search keyword", "Apple MacBook Pro");

		log.info("AdvancedSearchWithIncorrectManufacturer - Step 02: Check to 'Advanced search' checkbox");
		searchPage.checkToCheckboxByLabel("Advanced search");

		log.info("AdvancedSearchWithIncorrectManufacturer - Step 03: Select 'Computers' At Category Dropdown");
		searchPage.selectItemInDropdownByLabel(driver, "Category", "Computers");

		log.info("AdvancedSearchWithIncorrectManufacturer - Step 04: Check to 'Automatically search sub categories' checkbox");
		searchPage.checkToCheckboxByLabel("sub categories");

		log.info("AdvancedSearchWithIncorrectManufacturer - Step 05: Select 'HP' At Manufacturer Dropdown");
		searchPage.selectItemInDropdownByLabel(driver, "Manufacturer", "HP");

		log.info("AdvancedSearchWithIncorrectManufacturer - Step 06: Click to SEARCH button");
		searchPage.clickToSearchButton();

		log.info("AdvancedSearchWithIncorrectManufacturer - Step 07: Verify 'No products were found that matched your criteria.' message is displayed");
		verifyTrue(searchPage.isNoResultsMessageDisplayed());

		log.info("AdvancedSearchWithIncorrectManufacturer - Step 08: Click to Search Page link");
		searchPage.openPageInFooterByPageName(driver, "Search");
	}

	@Test
	public void Search_08_Advanced_Correct_Manufacturer() {
		log.info("AdvancedSearchWithCorrectManufacturer - Step 01: Input to Search keyword textbox with value: " + "Apple MacBook Pro");
		searchPage.inputToTextboxByLabel(driver, "Search keyword", "Apple MacBook Pro");

		log.info("AdvancedSearchWithCorrectManufacturer - Step 02: Check to 'Advanced search' checkbox");
		searchPage.checkToCheckboxByLabel("Advanced search");

		log.info("AdvancedSearchWithCorrectManufacturer - Step 03: Select 'Computers' At Category Dropdown");
		searchPage.selectItemInDropdownByLabel(driver, "Category", "Computers");

		log.info("AdvancedSearchWithCorrectManufacturer - Step 04: Check to 'Automatically search sub categories' checkbox");
		searchPage.checkToCheckboxByLabel("sub categories");

		log.info("AdvancedSearchWithCorrectManufacturer - Step 05: Select 'Apple' At Manufacturer Dropdown");
		searchPage.selectItemInDropdownByLabel(driver, "Manufacturer", "Apple");

		log.info("AdvancedSearchWithCorrectManufacturer - Step 06: Click to SEARCH button");
		searchPage.clickToSearchButton();

		log.info("AdvancedSearchWithCorrectManufacturer - Step 07: Verify 1 products is displayed");
		verifyEquals(searchPage.getProductNumberSearchBySearchKeyword("Apple MacBook Pro"), 1);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
