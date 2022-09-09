package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_Exercise {
	Scanner scan = new Scanner(System.in);

	public void TC_01() {
		System.out.print("Nhập n: ");
		int n = scan.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void TC_02() {
		int a, b;
		System.out.println("Nhập a,b: ");
		a = scan.nextInt();
		b = scan.nextInt();

		for (int i = a; i <= b; i++) {
			System.out.print(i + " ");
		}

		System.out.println();
	}

	public void TC_03() {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("Tổng số chẵn từ 1 đến 10 bằng " + sum);
	}

	public void TC_04() {
		int a, b;
		System.out.print("Nhập a,b: ");
		a = scan.nextInt();
		b = scan.nextInt();

		int sum = 0;
		for (int i = a; i <= b; i++) {
			sum += i;
		}
		System.out.println("Tổng các số từ " + a + " đến " + b + " là " + sum);
	}

	public void TC_05() {
		System.out.print("Nhập n: ");
		int n = scan.nextInt();
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		}

		System.out.println("Tổng các số từ 0 đến " + n + " là " + sum);
	}

	public void TC_06() {
		int a, b;
		System.out.print("Nhập a, b: ");
		a = scan.nextInt();
		b = scan.nextInt();
		for (int i = a; i <= b; i++) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	@Test
	public void TC_07() {
		System.out.print("Nhập n: ");
		int n = scan.nextInt();

		int giaithua = 1;

		for (int i = 1; i <= n; i++) {
			giaithua *= i;
		}

		System.out.println("Giai thừa của " + n + " là " + giaithua);
	}
}
