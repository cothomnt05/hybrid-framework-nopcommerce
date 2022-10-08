package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.CompareProductPageUI;

public class UserCompareProductPageObject extends BasePage {
	WebDriver driver;

	public UserCompareProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProductDisplayedByProductName(String productName) {
		return isElementDisplayed(driver, CompareProductPageUI.DYNAMIC_PRODUCT_NAME, productName);
	}

	public boolean isCompareEmptyMessageDisplayed() {
		waitForElementVisible(driver, CompareProductPageUI.COMPARE_PRODUCT_EMPTY_MESSAGE);
		return isElementDisplayed(driver, CompareProductPageUI.COMPARE_PRODUCT_EMPTY_MESSAGE);
	}

	public void clickToClearList() {
		waitForElementClickable(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, CompareProductPageUI.CLEAR_LIST_BUTTON);
	}
}
