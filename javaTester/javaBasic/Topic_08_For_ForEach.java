package javaBasic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_08_For_ForEach {
	WebDriver driver;

	public void TC_01() {
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}

		// Array
		String[] cityNames = { "Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho" };
		// biến điếm điều kiện dùng để filter
		for (int i = 0; i < cityNames.length; i++) {
			if (cityNames[i].equals("Da Nang")) {
				System.out.println("Do action!");
				break;
			}
		}

		// dùng để chạy qua hết tất cả các giá trị
		for (String cityName : cityNames) {
			System.out.println(cityName);
		}
	}

	@Test
	public void TC_02() {
		// Array
		String[] cityName = { "Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho", "Hai Phong", "Khanh Hoa" };

		// Java Collection
		// Class: ArrayList/ LinkedList/ Vector/...
		// Interface: List/ Set/ Queue
		List<String> cityAddress = new ArrayList<String>();
		System.out.println(cityAddress.size());

		// Compile(Coding)
		cityAddress.add("Bac Giang");
		cityAddress.add("Ha Giang");
		cityAddress.add("Sapa");

		System.out.println(cityAddress.size());

		// Runtime
		for (String city : cityName) {
			cityAddress.add(city);
		}

		System.out.println(cityAddress.size());

		for (String cityAdd : cityAddress) {
			System.out.println(cityAdd);
		}

		// Java Generic
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		for (WebElement link : links) {
			// Chuyển page
			// Refresh DOM/HTML
			// ko còn tồn tại
			// Fail -> staleElementException
		}
	}
}
