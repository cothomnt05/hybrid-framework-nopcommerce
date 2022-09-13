package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInfoPageIsDisplayed() {
		waitForElementVisible(driver, CustomerInfoPageUI.MY_ACCOUNT_HEADER);
		return isElementDisplayed(driver, CustomerInfoPageUI.MY_ACCOUNT_HEADER);
	}

}
