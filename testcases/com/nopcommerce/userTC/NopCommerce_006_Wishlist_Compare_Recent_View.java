package com.nopcommerce.userTC;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserATCPageObject;
import pageObjects.nopcommerce.user.UserCompareProductPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserProductPageObject;
import pageObjects.nopcommerce.user.UserRecentlyViewedProductPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;
import pageObjects.nopcommerce.user.UserWishlistPageObject;

public class NopCommerce_006_Wishlist_Compare_Recent_View extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserATCPageObject addToCartPage;
	private UserWishlistPageObject wishListPage;
	private UserProductPageObject productPage;
	private UserCompareProductPageObject compareProductPage;
	private UserRecentlyViewedProductPageObject recentlyViewedProductPage;
	private String firstName, lastName, email, password;
	private String wishListPageUrl;
	private String productName;

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
		productName = "Lenovo IdeaCentre 600 All-in-One PC";

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
	}

	@Test
	public void Wishlist_01_Add_To_Wishlist() {
		log.info("AddToWishlist - Step 01: Click Desktops Page link from Computers Menu");
		registerPage.clickToLinkInMenuByText(driver, "Computers", "Desktops");
		productPage = PageGeneratorManager.getUserProductPage(driver);

		log.info("AddToWishlist - Step 02: Choose '" + productName + "' from Product list");
		productPage.clickToProductByName(productName);

		log.info("AddToWishlist - Step 03: Click 'Add to wishlist' button");
		productPage.clickToButtonByText(driver, "Add to wishlist");

		log.info("AddToWishlist - Step 04: Verify 'The product has been added to your wishlist' is displayed");
		verifyEquals(productPage.getResultMessageText(), "The product has been added to your wishlist");

		log.info("AddToWishlist - Step 05: Click close button to close dialog");
		productPage.clickToCloseButton();

		log.info("AddToWishlist - Step 06: Open Wishlist page");
		wishListPage = productPage.openWishListPage(driver);
		wishListPageUrl = driver.getCurrentUrl();

		log.info("AddToWishlist - Step 07: Verify product '" + productName + "' is displayed");
		verifyTrue(wishListPage.isProductDisplayedAtTableByProductName(driver, "Product(s)", productName));

		log.info("AddToWishlist - Step 08: Click to wishlist URL for sharing");
		wishListPage.clickToWishListURL();

		log.info("AddToWishlist - Step 09: Verify product '" + productName + "' is displayed and message");
		verifyTrue(wishListPage.isProductDisplayedAtTableByProductName(driver, "Product(s)", productName));
		verifyEquals(wishListPage.getTitleWishListShareProduct(), "Wishlist of " + firstName + " " + lastName);

	}

	@Test
	public void Wishlist_02_Add_Product_To_Cart() {
		log.info("AddToCart - Step 01: Open Wishlist page");
		wishListPage.openPageUrl(driver, wishListPageUrl);
		wishListPage = PageGeneratorManager.getUserWishListPage(driver);

		log.info("AddToCart - Step 02: Check to checkbox of '" + productName + "'");
		wishListPage.checkToCheckboxByProductName(driver, "Add to cart", productName);

		log.info("AddToCart - Step 03: Click 'Add to cart' button");
		wishListPage.clickToButtonByText(driver, "Add to cart");
		addToCartPage = PageGeneratorManager.getUserATCPage(driver);

		log.info("AddToCart - Step 04: Verify product '" + productName + "' is displayed at Add to Cart page");
		verifyTrue(addToCartPage.isProductDisplayedAtTableByProductName(driver, "Product(s)", productName));

		log.info("AddToCart - Step 05: Open Wishlist page");
		wishListPage = addToCartPage.openWishListPage(driver);

		log.info("AddToCart - Step 06: Verify product '" + productName + "' is not displayed at Wishlist page");
		verifyFalse(wishListPage.isProductDisplayedAtTableByProductName(driver, "Product(s)", productName));

	}

	@Test
	public void Wishlist_03_Remove_Product() {
		log.info("RemoveProduct - Step 01: Click Desktops Page link from Computers Menu");
		wishListPage.clickToLinkInMenuByText(driver, "Computers", "Desktops");
		productPage = PageGeneratorManager.getUserProductPage(driver);

		log.info("RemoveProduct - Step 02: Choose '" + productName + "' from Product list");
		productPage.clickToProductByName(productName);

		log.info("RemoveProduct - Step 03: Click 'Add to wishlist' button");
		productPage.clickToButtonByText(driver, "Add to wishlist");

		log.info("RemoveProduct - Step 04: Verify 'The product has been added to your wishlist' is displayed");
		verifyEquals(productPage.getResultMessageText(), "The product has been added to your wishlist");

		log.info("RemoveProduct - Step 05: Click close button to close dialog");
		productPage.clickToCloseButton();

		log.info("RemoveProduct - Step 06: Open Wishlist page");
		wishListPage = productPage.openWishListPage(driver);

		log.info("RemoveProduct - Step 07: Click to remove icon of '" + productName + "'");
		wishListPage.clickToRemoveIconAtTableByProductName(driver, "Remove", productName);

		log.info("RemoveProduct - Step 08: Verify 'The wishlist is empty!' message is displayed");
		verifyTrue(wishListPage.isEmptyListMessageDisplayed());

		log.info("RemoveProduct - Step 08: Verify product '" + productName + "' is not displayed at Wishlist page");
		verifyFalse(wishListPage.isProductDisplayedAtTableByProductName(driver, "Product(s)", productName));

	}

	@Test
	public void Comprare_01_Add_Product() {
		log.info("AddProduct - Step 01: Click Desktops Page link from Computers Menu");
		registerPage.clickToLinkInMenuByText(driver, "Computers", "Desktops");
		productPage = PageGeneratorManager.getUserProductPage(driver);

		log.info("AddProduct -  Step 02: Click 'Compare' button of 'Lenovo IdeaCentre 600 All-in-One PC' from Product list");
		productPage.clickCompareButtonByProductName("Lenovo IdeaCentre 600 All-in-One PC");

		log.info("AddProduct -  Step 03: Verify 'The product has been added to your product comparison' message is displayed");
		verifyEquals(productPage.getResultMessageText(), "The product has been added to your product comparison");

		log.info("AddProduct - Step 04: Click close button to close dialog");
		productPage.clickToCloseButton();

		log.info("AddProduct -  Step 05: Click 'Compare' button of 'Digital Storm VANQUISH 3 Custom Performance PC' from Product list");
		productPage.clickCompareButtonByProductName("Digital Storm VANQUISH 3 Custom Performance PC");

		log.info("AddProduct -  Step 06: Verify 'The product has been added to your product comparison' message is displayed");
		verifyEquals(productPage.getResultMessageText(), "The product has been added to your product comparison");

		log.info("AddProduct - Step 07: Click close button to close dialog");
		productPage.clickToCloseButton();

		log.info("AddProduct - Step 08: Open 'Compare products list' page in footer");
		productPage.openPageInFooterByPageName(driver, "Compare products list");
		compareProductPage = PageGeneratorManager.getUserCompareProductPage(driver);

		log.info("AddProduct - Step 09: Verify 'Lenovo IdeaCentre 600 All-in-One PC' is displayed");
		verifyTrue(compareProductPage.isProductDisplayedByProductName("Lenovo IdeaCentre 600 All-in-One PC"));

		log.info("AddProduct - Step 10: Verify 'Digital Storm VANQUISH 3 Custom Performance PC' is displayed");
		verifyTrue(compareProductPage.isProductDisplayedByProductName("Digital Storm VANQUISH 3 Custom Performance PC"));

		log.info("AddProduct - Step 11: Click to 'Clear list' button");
		compareProductPage.clickToClearList();

		log.info("AddProduct - Step 12: Verify 'You have no items to compare.' message is displayed");
		verifyTrue(compareProductPage.isCompareEmptyMessageDisplayed());

		log.info("AddProduct - Step 13: Verify 'Lenovo IdeaCentre 600 All-in-One PC' is not displayed");
		verifyFalse(compareProductPage.isProductDisplayedByProductName("Lenovo IdeaCentre 600 All-in-One PC"));

		log.info("AddProduct - Step 14: Verify 'Digital Storm VANQUISH 3 Custom Performance PC' is not displayed");
		verifyFalse(compareProductPage.isProductDisplayedByProductName("Digital Storm VANQUISH 3 Custom Performance PC"));
	}

	@Test
	public void Recent_View_01_Recently_Viewed_Products() {
		log.info("RecentlyViewedProducts - Step 01: Click Notebooks Page link from Computers Menu");
		compareProductPage.clickToLinkInMenuByText(driver, "Computers", "Notebooks");
		productPage = PageGeneratorManager.getUserProductPage(driver);

		log.info("RecentlyViewedProducts - Step 02: View 'Apple MacBook Pro 13-inch' product 1");
		productPage.clickToProductByName("Apple MacBook Pro 13-inch");

		log.info("RecentlyViewedProducts - Step 03: Click Notebooks Page link from Computers Menu");
		productPage.clickToLinkInMenuByText(driver, "Computers", "Notebooks");

		log.info("RecentlyViewedProducts - Step 04: View 'Asus N551JK-XO076H Laptop' product 2");
		productPage.clickToProductByName("Asus N551JK-XO076H Laptop");

		log.info("RecentlyViewedProducts - Step 05: Click Notebooks Page link from Computers Menu");
		productPage.clickToLinkInMenuByText(driver, "Computers", "Notebooks");

		log.info("RecentlyViewedProducts - Step 06: View 'HP Envy 6-1180ca 15.6-Inch Sleekbook' product 3");
		productPage.clickToProductByName("HP Envy 6-1180ca 15.6-Inch Sleekbook");

		log.info("RecentlyViewedProducts - Step 07: Click Notebooks Page link from Computers Menu");
		productPage.clickToLinkInMenuByText(driver, "Computers", "Notebooks");

		log.info("RecentlyViewedProducts - Step 08: View 'HP Spectre XT Pro UltraBook' product 4");
		productPage.clickToProductByName("HP Spectre XT Pro UltraBook");

		log.info("RecentlyViewedProducts - Step 09: Click Notebooks Page link from Computers Menu");
		productPage.clickToLinkInMenuByText(driver, "Computers", "Notebooks");

		log.info("RecentlyViewedProducts - Step 10: View 'Lenovo Thinkpad X1 Carbon Laptop' product 5");
		productPage.clickToProductByName("Lenovo Thinkpad X1 Carbon Laptop");

		log.info("RecentlyViewedProducts - Step 11: Open 'Recently viewed products' page in footer");
		productPage.openPageInFooterByPageName(driver, "Recently viewed products");
		recentlyViewedProductPage = PageGeneratorManager.getUserRecentlyViewedProductPage(driver);

		log.info("RecentlyViewedProducts - Step 12: Verify 3 products is displayed");
		verifyEquals(recentlyViewedProductPage.getNumberProductDisplayed(), 3);

		log.info("RecentlyViewedProducts - Step 13: Verify 'Lenovo Thinkpad X1 Carbon Laptop' product 5 is displayed");
		verifyTrue(recentlyViewedProductPage.isProductDisplayedByProductName("Lenovo Thinkpad X1 Carbon Laptop"));

		log.info("RecentlyViewedProducts - Step 14: Verify 'HP Spectre XT Pro UltraBook' product 4 is displayed");
		verifyTrue(recentlyViewedProductPage.isProductDisplayedByProductName("HP Spectre XT Pro UltraBook"));

		log.info("RecentlyViewedProducts - Step 15: Verify 'HP Envy 6-1180ca 15.6-Inch Sleekbook' product 3 is displayed");
		verifyTrue(recentlyViewedProductPage.isProductDisplayedByProductName("HP Envy 6-1180ca 15.6-Inch Sleekbook"));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
