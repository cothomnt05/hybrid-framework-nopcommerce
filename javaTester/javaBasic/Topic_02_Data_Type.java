package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
	// Primitive type/ value type: nguyên thuỷ
	byte bNumber = 6;
	short sNumber = 1500;
	int iNumber = 65000;
	long lNumber = 65000;
	float fNumber = 15.98f;
	double dNumber = 15.98d;
	char cChar = '1';
	boolean bStatus = true;

	// Reference type: tham chiếu
	// String
	String address = "Ho Chi Minh";

	// Array
	String[] studentAddress = { "Ha Noi", "Da Nang", address };
	Integer[] studentNumber = { 15, 20, 50 };

	// Class
	Topic_02_Data_Type topic;

	// Interface
	WebDriver driver;

	// Object
	Object aObject;

	// Collection
	// List/ Set/ Queue/ Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a")); // có thể lưu trùng
	Set<String> allWindows = driver.getWindowHandles();// ko lưu trùng

	List<String> productName = new ArrayList<String>();

	public void clickElement() {
		address.trim();

		studentAddress.clone();

		driver.getCurrentUrl();

		aObject.toString();

		homePageLinks.size();

		allWindows.clear();

		Topic_02_Data_Type topic = new Topic_02_Data_Type();

		topic.address = "Ha Noi";
	}

	public static void main(String[] args) {

	}

}
