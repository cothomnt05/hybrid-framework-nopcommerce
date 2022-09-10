package javaBasic;

//class
public class Topic_09_While_Do_While {

	// Function
	public static void main(String args[]) {
		// Block code
		System.out.println("=========For=========");
		for (int i = 0; i < 5; i++) {
			System.out.print(i + " ");
			if (i == 3) {
				break;
			}
		}
		System.out.println();
		System.out.println("=========While=========");
		int i = 0;
		while (i < 5) {
			System.out.print(i + " ");
			if (i == 3) {
				break;
			}
			i++;
		}

		System.out.println();
		System.out.println("=========Do_While=========");

		i = 0;
		// Chạy ít nhất 1 lần rồi mới kiểm tra điều kiện
		do {
			System.out.print(i + " ");
			if (i == 3) {
				break;
			}
			i++;
		} while (i < 5);

	}
}
