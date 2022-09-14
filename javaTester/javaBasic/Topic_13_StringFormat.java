package javaBasic;

public class Topic_13_StringFormat {
	public static String CUSTOMER_INFO_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text() = 'Customer info']";
	public static String ADDRESS_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text() = 'Addresses']";
	public static String ORDER_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text() = 'Orders']";
	public static String DOWNLOADABLE_PRODUCT_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text() = 'Downloadable products']";
	public static String BACK_IN_STOCK_SUBSCRIPTION_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text() = 'Back in stock subscriptions']";
	public static String REWARD_POINT_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text() = 'Reward points']";
	public static String CHANGE_PASSWORD_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text() = 'Change password']";
	public static String MY_PRODUCT_REVIEW_LINK = "xpath=//div[contains(@class,'block-account-navigation')]//a[text() = 'My product reviews']";

	public static String DYNAMIC_LINK_TEXT = "xpath=//div[contains(@class,'block-account-navigation')]//a[text() = '%s']";
	public static String DYNAMIC_LINK_PAGE_NAME = "xpath=//div[contains(@class,'%s')]//a[text() = '%s']";

	public static void main(String args[]) {
		clickToLink(DYNAMIC_LINK_TEXT, "block-account-navigation", "Customer info");
		clickToLink(DYNAMIC_LINK_PAGE_NAME, "footer", "Orders");
		clickToLink(DYNAMIC_LINK_TEXT, "Addresses");
		clickToLink(DYNAMIC_LINK_TEXT, "Downloadable products");
		clickToLink(DYNAMIC_LINK_TEXT, "Back in stock subscriptions");
		clickToLink(DYNAMIC_LINK_TEXT, "Reward points");
	}

	// public static void clickToLink(String locator) {
	// System.out.println("Click to: " + locator);
	// }
	//
	// public static void clickToLink(String dynamicLocator, String pageName) {
	// String locator = String.format(dynamicLocator, pageName);
	// System.out.println("Click to: " + locator);
	// }

	public static void clickToLink(String dynamicLocator, String... params) {
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("Click to: " + locator);
	}
}
