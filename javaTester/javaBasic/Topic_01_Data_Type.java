package javaBasic;

import java.util.Scanner;

public class Topic_01_Data_Type {
	// Hàm khởi tạo không tham số
	public Topic_01_Data_Type() {

	}
	// Biến static truy cập thông qua tên class + tên biến static : Topic_01_Data_Type.studentNumber
	// Biến local truy cập thông qua việc khởi tạo đối tượng của class + tên biến :topic.studentName

	static int studentNumber;
	static boolean status;
	static final String BROWSER_NAME = "Chrome"; // ko đc phép gán lại với hằng số(final)

	static int studentPrice;

	String studentName = "AutomationFC";

	public static void main(String[] args) {
		int studentPrice = 5;

		System.out.println(studentPrice);

		System.out.println(Topic_01_Data_Type.studentNumber);// khi khai báo với từ khoá static có thể gọi trực tiếp trong hàm static
		System.out.println(status);
//		browserName = "Edge";//ko đc gán lại khi dùng final

		Topic_01_Data_Type topic = new Topic_01_Data_Type();

		System.out.println(topic.studentName); // ko khai báo với từ khoá staticthì phải tạo đối tượng của class
		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println(name);
		System.out.println(name);
		System.out.print(name);
		System.out.print(name);
	}

	// Getter: getCurrentUrl/getTitle/ getText/ getAttribute/ getCssValue/ getSize/ getLocation/ getPosition/...
	public String getStudentName() {
		return this.studentName;
	}

	// Setter: click/ sendkey/ clear/ select/ back/ forward/ refresh/ get/...
	public void setStudentName(String stdName) {
		this.studentName = stdName;
	}

}
