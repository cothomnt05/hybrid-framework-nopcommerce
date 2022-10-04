package pageUIs.nopcommerce.user;

public class CustomerInfoPageUI {
	public static final String MY_ACCOUNT_HEADER = "xpath=//div[@class = 'page-title']/h1[text()='My account - Customer info']";

	public static final String DYNAMIC_RADIO_CHECKBOX_GENDER = "xpath=//label[contains(text(),'%s')]/preceding-sibling::input";
	public static final String DYNAMIC_DROPDOWN_DAY = "xpath=//select[@name='%s']";
}
