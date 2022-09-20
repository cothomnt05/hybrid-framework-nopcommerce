package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import commons.GlobalConstants;

public class Topic_11_Array {

	public static void main(String[] args) {
		// Khai báo mảng
		// int[] number = { 12, 7, 5, 61, 15 };
		//
		// // Lấy ra phần tử của mảng
		// System.out.println(number[0]);
		// System.out.println(number[1]);
		//
		// // Array ko thay đổi đc số lượng phần tử sau khi khởi tạo
		// int b[] = new int[5];
		// // Gán phần tử
		// b[0] = 10;
		//
		// for (int i = 0; i < number.length; i++) {
		// System.out.print(number[i] + " ");
		// }
		//
		// // List thay đổi đc số lượng phần tử sau khi khởi tạo
		// ArrayList<Integer> nums = new ArrayList<>();
		//
		// for (int num : number) {
		// nums.add(num);
		// }
		//
		// List<String> names = Arrays.asList("Tom", "Jerry", "Donald");
		//
		// for (String name : names) {
		// System.out.println("Name: " + name);
		// }

		String[] fileNames = { "CSharp.jpg", "Java.jpg", "Python.jpg" };

		String filePath = GlobalConstants.UPLOAD_FILE;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}

		fullFileName = fullFileName.trim();
		System.out.println(fullFileName);
	}

}
