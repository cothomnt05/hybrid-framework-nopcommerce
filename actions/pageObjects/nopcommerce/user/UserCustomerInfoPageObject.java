package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopcommerce.user.CustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify Customer infor page is displayed")
	public boolean isCustomerInfoPageIsDisplayed() {
		waitForElementVisible(driver, CustomerInfoPageUI.MY_ACCOUNT_HEADER);
		return isElementDisplayed(driver, CustomerInfoPageUI.MY_ACCOUNT_HEADER);
	}

	public boolean isCheckboxSelected(String gender) {
		waitForElementVisible(driver, CustomerInfoPageUI.DYNAMIC_RADIO_CHECKBOX_GENDER, gender);
		return isElementSelected(driver, CustomerInfoPageUI.DYNAMIC_RADIO_CHECKBOX_GENDER, gender);
	}

	public String isDropdownSelected(String dropdownName) {
		waitForElementVisible(driver, CustomerInfoPageUI.DYNAMIC_DROPDOWN_DAY, dropdownName);
		return getSelectedItemInDefaultDropdown(driver, CustomerInfoPageUI.DYNAMIC_DROPDOWN_DAY, dropdownName);
	}

}
