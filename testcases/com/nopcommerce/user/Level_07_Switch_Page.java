package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.UserAddressPageObject;
import pageObjects.user.UserBackInStockSubscriptionPageObject;
import pageObjects.user.UserChangePasswordPageObject;
import pageObjects.user.UserCustomerInfoPageObject;
import pageObjects.user.UserDownloadableProductPageObject;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserMyProductReviewPageObject;
import pageObjects.user.UserOrderPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, email, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserOrderPageObject orderPage;
	private UserDownloadableProductPageObject downloadableProductPage;
	private UserBackInStockSubscriptionPageObject backInStockSubscriptionPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserChangePasswordPageObject changePasswordPage;
	private UserMyProductReviewPageObject myProductReviewPage;

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		email = "afc" + generateFakeNumber() + "@mail.vn";
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_Customer_Info() {
		customerInfoPage = homePage.openMyAccountPage();

		Assert.assertTrue(customerInfoPage.isCustomerInfoPageIsDisplayed());
	}

	@Test
	public void User_04_Switch_Page() {
		addressPage = customerInfoPage.openAddressPage(driver);

		orderPage = addressPage.openOrderPage(driver);

		downloadableProductPage = orderPage.openDownloadableProductPage(driver);

		backInStockSubscriptionPage = downloadableProductPage.openBackInStockSubscriptionPage(driver);

		rewardPointPage = backInStockSubscriptionPage.openRewardPointPage(driver);

		changePasswordPage = rewardPointPage.openChangePasswordPage(driver);

		myProductReviewPage = changePasswordPage.openMyProductReviewPage(driver);

		customerInfoPage = myProductReviewPage.openCustomerInfoPage(driver);
	}

	@Test
	public void User_05_Switch_Role() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
