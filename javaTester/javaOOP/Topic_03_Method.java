package javaOOP;

public class Topic_03_Method {

	public int addTwoInt(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		Topic_03_Method sum = new Topic_03_Method();

		System.out.println(sum.addTwoInt(2, 5));
	}

}
