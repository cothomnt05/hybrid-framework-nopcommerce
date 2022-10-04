package com.nopcommerce.userTC;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopcommerce.user.UserAddressPageObject;
import pageObjects.nopcommerce.user.UserChangePasswordPageObject;
import pageObjects.nopcommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopcommerce.user.UserHomePageObject;
import pageObjects.nopcommerce.user.UserLoginPageObject;
import pageObjects.nopcommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopcommerce.user.UserProductPageObject;
import pageObjects.nopcommerce.user.UserRegisterPageObject;

public class NopCommerce_003_MyAccount extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserChangePasswordPageObject changePasswordPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserProductPageObject productPage;
	private String firstName, lastName, email, password;
	private String gender, updateFirstName, updateLastName, updateEmail, companyName;
	private String dateOfBirth, monthOfBirth, yearOfBirth;
	private String country, state, city, address1, address2, zipCode, phoneNumber, faxNumber;
	private String newPassword;
	private String reviewTitle, reviewText;
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

		gender = "Male";
		updateFirstName = "Autotmation";
		updateLastName = "FC";
		updateEmail = "automationfc" + generateFakeNumber() + ".vn@gmail.com";
		companyName = "Automation FC";
		dateOfBirth = "1";
		monthOfBirth = "January";
		yearOfBirth = "1999";

		country = "Viet Nam";
		state = "Other";
		city = "Da Nang";
		address1 = "123/04 Le Lai";
		address2 = "234/05 Hai Phong";
		zipCode = "550000";
		phoneNumber = "0123456789";
		faxNumber = "0987654321";

		newPassword = "1234567";

		reviewTitle = "review title";
		reviewText = "review text";
		productName = "Build your own computer";

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

		log.info("Pre-Condition - Step 10: Click to MyAccount link");
		customerInfoPage = registerPage.openMyAccountPage(driver);

	}

	@Test
	public void MyAccount_01_Customer_Info() {
		log.info("CustomerInfo - Step 01: Open Customer Info page");
		customerInfoPage = customerInfoPage.openCustomerInfoPage(driver);

		log.info("CustomerInfo - Step 02: Update Gender Checkbox with value: " + gender);
		customerInfoPage.checkToRadioButtonByLabel(driver, gender);

		log.info("CustomerInfo - Step 03: Update first name textbox with value: " + updateFirstName);
		customerInfoPage.inputToTextboxByLabel(driver, "First name", updateFirstName);

		log.info("CustomerInfo - Step 04: Update last name textbox with value: " + updateLastName);
		customerInfoPage.inputToTextboxByLabel(driver, "Last name", updateLastName);

		log.info("CustomerInfo - Step 05: Update date of birth dropdown with value: " + dateOfBirth + "/" + monthOfBirth + "/" + yearOfBirth);
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthDay", dateOfBirth);
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthMonth", monthOfBirth);
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthYear", yearOfBirth);

		log.info("CustomerInfo - Step 06: Update email textbox with value: " + updateEmail);
		customerInfoPage.inputToTextboxByLabel(driver, "Email", updateEmail);

		log.info("CustomerInfo - Step 07: Update company textbox with value: " + companyName);
		customerInfoPage.inputToTextboxByLabel(driver, "Company", companyName);

		log.info("CustomerInfo - Step 08: Click to Save button");
		customerInfoPage.clickToButtonByText(driver, "Save");

		log.info("CustomerInfo - Step 09: Verify gender checkbox is correctly displayed");
		verifyTrue(customerInfoPage.isCheckboxSelected(gender));

		log.info("CustomerInfo - Step 10: Verify first name textbox is correctly displayed");
		verifyEquals(customerInfoPage.getTextboxValueByLabel(driver, "First name"), updateFirstName);

		log.info("CustomerInfo - Step 11: Verify last name textbox is correctly displayed");
		verifyEquals(customerInfoPage.getTextboxValueByLabel(driver, "Last name"), updateLastName);

		log.info("CustomerInfo - Step 12: Verify date of birth dropdown is correctly displayed");
		verifyEquals(customerInfoPage.isDropdownSelected("DateOfBirthDay"), dateOfBirth);
		verifyEquals(customerInfoPage.isDropdownSelected("DateOfBirthMonth"), monthOfBirth);
		verifyEquals(customerInfoPage.isDropdownSelected("DateOfBirthYear"), yearOfBirth);

		log.info("CustomerInfo - Step 13: Verify email textbox is correctly displayed");
		verifyEquals(customerInfoPage.getTextboxValueByLabel(driver, "Email"), updateEmail);

		log.info("CustomerInfo - Step 14: Verify company name textbox is correctly displayed");
		verifyEquals(customerInfoPage.getTextboxValueByLabel(driver, "Company"), companyName);

		log.info("CustomerInfo - Step 15: Click to MyAccount link");
		customerInfoPage = registerPage.openMyAccountPage(driver);
	}

	@Test
	public void MyAccount_02_Addresses() {
		log.info("Addresses - Step 01: Open Addresses page");
		addressPage = customerInfoPage.openAddressPage(driver);

		log.info("Addresses - Step 02: Click to 'ADD NEW' button");
		addressPage.clickToButtonByText(driver, "Add new");

		log.info("Addresses - Step 03: Input to Firstname textbox with value: " + updateFirstName);
		addressPage.inputToTextboxByLabel(driver, "First name", updateFirstName);

		log.info("Addresses - Step 04: Input to Lastname textbox with value: " + updateLastName);
		addressPage.inputToTextboxByLabel(driver, "Last name", updateLastName);

		log.info("Addresses - Step 05: Input to Email textbox with value: " + updateEmail);
		addressPage.inputToTextboxByLabel(driver, "Email", updateEmail);

		log.info("Addresses - Step 06: Input to Company textbox with value: " + companyName);
		addressPage.inputToTextboxByLabel(driver, "Company", companyName);

		log.info("Addresses - Step 07: Select Country dropdown with value: " + country);
		addressPage.selectToDropdownByName(driver, "Address.CountryId", country);

		log.info("Addresses - Step 08: Select State/province dropdown with value: " + state);
		addressPage.selectToDropdownByName(driver, "Address.StateProvinceId", state);

		log.info("Addresses - Step 09: Input to City textbox with value: " + city);
		addressPage.inputToTextboxByLabel(driver, "City", city);

		log.info("Addresses - Step 10: Input to Address 1 textbox with value: " + address1);
		addressPage.inputToTextboxByLabel(driver, "Address 1", address1);

		log.info("Addresses - Step 11: Input to Address 2 textbox with value: " + address2);
		addressPage.inputToTextboxByLabel(driver, "Address 2", address2);

		log.info("Addresses - Step 12: Input to Zip/postal code textbox with value: " + zipCode);
		addressPage.inputToTextboxByLabel(driver, "Zip / postal code", zipCode);

		log.info("Addresses - Step 13: Input to Phone number textbox with value: " + phoneNumber);
		addressPage.inputToTextboxByLabel(driver, "Phone number", phoneNumber);

		log.info("Addresses - Step 14: Input to Fax number textbox with value: " + faxNumber);
		addressPage.inputToTextboxByLabel(driver, "Fax number", faxNumber);

		log.info("Addresses - Step 15: Click to SAVE button");
		addressPage.clickToButtonByText(driver, "Save");

		log.info("Addresses - Step 16: Verify fullname is correctly displayed");
		verifyEquals(addressPage.getTextValueByClassToVerifyAccInfo("name"), updateFirstName + " " + updateLastName);

		log.info("Addresses - Step 17: Verify email is correctly displayed");
		verifyTrue(addressPage.getTextValueByClassToVerifyAccInfo("email").contains(updateEmail));

		log.info("Addresses - Step 18: Verify Company is correctly displayed");
		verifyEquals(addressPage.getTextValueByClassToVerifyAccInfo("company"), companyName);

		log.info("Addresses - Step 19: Verify Country is correctly displayed");
		verifyEquals(addressPage.getTextValueByClassToVerifyAccInfo("country"), country);

		log.info("Addresses - Step 20: Verify State/province is correctly displayed");
		verifyTrue(addressPage.getTextValueByClassToVerifyAccInfo("city-state-zip").contains(state.equals("Other") ? "" : state));

		log.info("Addresses - Step 21: Verify City is correctly displayed");
		verifyTrue(addressPage.getTextValueByClassToVerifyAccInfo("city-state-zip").contains(city));

		log.info("Addresses - Step 22: Verify Address 1 is correctly displayed");
		verifyEquals(addressPage.getTextValueByClassToVerifyAccInfo("address1"), address1);

		log.info("Addresses - Step 23: Verify Address 2 is correctly displayed");
		verifyEquals(addressPage.getTextValueByClassToVerifyAccInfo("address2"), address2);

		log.info("Addresses - Step 24: Verify Zip/postal is correctly displayed");
		verifyTrue(addressPage.getTextValueByClassToVerifyAccInfo("city-state-zip").contains(zipCode));

		log.info("Addresses - Step 25: Verify phone number is correctly displayed");
		verifyTrue(addressPage.getTextValueByClassToVerifyAccInfo("phone").contains(phoneNumber));

		log.info("Addresses - Step 26: Verify fax number is correctly displayed");
		verifyTrue(addressPage.getTextValueByClassToVerifyAccInfo("fax").contains(faxNumber));

		log.info("Addresses - Step 27: Click to MyAccount link");
		customerInfoPage = registerPage.openMyAccountPage(driver);

	}

	@Test
	public void MyAccount_03_Change_Password() {
		log.info("ChangePassword - Step 01: Open Change password page");
		changePasswordPage = customerInfoPage.openChangePasswordPage(driver);

		log.info("ChangePassword - Step 02: Input to Old password textbox with value: " + password);
		changePasswordPage.inputToTextboxByLabel(driver, "Old password", password);

		log.info("ChangePassword - Step 03: Input to New password textbox with value: " + newPassword);
		changePasswordPage.inputToTextboxByLabel(driver, "New password", newPassword);

		log.info("ChangePassword - Step 04: Input to Confirm password textbox with value: " + newPassword);
		changePasswordPage.inputToTextboxByLabel(driver, "Confirm password", newPassword);

		log.info("ChangePassword - Step 05: Click to CHANGE PASSWORD button");
		changePasswordPage.clickToButtonByText(driver, "Change password");

		log.info("ChangePassword - Step 06: Verify change password success message is displayed");
		verifyTrue(changePasswordPage.isChangePasswordSuccessDisplayed());

		log.info("ChangePassword - Step 07: Click Alert Message close button");
		changePasswordPage.clickToCloseAlertButton();

		log.info("ChangePassword - Step 08: Click to Logout link");
		homePage = changePasswordPage.clickToLogoutAtUserPage(driver);

		log.info("ChangePassword - Step 09: Open Login page ");
		loginPage = homePage.openLoginPage();

		log.info("ChangePassword - Step 10: Input to email textbox with value: " + updateEmail);
		loginPage.inputToEmailTextbox(updateEmail);

		log.info("ChangePassword - Step 11: Input to password textbox with value: " + password);
		loginPage.inputToPasswordTextbox(password);

		log.info("ChangePassword - Step 12: Click to LOGIN button");
		loginPage.clickToLoginButton();

		log.info("ChangePassword - Step 13: Verify unsuccessful message is displayed");
		verifyEquals(loginPage.getUnSuccessfulLoginErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

		log.info("ChangePassword - Step 14: Input to email textbox with value: " + updateEmail);
		loginPage.inputToEmailTextbox(updateEmail);

		log.info("ChangePassword - Step 15: Input to password textbox with value: " + newPassword);
		loginPage.inputToPasswordTextbox(newPassword);

		log.info("ChangePassword - Step 16: Click to LOGIN button");
		homePage = loginPage.clickToLoginButton();

		log.info("ChangePassword - Step 17: Verify MyAccount link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("ChangePassword - Step 18: Click to MyAccount link");
		customerInfoPage = registerPage.openMyAccountPage(driver);

	}

	@Test
	public void MyAccount_04_My_Product_Reviews() {
		log.info("MyProductReviews - Step 01: Click to Desktops link in Computer menu");
		customerInfoPage.clickToLinkInMenuByText(driver, "Computers", "Desktops");
		productPage = PageGeneratorManager.getUserProductPage(driver);

		log.info("MyProductReviews - Step 02: Click to " + productName + " product");
		productPage.clickToProductByName(productName);

		log.info("MyProductReviews - Step 03: Click to ' Add your review' link");
		productPage.clickToAddYourReviewLink();

		log.info("MyProductReviews - Step 04: Input to Review title textbox with value: " + reviewTitle);
		productPage.inputToTextboxByLabel(driver, "Review title", reviewTitle);

		log.info("MyProductReviews - Step 05: Input to Review text textbox with value: " + reviewText);
		productPage.inputToReviewTextTextbox(reviewText);

		log.info("MyProductReviews - Step 06: Click to 'SUBMIT REVIEW' button");
		productPage.clickToButtonByText(driver, "Submit review");

		log.info("MyProductReviews - Step 07: Verify 'Product review is successfully added.' message is displayed");
		verifyTrue(productPage.isReviewSuccessfullyMessageDisplayed());

		log.info("MyProductReviews - Step 08: Click to MyAccount link");
		customerInfoPage = productPage.openMyAccountPage(driver);

		log.info("MyProductReviews - Step 09: Open My product reviews page");
		myProductReviewPage = customerInfoPage.openMyProductReviewPage(driver);

		log.info("MyProductReviews - Step 10: Verify product review is displayed");
		verifyEquals(myProductReviewPage.getReviewTitleAtReviewPage(), reviewTitle);
		verifyEquals(myProductReviewPage.getReviewTextAtReviewPage(), reviewText);
		verifyTrue(myProductReviewPage.isProductNameReviewCorrectlyDisplayed(productName));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
