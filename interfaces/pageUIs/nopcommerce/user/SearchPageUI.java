package pageUIs.nopcommerce.user;

public class SearchPageUI {
	public static final String DYNAMIC_SEARCH_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/preceding-sibling::input";
	public static final String DYNAMIC_SEARCH_DROPDOWN_BY_LABEL_NAME = "xpath=//label[contains(text(),'%s')]/following-sibling::select";
	public static final String DYNAMIC_PRODUCT_BY_SEARCH_KEYWORD = "xpath=//a[contains(text(),'%s')]";

	public static final String SEARCH_BUTTON = "xpath=//div[@class='search-input']//button[text()='Search']";
	public static final String WARNING_SEARCH_LENGTH_MESSAGE = "xpath=//div[@class='warning']";
	public static final String NO_RESULTS_MESSAGE = "xpath=//div[@class='no-result' and text() = 'No products were found that matched your criteria.']";

}
