package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.CustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInfoPageIsDisplayed() {
		waitForElementVisible(driver, CustomerInfoPageUI.MY_ACCOUNT_HEADER);
		return isElementDisplayed(driver, CustomerInfoPageUI.MY_ACCOUNT_HEADER);
	}

}
