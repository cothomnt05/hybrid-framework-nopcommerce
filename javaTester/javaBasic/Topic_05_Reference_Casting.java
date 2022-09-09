package javaBasic;

public class Topic_05_Reference_Casting {
	public String studentName;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void xuatThongTin() {
		System.out.println("Student name: " + studentName);
	}

	public static void main(String[] args) {
		Topic_05_Reference_Casting firstStudent = new Topic_05_Reference_Casting();
		Topic_05_Reference_Casting secondStudent = new Topic_05_Reference_Casting();

		firstStudent.setStudentName("Nguyen Van Nam");
		secondStudent.setStudentName("Le Van Long");

		firstStudent.xuatThongTin();
		secondStudent.xuatThongTin();

		// Ép kiểu
		firstStudent = secondStudent;

		firstStudent.xuatThongTin();
		secondStudent.xuatThongTin();

		secondStudent.setStudentName("Dao M Dam");

		firstStudent.xuatThongTin();
		secondStudent.xuatThongTin();

	}
}
