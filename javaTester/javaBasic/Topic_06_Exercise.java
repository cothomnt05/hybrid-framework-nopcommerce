package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_06_Exercise {
	Scanner scan = new Scanner(System.in);

	public void TC_01() {
		System.out.print("n = ");
		int n = scan.nextInt();

		if (n % 2 == 0) {
			System.out.println(n + " là số chẵn");
		} else {
			System.out.println(n + " là số lẻ");
		}
	}

	public void TC_02() {
		int a, b;
		System.out.print("a = ");
		a = scan.nextInt();
		System.out.print("b = ");
		b = scan.nextInt();

		if (a >= b) {
			System.out.println(a + " lớn hơn hoặc bằng " + b);
		} else {
			System.out.println(a + " nhỏ hơn " + b);
		}

	}

	public void TC_03() {
		String a, b;
		System.out.print("Tên người thứ nhất: ");
		a = scan.next();
		System.out.print("Tên người thứ hai: ");
		b = scan.next();
		if (a.equalsIgnoreCase(b)) {
			System.out.println("2 người là cùng tên");
		} else {
			System.out.println("2 người là khác tên");
		}
	}

	public void TC_04() {
		int a, b, c;
		System.out.println("Hãy nhập 3 số nguyên: ");
		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();
		if (a > b && a > c) {
			System.out.println("Số lớn nhất là " + a);
		} else if (b > a && b > c) {
			System.out.println("Số lớn nhất là " + b);
		} else {
			System.out.println("Số lớn nhất là " + c);
		}
	}

	public void TC_05() {
		int a;
		System.out.print("a = ");
		a = scan.nextInt();
		if (a > 10 && a < 100) {
			System.out.println("a nằm trong [10,100]");
		} else {
			System.out.println("a không nằm trong [10,100]");
		}
	}

	public void TC_06() {
		double diem;
		System.out.println("Hãy nhập điểm: ");
		diem = scan.nextDouble();

		if (diem < 5) {
			System.out.println("Điểm D");
		} else if (diem >= 5 && diem < 7.5) {
			System.out.println("Điểm C");
		} else if (diem >= 7.5 && diem < 8.5) {
			System.out.println("Điểm B");
		} else if (diem >= 8.5) {
			System.out.println("Điểm A");
		} else {
			System.out.println("Hãy nhập lại điểm");
		}
	}

	@Test
	public void TC_07() {
		int month;
		System.out.println("Nhập tháng: ");
		month = scan.nextInt();

		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			System.out.println("Số ngày trong tháng" + month + " là 31");
		} else if (month == 2) {
			System.out.println("Số ngày trong tháng" + month + " là 28");
		} else {
			System.out.println("Số ngày trong tháng" + month + " là 30");
		}
	}

}
