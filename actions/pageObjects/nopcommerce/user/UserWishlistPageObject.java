package pageObjects.nopcommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.user.WishListPageUI;

public class UserWishlistPageObject extends BasePage {
	WebDriver driver;

	public UserWishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToWishListURL() {
		waitForElementClickable(driver, WishListPageUI.WISHLIST_SHARE_LINK);
		clickToElement(driver, WishListPageUI.WISHLIST_SHARE_LINK);

	}

	public String getTitleWishListShareProduct() {
		waitForElementVisible(driver, WishListPageUI.TITLE_WISH_LIST_SHARE);
		return getElementText(driver, WishListPageUI.TITLE_WISH_LIST_SHARE);
	}

	public boolean isEmptyListMessageDisplayed() {
		waitForElementVisible(driver, WishListPageUI.WISHLIST_EMPTY_MESSAGE);
		return isElementDisplayed(driver, WishListPageUI.WISHLIST_EMPTY_MESSAGE);
	}
}
