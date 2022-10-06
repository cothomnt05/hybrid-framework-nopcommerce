package pageUIs.nopcommerce.user;

public class ProductPageUI {
	public static final String DYNAMIC_PRODUCT_BY_TEXT_NAME = "xpath=//h2[@class='product-title']/a[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_TITLE_UI = "xpath=//span[contains(text(),'%s')]/following-sibling::select";
	public static final String DYNAMIC_PAGE_NUMBER = "xpath=//li[@class='individual-page']/a[text()='%s']";

	public static final String ADD_REVIEW_LINK = "xpath=//div[@class='product-review-links']/a[text()='Add your review']";
	public static final String REVIEW_SUCCESSFULLY_MESSAGE = "xpath=//div[@class='result' and contains(text(),'Product review is successfully added.')]";
	public static final String REVIEW_TEXT_TEXTBOX = "xpath=//label[contains(text(),'Review text')]/following-sibling::textarea";

	public static final String LIST_ITEM = "xpath=//div[@class='product-item']";
	public static final String LIST_ITEM_NAME = "xpath=//div[@class='product-item']//h2[@class='product-title']/a";
	public static final String LIST_ITEM_PRICE = "xpath=//div[@class='product-item']//span[contains(@class,'price')]";
	public static final String NEXT_PAGING_ICON = "xpath=//li[@class='next-page']";
	public static final String PREVIOUS_PAGING_ICON = "xpath=//li[@class='previous-page']";
	public static final String PAGE_NUMBER = "xpath=//li[@class='current-page']/span";
	public static final String PAGER = "xpath=//div[@class='pager']";

}
