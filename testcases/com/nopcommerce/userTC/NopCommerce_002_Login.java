package com.nopcommerce.userTC;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class NopCommerce_002_Login extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private String firstName, lastName, email, password;
	private String loginUrl;

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

		log.info("Pre-Condition - Step 09: Vefiry Register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre-Condition - Step 10: Click to Logout button");
		homePage = registerPage.clickToLogoutAtUserPage(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		log.info("LoginWithEmptyData - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();
		loginUrl = driver.getCurrentUrl();

		log.info("LoginWithEmptyData - Step 02: Click to Login button");
		loginPage.clickToLoginButton();

		log.info("LoginWithEmptyData - Step 03: Verify error message at Email textbox");
		verifyEquals(loginPage.getErrorMessageToEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		log.info("LoginWithInvalidEmail - Step 01: Navigate to Login page");
		loginPage.openPageUrl(driver, loginUrl);

		log.info("LoginWithInvalidEmail - Step 02: Input to Email textbox with value: " + "automation@%^&");
		loginPage.inputToEmailTextbox("automation@%^&");

		log.info("LoginWithInvalidEmail - Step 03: Input to Password textbox with value: " + password);
		loginPage.inputToEmailTextbox(password);

		log.info("LoginWithInvalidEmail - Step 04: Click to Login button");
		loginPage.clickToLoginButton();

		log.info("LoginWithInvalidEmail - Step 03: Verify error message at Email textbox");
		verifyEquals(loginPage.getErrorMessageToEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Email_Is_Not_Registed() {
		log.info("EmailIsNotRegisted - Step 01: Navigate to Login page");
		loginPage.openPageUrl(driver, loginUrl);

		log.info("EmailIsNotRegisted - Step 02: Input to Email textbox with value: " + "automation@net.vn");
		loginPage.inputToEmailTextbox("automation@net.vn");

		log.info("EmailIsNotRegisted - Step 03: Input to Password textbox with value: " + password);
		loginPage.inputToPasswordTextbox(password);

		log.info("EmailIsNotRegisted - Step 04: Click to Login button");
		loginPage.clickToLoginButton();

		log.info("EmailIsNotRegisted - Step 05: Verify unsuccessful message");
		verifyEquals(loginPage.getUnSuccessfulLoginErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Empty_Password() {
		log.info("EmptyPassword - Step 01: Navigate to Login page");
		loginPage.openPageUrl(driver, loginUrl);

		log.info("EmptyPassword - Step 02: Input to Email textbox with value: " + email);
		loginPage.inputToEmailTextbox(email);

		log.info("EmptyPassword - Step 04: Click to Login button");
		loginPage.clickToLoginButton();

		log.info("EmptyPassword - Step 03: Verify unsuccessful message");
		verifyEquals(loginPage.getUnSuccessfulLoginErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Wrong_Password() {
		log.info("WrongPassword - Step 01: Navigate to Login page");
		loginPage.openPageUrl(driver, loginUrl);

		log.info("WrongPassword - Step 02: Input to Email textbox with value: " + email);
		loginPage.inputToEmailTextbox(email);

		log.info("WrongPassword - Step 03: Input to Password textbox with value: " + "1234567");
		loginPage.inputToPasswordTextbox("1234567");

		log.info("WrongPassword - Step 04: Click to Login button");
		loginPage.clickToLoginButton();

		log.info("WrongPassword - Step 05: Verify unsuccessful message");
		verifyEquals(loginPage.getUnSuccessfulLoginErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Success() {
		log.info("Success - Step 01: Navigate to Login page");
		loginPage.openPageUrl(driver, loginUrl);

		log.info("Success - Step 02: Input to Email textbox with value: " + email);
		loginPage.inputToEmailTextbox(email);

		log.info("Success - Step 03: Input to Password textbox with value: " + password);
		loginPage.inputToPasswordTextbox(password);

		log.info("Success - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Success - Step 03: Verify MyAccount link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
