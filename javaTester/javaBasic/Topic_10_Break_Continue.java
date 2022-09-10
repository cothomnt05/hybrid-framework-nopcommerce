package javaBasic;

public class Topic_10_Break_Continue {
	public static void main(String args[]) {
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.print(i + " ");
		}

		for (int i = 1; i <= 5; i++) {
			System.out.println("Lần chạy của i (for trên) = " + i);
			for (int j = 1; j <= 5; j++) {
				if (j == 4) {
					continue;
				}

				System.out.println("j = " + j);
			}
		}
	}
}
