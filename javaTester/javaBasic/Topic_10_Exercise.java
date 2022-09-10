package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_10_Exercise {
	Scanner scan = new Scanner(System.in);

	public void TC_01() {
		System.out.println("Nhập tên trình duyệt: ");
		String browser = scan.next();

		String[] browserNames = { "Chrome", "Firefox", "Opera", "Safari", "IE", "Edge" };

		for (String browserName : browserNames) {
			if (browserName.equals(browser)) {
				if (browserName.equals("IE")) {
					continue;
				}
				System.out.println("Trình duyệt " + browserName);
			}
		}
		System.out.println("Done");

	}

	@Test
	public void TC_02() {
		System.out.print("Nhập tháng: ");
		int month = scan.nextInt();

		switch (month) {
		case 1:
			System.out.println("JAN");
			break;
		case 2:
			System.out.println("FEB");
			break;
		case 3:
			System.out.println("MAR");
			break;
		case 4:
			System.out.println("APR");
			break;
		case 5:
			System.out.println("MAY");
			break;
		case 6:
			System.out.println("JUN");
			break;
		case 7:
			System.out.println("JUL");
			break;
		case 8:
			System.out.println("AUG");
			break;
		case 9:
			System.out.println("SEP");
			break;
		case 10:
			System.out.println("OCT");
			break;
		case 11:
			System.out.println("NOV");
			break;
		case 12:
			System.out.println("DEV");
			break;

		default:
			System.out.println("Nhập sai");
			break;
		}
	}
}
