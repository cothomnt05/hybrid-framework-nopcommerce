package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_Exercise {
	Scanner scan = new Scanner(System.in);

	public void TC_01() {
		System.out.print("Nhập số từ 1-10: ");
		int n = scan.nextInt();
		switch (n) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;
		case 10:
			System.out.println("Ten");
			break;

		default:
			System.out.println("Bạn phải nhập số từ 1-10");
			break;
		}
	}

	@Test
	public void TC_02() {
		System.out.print("Nhập số a,b: ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.print("Nhập phép toán: ");
		String math = scan.next();

		switch (math) {
		case "+":
			System.out.println(a + " + " + b + " = " + (a + b));
			break;
		case "-":
			System.out.println(a + " - " + b + " = " + (a - b));
			break;
		case "*":
			System.out.println(a + " * " + b + " = " + (a * b));
			break;
		case "/":
			System.out.println(a + " / " + b + " = " + (a / (float)b));
			break;
		case "%":
			System.out.println(a + " % " + b + " = " + (a % b));
			break;

		default:
			System.out.println("Nhập sai phép toán(+, -, *, /, %)");
			break;
		}
	}

	public void TC_03() {
		int month;
		System.out.println("Nhập tháng: ");
		month = scan.nextInt();

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.print("Số ngày trong tháng" + month + " là 31");
			break;

		case 4:
		case 6:
		case 9:
		case 11:
			System.out.print("Số ngày trong tháng" + month + " là 30");
			break;
		case 2:
			System.out.print("Số ngày trong tháng" + month + " là 28");
			break;

		default:
			System.out.println("Nhập lại tháng từ 1-12");
			break;
		}
	}
}
