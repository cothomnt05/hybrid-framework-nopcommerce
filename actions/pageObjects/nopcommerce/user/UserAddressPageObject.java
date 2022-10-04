package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.AddressPageUI;

public class UserAddressPageObject extends BasePage {
	WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextValueByClassToVerifyAccInfo(String className) {
		waitForElementVisible(driver, AddressPageUI.DYNAMIC_TEXT_BY_CLASS_TO_VERIFY_ACCOUNT_INFO, className);
		return getElementText(driver, AddressPageUI.DYNAMIC_TEXT_BY_CLASS_TO_VERIFY_ACCOUNT_INFO, className);
	}
}
