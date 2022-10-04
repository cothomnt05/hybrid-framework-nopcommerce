package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.MyProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage {
	WebDriver driver;

	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getReviewTitleAtReviewPage() {
		waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_TITLE_AT_PAGE_REVIEW);
		return getElementText(driver, MyProductReviewPageUI.REVIEW_TITLE_AT_PAGE_REVIEW);
	}

	public String getReviewTextAtReviewPage() {
		waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_TEXT_AT_PAGE_REVIEW);
		return getElementText(driver, MyProductReviewPageUI.REVIEW_TEXT_AT_PAGE_REVIEW);
	}

	public boolean isProductNameReviewCorrectlyDisplayed(String productName) {
		waitForElementVisible(driver, MyProductReviewPageUI.DYNAMIC_PRODUCT_NAME_REVIEW_BY_TEXT_NAME, productName);
		return isElementDisplayed(driver, MyProductReviewPageUI.DYNAMIC_PRODUCT_NAME_REVIEW_BY_TEXT_NAME, productName);
	}
}
