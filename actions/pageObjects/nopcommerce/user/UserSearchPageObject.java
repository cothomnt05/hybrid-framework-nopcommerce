package pageObjects.nopcommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopcommerce.user.SearchPageUI;

public class UserSearchPageObject extends BasePage {
	WebDriver driver;

	public UserSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}

	public String getSearchLengthWarningMessage() {
		waitForElementVisible(driver, SearchPageUI.WARNING_SEARCH_LENGTH_MESSAGE);
		return getElementText(driver, SearchPageUI.WARNING_SEARCH_LENGTH_MESSAGE);
	}

	public boolean isNoResultsMessageDisplayed() {
		waitForElementVisible(driver, SearchPageUI.NO_RESULTS_MESSAGE);
		return isElementDisplayed(driver, SearchPageUI.NO_RESULTS_MESSAGE);
	}

	public int getProductNumberSearchBySearchKeyword(String searchKeyword) {
		List<WebElement> elements = getListWebElement(driver, SearchPageUI.DYNAMIC_PRODUCT_BY_SEARCH_KEYWORD, searchKeyword);

		return elements.size();
	}

	public void checkToCheckboxByLabel(String labelName) {
		waitForElementClickable(driver, SearchPageUI.DYNAMIC_SEARCH_CHECKBOX_BY_LABEL, labelName);
		checkToDefaultCheckboxRadio(driver, SearchPageUI.DYNAMIC_SEARCH_CHECKBOX_BY_LABEL, labelName);
	}

	public void selectItemInDropdownByLabel(String labelName, String valueText) {
		waitForElementVisible(driver, SearchPageUI.DYNAMIC_SEARCH_DROPDOWN_BY_LABEL_NAME, labelName);
		selectItemInDefaultDropdown(driver, SearchPageUI.DYNAMIC_SEARCH_DROPDOWN_BY_LABEL_NAME, valueText, labelName);

	}

	public void unCheckToCheckboxByLabel(String labelName) {
		waitForElementClickable(driver, SearchPageUI.DYNAMIC_SEARCH_CHECKBOX_BY_LABEL, labelName);
		uncheckToDefaultCheckbox(driver, SearchPageUI.DYNAMIC_SEARCH_CHECKBOX_BY_LABEL, labelName);
	}
}
