package javaBasic;

import java.util.Scanner;

public class Topic_12_Exercise {
	Scanner scan = new Scanner(System.in);

	public void TC_01() {
		System.out.println("Nhập chuỗi: ");
		String string = scan.nextLine();
		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
				count++;
			}
			// System.out.println(count);
		}
		System.out.println("Số ký tự hoa trong chuỗi " + string + " là " + count);

	}

	public void TC_02() {
		String string = "Automation Testing 345 Tutorials Online 789";
		int count = 0;
		int countNumber = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == 'a' || string.charAt(i) == 'A') {
				count++;
			}

			if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
				countNumber++;
			}
		}
		System.out.println("Số lượng ký tự a là " + count);
		System.out.println("Chuỗi có chứa từ 'Testing' hay ko:" + string.contains("Testing"));
		System.out.println("Chuỗi có bắt đầu bằng 'Automation' hay ko: " + string.startsWith("Automation"));
		System.out.println("Chuỗi có kết thúc bằng 'Online' hay ko: " + string.endsWith("Online"));
		System.out.println("Vị trí của từ 'Tutorials' có trong chuỗi: " + string.indexOf("Tutorials"));
		System.out.println("Thay thế 'Online' bằng 'Offline': " + string.replace("Online", "Offline"));
		System.out.println("Số lượng ký tự là số có trong chuỗi là: " + countNumber);

	}

	public void TC_03() {
		System.out.print("Nhập chuỗi: ");
		String string = scan.nextLine();
		for (int i = string.length() - 1; i >= 0; i--) {
			System.out.print(string.charAt(i));
		}
		System.out.println();
	}
}
