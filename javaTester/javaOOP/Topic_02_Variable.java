package javaOOP;

public class Topic_02_Variable {
	// Global variable
	// constant variable
	public final static String STUDENT_NAME = "Nguyen Van Nam";

	// final variable
	final int age = 23;

	// property : có getter, setter, trở thành đặc điểm của đối tượng
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String args[]) {
		// local variable
		String name = "Nguyen Van B";
		System.out.println(name);
	}
}
