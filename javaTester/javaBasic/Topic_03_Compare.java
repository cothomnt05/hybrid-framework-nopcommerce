package javaBasic;

public class Topic_03_Compare {
	int number = 8;

	public static void main(String[] args) {
		// 1 vùng nhớ cho biến x
		int x = 5;

		// 1 vùng nhớ cho biến y
		int y = x;

		System.out.println("x = " + x);
		System.out.println("y = " + y);

		x = 3;
		System.out.println("x = " + x);
		System.out.println("y = " + y);

		y = 10;

		System.out.println("x = " + x);
		System.out.println("y = " + y);

		Topic_03_Compare firstVariable = new Topic_03_Compare();
		Topic_03_Compare secondVariable = firstVariable;

		System.out.println("Before number = " + firstVariable.number);
		System.out.println("Before number = " + secondVariable.number);

		secondVariable.number = 15;

		System.out.println("After number = " + firstVariable.number);
		System.out.println("After number = " + secondVariable.number);

		System.out.println("===========================================");

		Topic_03_Compare firstVariable1 = new Topic_03_Compare();
		Topic_03_Compare secondVariable1 = new Topic_03_Compare();

		System.out.println("Before number = " + firstVariable1.number);
		System.out.println("Before number = " + secondVariable1.number);

		secondVariable1.number = 15;

		System.out.println("After number = " + firstVariable1.number);
		System.out.println("After number = " + secondVariable1.number);

	}

}
