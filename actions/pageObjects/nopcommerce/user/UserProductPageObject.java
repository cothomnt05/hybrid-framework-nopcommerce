package pageObjects.nopcommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	public void selectItemSortInDropdown(String titleUI, String selectItem) {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_DROPDOWN_BY_TITLE_UI, titleUI);
		selectItemInDefaultDropdown(driver, ProductPageUI.DYNAMIC_DROPDOWN_BY_TITLE_UI, selectItem, titleUI);

	}

	public boolean isListItemSortedAscByName() {
		ArrayList<String> arrayList = new ArrayList<>();
		List<WebElement> elements = getListWebElement(driver, ProductPageUI.LIST_ITEM_NAME);

		for (WebElement element : elements) {
			arrayList.add(element.getText());
		}

		ArrayList<String> sortedList = new ArrayList<>();

		for (String item : arrayList) {
			sortedList.add(item);
		}

		Collections.sort(sortedList);
		return sortedList.equals(sortedList);
	}

	public boolean isListItemSortedDescByName() {
		ArrayList<String> arrayList = new ArrayList<>();
		List<WebElement> elements = getListWebElement(driver, ProductPageUI.LIST_ITEM_NAME);

		for (WebElement element : elements) {
			arrayList.add(element.getText());
		}

		ArrayList<String> sortedList = new ArrayList<>();

		for (String item : arrayList) {
			sortedList.add(item);
		}

		Collections.sort(sortedList);
		Collections.reverse(sortedList);
		return sortedList.equals(sortedList);
	}

	public boolean isListItemSortedAscByPrice() {
		ArrayList<Float> arrayList = new ArrayList<>();
		List<WebElement> elements = getListWebElement(driver, ProductPageUI.LIST_ITEM_PRICE);

		for (WebElement element : elements) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "")));
		}

		ArrayList<Float> sortedList = new ArrayList<>();

		for (Float item : arrayList) {
			sortedList.add(item);
		}

		Collections.sort(sortedList);
		return sortedList.equals(sortedList);
	}

	public boolean isListItemSortedDescByPrice() {
		ArrayList<Float> arrayList = new ArrayList<>();
		List<WebElement> elements = getListWebElement(driver, ProductPageUI.LIST_ITEM_PRICE);

		for (WebElement element : elements) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "")));
		}

		ArrayList<Float> sortedList = new ArrayList<>();

		for (Float item : arrayList) {
			sortedList.add(item);
		}

		Collections.sort(sortedList);
		Collections.reverse(sortedList);
		return sortedList.equals(sortedList);
	}

	public boolean isItemNumberAtMostNumberProductsDisplayed(int numberProduct) {
		List<WebElement> elements = getListWebElement(driver, ProductPageUI.LIST_ITEM);
		System.out.println("element size " + elements.size() + " number Product " + numberProduct);
		return elements.size() <= numberProduct;
	}

	public String getCurrentPageNumber() {
		waitForElementVisible(driver, ProductPageUI.PAGE_NUMBER);
		System.out.println("current Page " + getElementText(driver, ProductPageUI.PAGE_NUMBER));
		return getElementText(driver, ProductPageUI.PAGE_NUMBER);
	}

	public void pagingToNumberPage(String pageNumber) {
		waitForElementClickable(driver, ProductPageUI.DYNAMIC_PAGE_NUMBER, pageNumber);
		clickToElement(driver, ProductPageUI.DYNAMIC_PAGE_NUMBER, pageNumber);
	}

	public boolean isNextPagingIconDisplayedAtPage1() {
		waitForElementVisible(driver, ProductPageUI.NEXT_PAGING_ICON);
		return isElementDisplayed(driver, ProductPageUI.NEXT_PAGING_ICON);
	}

	public boolean isPreviousPagingIconDisplayedAtPage2() {
		waitForElementVisible(driver, ProductPageUI.PREVIOUS_PAGING_ICON);
		return isElementDisplayed(driver, ProductPageUI.PREVIOUS_PAGING_ICON);
	}

	public boolean isPagingIconNotDisplayed() {
		waitForElementInVisible(driver, ProductPageUI.PAGER);
		return isElementUndisplayed(driver, ProductPageUI.PAGER);
	}

}
