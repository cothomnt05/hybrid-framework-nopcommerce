package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.ChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage {
	WebDriver driver;

	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isChangePasswordSuccessDisplayed() {
		waitForElementVisible(driver, ChangePasswordPageUI.PASSWORD_WAS_CHANGED_MESSAGE);
		return isElementDisplayed(driver, ChangePasswordPageUI.PASSWORD_WAS_CHANGED_MESSAGE);

	}

	public void clickToCloseAlertButton() {
		waitForElementClickable(driver, ChangePasswordPageUI.CLOSE_ALERT_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CLOSE_ALERT_BUTTON);
	}
}
