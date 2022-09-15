package javaOOP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Topic_01_Class_Object_Student {
	public Scanner scanner = new Scanner(System.in);
	private List<Student> stdArr = new ArrayList<>();

	public Topic_01_Class_Object_Student() {
	}

	public void add() {
		int stdID = inputStdID();
		String stdName = inputStdName();
		double ltScore = inputLtScore();
		double ttScore = inputTtScore();
		Student student = new Student(stdID, stdName, ltScore, ttScore);
		student.displayStd();
		stdArr.add(student);
	}

	public int inputStdID() {
		System.out.print("Nhap ma sinh vien: ");
		return scanner.nextInt();
	}

	public String inputStdName() {
		scanner.nextLine();
		System.out.print("Nhap ten sinh vien: ");
		return scanner.nextLine();
	}

	public double inputLtScore() {
		System.out.print("Nhap diem ly thuyet: ");
		return scanner.nextDouble();
	}

	public double inputTtScore() {
		System.out.print("Nhap diem thuc hanh: ");
		return scanner.nextDouble();
	}

	public void inDS() {
		System.out.println("Ma sinh vien\tTen sinh vien\tDiem trung binh");
		for (Student student : stdArr) {
			student.displayStd();
		}

	}

	public class SortStudentByName implements Comparator<Student> {
		@Override
		public int compare(Student student1, Student student2) {
			return student1.getStdName().compareTo(student2.getStdName());
		}
	}

	public class SortStudentByGPA implements Comparator<Student> {
		@Override
		public int compare(Student student1, Student student2) {
			if (student1.tinhDiemTrungBinh() > student2.tinhDiemTrungBinh()) {
				return 1;
			}
			return -1;
		}
	}

	public void sortStudentListByName() {
		Collections.sort(stdArr, new SortStudentByName());
	}

	public void sortStudentByGPA() {
		Collections.sort(stdArr, new SortStudentByGPA());
	}

	public List<Student> getStdArr() {
		return stdArr;
	}

	public void setStdArr(List<Student> stdArr) {
		this.stdArr = stdArr;
	}

	public class Student {
		private int stdID;
		private String stdName;
		private double ltScore;
		private double ttScore;

		public Student() {

		}

		public Student(int stdID, String stdName, double ltScore, double ttScore) {
			this.stdID = stdID;
			this.stdName = stdName;
			this.ltScore = ltScore;
			this.ttScore = ttScore;
		}

		public double tinhDiemTrungBinh() {
			return (Math.round((this.ltScore + 2 * this.ttScore) * 100 / 3)) / 100.0;
		}

		public void displayStd() {
			System.out.println(this.stdID + "\t\t" + this.stdName + "\t\t" + tinhDiemTrungBinh());
		}

		public int getStdID() {
			return stdID;
		}

		public void setStdID(int stdID) {
			this.stdID = stdID;
		}

		public String getStdName() {
			return stdName;
		}

		public void setStdName(String stdName) {
			this.stdName = stdName;
		}

		public double getLtScore() {
			return ltScore;
		}

		public void setLtScore(double ltScore) {
			this.ltScore = ltScore;
		}

		public double getTtScore() {
			return ttScore;
		}

		public void setTtScore(double ttScore) {
			this.ttScore = ttScore;
		}

	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		Topic_01_Class_Object_Student stdManager = new Topic_01_Class_Object_Student();
		boolean flag = true;
		do {
			menu();
			int n = scan.nextInt();
			switch (n) {
			case 0:
				System.out.println("Tam biet");
				flag = false;
				break;
			case 1:
				stdManager.add();
				break;
			case 2:
				stdManager.inDS();
				break;
			case 3:
				stdManager.sortStudentByGPA();
				stdManager.inDS();
				break;
			case 4:
				stdManager.sortStudentListByName();
				stdManager.inDS();
				break;
			default:
				System.out.println("Vui long nhap lai");
				break;
			}
		} while (flag);

	}

	public static void menu() {
		System.out.println("******************************************");
		System.out.println("**\tCHUONG TRINH QUAN LY SINH VIEN\t**");
		System.out.println("**\t1. Nhap du lieu\t\t\t**");
		System.out.println("**\t2. In danh sach sinh vien\t**");
		System.out.println("**\t3. Sap sep sinh vien theo DTB \t**");
		System.out.println("**\t4. Sap sep sinh vien theo ten\t**");
		System.out.println("**\t0.Thoat\t\t\t\t**");
		System.out.println("******************************************");
		System.out.println("**\tNhap lua chon cua ban \t\t**");
	}
}
