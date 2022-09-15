package javaOOP;

public class Topic_04_Overloading {
	public int add(int a, int b) {
		return a + b;
	}

	public int add(int a, int b, int c) {
		return a + b + c;
	}

	public String add(String name) {
		return name;
	}

	public static void main(String[] args) {
		Topic_04_Overloading sum = new Topic_04_Overloading();
		System.out.println(sum.add(2, 3));
		System.out.println(sum.add(4, 5, 6));
		System.out.println(sum.add("ABC"));

	}

}
