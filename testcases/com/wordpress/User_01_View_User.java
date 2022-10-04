package com.wordpress;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminUserPO;
import pageObjects.wordpress.PageGeneratorManager;

public class User_01_View_User extends BaseTest {
	private WebDriver driver;
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminUserPO adminUserPage;

	private String adminUsername = "automationfc";
	private String adminPassword = "automationfc";

	@Parameters({ "browser", "adminUrl" })

	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		log.info("Pre-Condition - Step 01: Open browser and admin site");
		driver = getBrowserDriver(browserName, adminUrl);

		adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);

		log.info("Pre-Condition - Step 02: Enter to Username Textbox with value: " + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);

		log.info("Pre-Condition - Step 03: Enter to Password Textbox with value: " + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);

		log.info("Pre-Condition - Step 04: Click to Login Button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();

	}

	@Test
	public void TC_01_View_User() {
		log.info("ViewUser - Step 01: Click to User Menu Link");
		adminUserPage = adminDashboardPage.clickToUserMenu();

		log.info("ViewUser - Step 02: Get all users from UI");
		int totalNumberUserAtUI = adminUserPage.getUserNumberAtUI();

		log.info("ViewUser - Step 03: Get all users from DB");
		int totalNumberUserAtDB = adminUserPage.getUserNumberAtDB();

		log.info("ViewUser - Step 04: Verify user number are matching");
		verifyEquals(totalNumberUserAtUI, totalNumberUserAtDB);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
