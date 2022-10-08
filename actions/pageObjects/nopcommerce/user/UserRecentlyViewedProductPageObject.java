package pageObjects.nopcommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopcommerce.user.RecentlyViewedProductPageUI;

public class UserRecentlyViewedProductPageObject extends BasePage {
	WebDriver driver;

	public UserRecentlyViewedProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public int getNumberProductDisplayed() {
		List<WebElement> elements = getListWebElement(driver, RecentlyViewedProductPageUI.PRODUCT_NUMBER);
		return elements.size();
	}

	public boolean isProductDisplayedByProductName(String productName) {
		waitForElementVisible(driver, RecentlyViewedProductPageUI.DYNAMIC_PRODUCT_TITLE, productName);
		return isElementDisplayed(driver, RecentlyViewedProductPageUI.DYNAMIC_PRODUCT_TITLE, productName);
	}
}
