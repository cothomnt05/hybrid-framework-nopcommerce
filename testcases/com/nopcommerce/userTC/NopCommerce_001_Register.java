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

public class NopCommerce_001_Register extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private String registerPageUrl;
	private String firstName, lastName, email, password;

	@Parameters({ "browser", "url" })

	@BeforeClass
	public void beforeClass(String browserName, String urlPage) {
		log.info("Pre-Condition: Open browse and navigate to Homepage");
		driver = getBrowserDriver(browserName, urlPage);

		homePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		email = "automation" + generateFakeNumber() + "@gmail.com";
		password = "123456";
	}

	@Test
	public void Register_01_Empty_Data() {
		log.info("RegisterWithEmptyData - Step 01: Navigate to Register page");
		registerPage = homePage.openRegisterPage();
		registerPageUrl = driver.getCurrentUrl();

		log.info("RegisterWithEmptyData - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("RegisterWithEmptyData - Step 03: Verify error message at Firstname textbox");
		verifyEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");

		log.info("RegisterWithEmptyData - Step 04: Verify error message at Lastname textbox");
		verifyEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");

		log.info("RegisterWithEmptyData - Step 05: Verify error message at Email textbox");
		verifyEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");

		log.info("RegisterWithEmptyData - Step 06: Verify error message at Password textbox");
		verifyEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");

		log.info("RegisterWithEmptyData - Step 07: Verify error message at Confirm password textbox");
		verifyEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		log.info("RegisterWithInvalidEmail - Step 01: Navigate to Register page");
		registerPage.openPageUrl(driver, registerPageUrl);

		log.info("RegisterWithInvalidEmail - Step 02: Input to Firstname textbox with value: " + firstName);
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("RegisterWithInvalidEmail - Step 03: Input to Lastname textbox with value: " + lastName);
		registerPage.inputToLastNameTextbox(lastName);

		log.info("RegisterWithInvalidEmail - Step 04: Input to Email textbox with value: " + "automation@#$%");
		registerPage.inputToEmailTextbox("automation@#$%");

		log.info("RegisterWithInvalidEmail - Step 05: Input to Password textbox with value: " + password);
		registerPage.inputToPasswordTextbox(password);

		log.info("RegisterWithInvalidEmail - Step 06: Input to Confirm Password textbox with value: " + password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("RegisterWithInvalidEmail - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("RegisterWithInvalidEmail - Step 08: Verify error message at Email textbox");
		verifyEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Register_03_Password_Less_6_Charater() {
		log.info("RegisterWithPasswordLess6Char - Step 01: Navigate to Register page");
		registerPage.openPageUrl(driver, registerPageUrl);

		log.info("RegisterWithPasswordLess6Char - Step 02: Input to Firstname textbox with value: " + firstName);
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("RegisterWithPasswordLess6Char - Step 03: Input to Lastname textbox with value: " + lastName);
		registerPage.inputToLastNameTextbox(lastName);

		log.info("RegisterWithPasswordLess6Char - Step 04: Input to Email textbox with value: " + email);
		registerPage.inputToEmailTextbox(email);

		log.info("RegisterWithPasswordLess6Char - Step 05: Input to Password textbox with value: " + "1234");
		registerPage.inputToPasswordTextbox("1234");

		log.info("RegisterWithPasswordLess6Char - Step 06: Input to Confirm Password textbox with value: " + "1234");
		registerPage.inputToConfirmPasswordTextbox("1234");

		log.info("RegisterWithPasswordLess6Char - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("RegisterWithPasswordLess6Char - Step 08: Verify error message at Password textbox");
		verifyEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_04_Confirm_Password() {
		log.info("RegisterConfirmPassword - Step 01: Navigate to Register page");
		registerPage.openPageUrl(driver, registerPageUrl);

		log.info("RegisterConfirmPassword - Step 02: Input to Firstname textbox with value: " + firstName);
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("RegisterConfirmPassword - Step 03: Input to Lastname textbox with value: " + lastName);
		registerPage.inputToLastNameTextbox(lastName);

		log.info("RegisterConfirmPassword - Step 04: Input to Email textbox with value: " + email);
		registerPage.inputToEmailTextbox(email);

		log.info("RegisterConfirmPassword - Step 05: Input to Password textbox with value: " + password);
		registerPage.inputToPasswordTextbox(password);

		log.info("RegisterConfirmPassword - Step 06: Input to Confirm Password textbox with value: " + "1234567");
		registerPage.inputToConfirmPasswordTextbox("1234567");

		log.info("RegisterConfirmPassword - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("RegisterConfirmPassword - Step 08: Verify error message at Confirm password textbox");
		verifyEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Success() {
		log.info("RegisterSuccess - Step 01: Navigate to Register page");
		registerPage.openPageUrl(driver, registerPageUrl);

		log.info("RegisterSuccess - Step 02: Input to Firstname textbox with value: " + firstName);
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("RegisterSuccess - Step 03: Input to Lastname textbox with value: " + lastName);
		registerPage.inputToLastNameTextbox(lastName);

		log.info("RegisterSuccess - Step 04: Input to Email textbox with value: " + email);
		registerPage.inputToEmailTextbox(email);

		log.info("RegisterSuccess - Step 05: Input to Password textbox with value: " + password);
		registerPage.inputToPasswordTextbox(password);

		log.info("RegisterSuccess - Step 06: Input to Confirm Password textbox with value: " + password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("RegisterSuccess - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("RegisterSuccess - Step 08: Vefiry Register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("RegisterSuccess - Step 09: Click to Logout button");
		homePage = registerPage.clickToLogoutAtUserPage(driver);
	}

	@Test
	public void Register_06_Email_Existed() {
		log.info("RegisterWithEmailExsited - Step 01: Navigate to Register page");
		registerPage = homePage.openRegisterPage();

		log.info("RegisterWithEmailExsited - Step 02: Input to Firstname textbox with value: " + firstName);
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("RegisterWithEmailExsited - Step 03: Input to Lastname textbox with value: " + lastName);
		registerPage.inputToLastNameTextbox(lastName);

		log.info("RegisterWithEmailExsited - Step 04: Input to Email textbox with value: " + email);
		registerPage.inputToEmailTextbox(email);

		log.info("RegisterWithEmailExsited - Step 05: Input to Password textbox with value: " + password);
		registerPage.inputToPasswordTextbox(password);

		log.info("RegisterWithEmailExsited - Step 06: Input to Confirm Password textbox with value: " + password);
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("RegisterWithEmailExsited - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();

		log.info("RegisterWithEmailExsited - Step 08: Verify error message at Email textbox");
		verifyEquals(registerPage.getExistEmailErrorMessage(), "The specified email already exists");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
