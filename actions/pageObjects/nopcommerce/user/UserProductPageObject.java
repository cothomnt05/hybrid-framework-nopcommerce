package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.ProductPageUI;

public class UserProductPageObject extends BasePage {
	WebDriver driver;

	public UserProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToProductByName(String productName) {
		waitForElementClickable(driver, ProductPageUI.DYNAMIC_PRODUCT_BY_TEXT_NAME, productName);
		clickToElement(driver, ProductPageUI.DYNAMIC_PRODUCT_BY_TEXT_NAME, productName);

	}

	public void clickToAddYourReviewLink() {
		waitForElementClickable(driver, ProductPageUI.ADD_REVIEW_LINK);
		clickToElement(driver, ProductPageUI.ADD_REVIEW_LINK);
	}

	public boolean isReviewSuccessfullyMessageDisplayed() {
		waitForElementVisible(driver, ProductPageUI.REVIEW_SUCCESSFULLY_MESSAGE);
		return isElementDisplayed(driver, ProductPageUI.REVIEW_SUCCESSFULLY_MESSAGE);
	}

	public void inputToReviewTextTextbox(String reviewText) {
		waitForElementVisible(driver, ProductPageUI.REVIEW_TEXT_TEXTBOX);
		sendkeyToElement(driver, ProductPageUI.REVIEW_TEXT_TEXTBOX, reviewText);
	}
}
