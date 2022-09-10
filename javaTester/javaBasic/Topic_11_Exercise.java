package javaBasic;

import java.util.Arrays;

public class Topic_11_Exercise {
	int id;
	String name;
	int age;
	double score;

	public Topic_11_Exercise(int id, String name, int age, double score) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public void displayed() {
		System.out.println("ID: " + this.getId());
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Score: " + this.getScore());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public void TC_01_Find_Max_Number() {
		int[] arr = { 2, 7, 6, 8, 9 };
		int max = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		System.out.println("Số lớn nhất trong mảng " + Arrays.toString(arr) + " là: " + max);
	}

	public void TC_02_Sum_First_And_Last_Number() {
		int[] arr = { 2, 7, 6, 8, 9 };
		System.out.println("Tổng của phần tử đầu tiên và cuối cùng của mảng " + Arrays.toString(arr) + " là: " + (arr[0] + arr[arr.length - 1]));
	}

	public void TC_03_Even_Number() {
		int[] arr = { 2, 7, 6, 8, 9, 16, 17, 20 };
		System.out.println("Các số chẵn trong mảng " + Arrays.toString(arr) + " là ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

	public void TC_04() {
		int[] arr = { 3, -7, 2, 5, 9, -6, 10, 12 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0 && arr[i] % 2 != 0) {
				sum += arr[i];
			}

		}
		System.out.println("Tổng các số lẻ lớn hơn 0 trong mảng " + Arrays.toString(arr) + " là " + sum);

	}

	public void TC_05() {
		int[] arr = { 3, -7, 2, 5, 9, -6, 10, 12 };
		System.out.println("Các số >= 0 và <=10 trong mảng " + Arrays.toString(arr) + " là: ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0 && arr[i] <= 10) {
				System.out.print(arr[i] + " ");
			}
		}
	}

	public void TC_06() {
		int[] arr = { 3, 5, 7, 30, 10, 5, 8, 23, 0, -5 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("Mảng " + Arrays.toString(arr) + " có tổng bằng " + sum + ", trung bình cộng bằng " + (sum / (float) (arr.length)));
	}

	public static void main(String args[]) {
		Topic_11_Exercise std1 = new Topic_11_Exercise(123, "Nam", 12, 9.8);
		std1.displayed();
	}

	public void TC_07() {
		Topic_11_Exercise std1 = new Topic_11_Exercise(123, "Nam", 12, 9.8);
		std1.displayed();
	}
}
