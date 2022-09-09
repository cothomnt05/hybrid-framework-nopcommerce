package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_04_Exercise {
	Scanner scan = new Scanner(System.in);

	public void TC_01() {
		System.out.print("name = ");
		String name = scan.nextLine();
		System.out.print("age = ");
		int age = scan.nextInt();
		System.out.println("After 15 years, age of " + name + " will be " + (age + 15));
	}

	public void TC_02() {
		int a, b;
		System.out.print("a = ");
		a = scan.nextInt();
		System.out.print("b = ");
		b = scan.nextInt();
		// a = 5, b = 3 => a + b = 8 => b = 8 - b => a = 8 - b
		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println("After swapping then a = " + a + ", b = " + b);
	}

	@Test
	public void TC_03() {
		int a, b;
		System.out.print("a = ");
		a = scan.nextInt();
		System.out.print("b = ");
		b = scan.nextInt();

		if (a > b) {
			System.out.println("a > b -> " + "true");
		} else {
			System.out.println("a > b -> " + "false");
		}
	}
}
