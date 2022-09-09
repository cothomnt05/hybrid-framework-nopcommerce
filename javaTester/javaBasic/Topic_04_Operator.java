package javaBasic;

public class Topic_04_Operator {

	public static void main(String[] args) {
//		int number = 10;

//		number += 5;
//		System.out.println(number);

		// 15/5 = 3
//		System.out.println(number / 5);

		// 15%6 = 2 dư 3
//		System.out.println(number % 7);

//		System.out.println(number++);	
		// In number ta trc : 10
		// sau đó ++ tăng number lên 1 : 11
//		System.out.println(++number);
		// ++ trước: tăng number lên 1: 12
		// In number ra
//		System.out.println(number--);

		int firstVariable = 5;
		int secondVariable = 7;
		int result = firstVariable++ + ++secondVariable - 8;
		System.out.println("First variable = " + firstVariable);
		System.out.println("Second variable = " + secondVariable);
		System.out.println("Result = " + result);

		// B1: ưu tiên xử lý prefix trc - B2: Xử lý các phép tính còn lại - B3: Gán giá trị cho toán hạng nằm bên trái dấu bằng trc
		// B4: xử lý postfix

		String address = "Ho Chi Minh";

		if (address != "Ha Noi" && address != "Da Nang") {
			System.out.println("Address is not the same");
		}

		// Biểu thức tam nguyên = ? :
		boolean status = (address == "Ha Noi") ? true : false;

		System.out.println(status);

	}

}
