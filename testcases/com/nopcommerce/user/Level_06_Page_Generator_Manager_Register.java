package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_06_Page_Generator_Manager_Register extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		firstName = "Automation";
		lastName = "FC";
		password = "123456";
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01 - Step 1: Click to Register link");
		registerPage = homePage.openRegisterPage();

		System.out.println("Register_01 - Step 2: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_01 - Step 3: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("Register_02 - Step 1: Click to Register link");
		registerPage = homePage.openRegisterPage();

		System.out.println("Register_02 - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("123@456#%*");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_02 - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_02 - Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Register_03_Success() {
		System.out.println("Register_03 - Step 1: Click to Register link");
		registerPage = homePage.openRegisterPage();

		System.out.println("Register_03 - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_03 - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_03 - Step 4: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Register_03 - Step 5: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void Register_04_Existing_Email() {
		System.out.println("Register_04 - Step 1: Click to Register link");
		registerPage = homePage.openRegisterPage();

		System.out.println("Register_04 - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_04 - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_04 - Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getExistEmailErrorMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		System.out.println("Register_05 - Step 1: Click to Register link");
		registerPage = homePage.openRegisterPage();

		System.out.println("Register_05 - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");

		System.out.println("Register_05 - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_05 - Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		System.out.println("Register_06 - Step 1: Click to Register link");
		registerPage = homePage.openRegisterPage();

		System.out.println("Register_06 - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("1234567");

		System.out.println("Register_06 - Step 3: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_06 - Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
