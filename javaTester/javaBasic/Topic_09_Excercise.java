package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_Excercise {
	Scanner scan = new Scanner(System.in);

	public void TC_01() {
		System.out.print("Nhập n: ");
		int n = scan.nextInt();
		System.out.println("Số chẵn từ " + n + " đến 100: ");
		while (n <= 100) {
			if (n % 2 == 0) {
				System.out.print(n + " ");
			}
			n++;
		}
		System.out.println();

	}

	public void TC_02() {
		int a, b;
		System.out.print("Nhập số a,b: ");
		a = scan.nextInt();
		b = scan.nextInt();
		System.out.println("Số chia hết cho cả 3 và 5 từ " + a + " đến " + b + ": ");
		while (a <= b) {
			if (a % 3 == 0 && a % 5 == 0) {
				System.out.print(a + " ");
			}

			a++;
		}
		System.out.println();
	}

	public void TC_03() {
		System.out.print("Nhập n: ");
		int n = scan.nextInt();

		int i = 0, sum = 0;
		while (i <= n) {
			if (i % 2 != 0) {
				sum += i;
			}
			i++;
		}
		System.out.println("Tổng các số lẻ từ 0 đến " + n + " là: " + sum);
	}

	public void TC_04() {
		int a, b;
		System.out.print("Nhập a,b: ");
		a = scan.nextInt();
		b = scan.nextInt();
		System.out.println("Số chia hết cho 3 từ " + a + " đến " + b + ":");
		while (a <= b) {
			if (a % 3 == 0) {
				System.out.print(a + " ");
			}
			a++;
		}
		System.out.println();
	}

	public void TC_05() {
		System.out.print("Nhập n: ");
		int n = scan.nextInt();
		int i = 1, giaithua = 1;
		while (i <= n) {
			giaithua *= i;
			i++;
		}

		System.out.println("Giai thừa của " + n + " là: " + giaithua);
	}

	@Test
	public void TC_06() {
		int i = 1, sum = 0;
		while (i <= 10) {
			if (i % 2 == 0) {
				sum += i;
			}
			i++;
		}

		System.out.println("Tổng các số chẵn từ 1 đến 10 là " + sum);
	}
}
