package pageUIs.nopcommerce.user;

public class ProductPageUI {
	public static final String DYNAMIC_PRODUCT_BY_TEXT_NAME = "xpath=//h2[@class='product-title']/a[text()='%s']";
	public static final String ADD_REVIEW_LINK = "xpath=//div[@class='product-review-links']/a[text()='Add your review']";
	public static final String REVIEW_SUCCESSFULLY_MESSAGE = "xpath=//div[@class='result' and contains(text(),'Product review is successfully added.')]";
	public static final String REVIEW_TEXT_TEXTBOX = "xpath=//label[contains(text(),'Review text')]/following-sibling::textarea";
}
