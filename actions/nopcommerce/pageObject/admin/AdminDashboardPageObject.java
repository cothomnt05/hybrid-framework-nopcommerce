package nopcommerce.pageObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopcommerce.pageUIs.admin.AdminDashBoardPageUI;

public class AdminDashboardPageObject extends BasePage {
	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashBoardPageDisplayed() {
		return isElementDisplayed(driver, AdminDashBoardPageUI.DASHBOARD_HEADER);
	}
}
