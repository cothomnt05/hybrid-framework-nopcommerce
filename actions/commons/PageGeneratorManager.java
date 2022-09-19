package commons;

import org.openqa.selenium.WebDriver;

import nopcommerce.pageObject.admin.AdminDashboardPageObject;
import nopcommerce.pageObject.admin.AdminLoginPageObject;
import nopcommercepageObjects.user.UserAddressPageObject;
import nopcommercepageObjects.user.UserBackInStockSubscriptionPageObject;
import nopcommercepageObjects.user.UserChangePasswordPageObject;
import nopcommercepageObjects.user.UserCustomerInfoPageObject;
import nopcommercepageObjects.user.UserDownloadableProductPageObject;
import nopcommercepageObjects.user.UserHomePageObject;
import nopcommercepageObjects.user.UserLoginPageObject;
import nopcommercepageObjects.user.UserMyProductReviewPageObject;
import nopcommercepageObjects.user.UserOrderPageObject;
import nopcommercepageObjects.user.UserRegisterPageObject;
import nopcommercepageObjects.user.UserRewardPointPageObject;

public class PageGeneratorManager {
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserCustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObject(driver);
	}

	public static UserAddressPageObject getAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}

	public static UserOrderPageObject getOrderPage(WebDriver driver) {
		return new UserOrderPageObject(driver);
	}

	public static UserDownloadableProductPageObject getDownloadableProductPage(WebDriver driver) {
		return new UserDownloadableProductPageObject(driver);
	}

	public static UserBackInStockSubscriptionPageObject getBackInStockSubscriptionPage(WebDriver driver) {
		return new UserBackInStockSubscriptionPageObject(driver);
	}

	public static UserRewardPointPageObject getRewardPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}

	public static UserChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}

	public static UserMyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
}
