package javaBasic;

import org.openqa.selenium.Keys;

public class Topic_12_String {

	public static void main(String[] args) {
		// System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();
		// So sánh: giá trị và vị trí trên vùng nhớ
		// String s1 = "Cat";
		// String s2 = s1;
		// String s3 = new String("Cat");// tạo 1 vùng nhớ mới trên heap
		//
		// System.out.println(s1 == s2);// bằng nhau do cùng giá trị và vùng nhớ
		// System.out.println(s1 == s3);// bằng giá trị khác vùng nhớ => false
		// System.out.println(s2 == s3);
		// System.out.println(s2.equals(s3));// chỉ so sánh giá trị => true
		// == chỉ dùng để so sánh kiểu nguyên thuỷ, equals dùng để so sánh kiểu tham chiếu

		String schoolName = "Automation Testing";
		String coursceName = "AUTOMATION TESTING";
		String schoolAddress = "Ho Chi Minh City";

		System.out.println("Độ dài = " + schoolName.length());
		System.out.println("Lấy ra 1 kí tự = " + schoolName.charAt(0));
		System.out.println("Nối 2 chuỗi = " + schoolName.concat(schoolAddress));
		System.out.println("Nối 2 chuỗi = " + schoolName + schoolAddress);

		// Tuyệt đối
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals(schoolAddress));
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals("Automation Testing"));

		// Multi browser
		System.out.println("Kiểm tra 2 chuỗi bằng nhau tương đối = " + schoolName.equalsIgnoreCase(coursceName));

		// startsWith/endsWith/ contains
		System.out.println("Có bắt đầu bằng 1 ký tự/ chuỗi kí tự = " + schoolName.startsWith("A"));
		System.out.println("Có bắt đầu bằng 1 ký tự/ chuỗi kí tự = " + schoolName.startsWith("Automation"));
		System.out.println("Có bắt đầu bằng 1 ký tự/ chuỗi kí tự = " + schoolName.startsWith("T"));

		System.out.println("Có chứa 1 ký tự/ chuỗi kí tự = " + schoolName.contains("A"));
		System.out.println("Có chứa 1 ký tự/ chuỗi kí tự = " + schoolName.contains("Automation"));
		System.out.println("Có chứa 1 ký tự/ chuỗi kí tự = " + schoolName.contains("T"));

		System.out.println("Có kết thúc bằng 1 ký tự/ chuỗi kí tự = " + schoolName.endsWith("g"));
		System.out.println("Có kết thúc bằng 1 ký tự/ chuỗi kí tự = " + schoolName.endsWith("Testing"));
		System.out.println("Có kết thúc bằng 1 ký tự/ chuỗi kí tự = " + schoolName.endsWith("T"));

		System.out.println("Vị trí của 1 ký tự/ chuối kí tự trong chuỗi = " + schoolName.indexOf("Automation"));
		System.out.println("Vị trí của 1 ký tự/ chuối kí tự trong chuỗi = " + schoolName.indexOf("A"));
		System.out.println("Vị trí của 1 ký tự/ chuối kí tự trong chuỗi = " + schoolName.indexOf("Testing"));

		System.out.println("Tách 1 ký tự/ chuối kí tự trong chuỗi = " + schoolName.substring(11));
		System.out.println("Tách 1 ký tự/ chuối kí tự trong chuỗi = " + schoolName.substring(11, 15));

		// Split: Tách chuỗi thành 1 mảng dựa vào kí tự/ chuỗi kí tự
		String result = "Viewing 48 of 132 results";
		String results[] = result.split(" ");

		System.out.println(results[1]);

		// Replace
		String productPrice = "$100.00";
		productPrice = productPrice.replace("$", "");
		System.out.println(productPrice);
		// String covert sang float , để có thể sắp xếp nó : Sort Data(Asc/Des)
		float productPriceF = Float.parseFloat(productPrice);
		System.out.println(productPriceF);

		// Float covert sang String
		productPrice = String.valueOf(productPriceF);
		System.out.println(productPrice);

		String osName = System.getProperty("os.name");
		System.out.println(osName);// Windows 10

		// Handle multiple OS: Mac/Windows(Action - keys - Ctrl/Command)
		if (osName.toLowerCase().contains("windows")) {
			Keys key = Keys.CONTROL;
		} else {
			Keys key = Keys.COMMAND;
		}

		// Multiple browser: toUpperCase
		// firefox = FIREFOX(Enum)
		// String driverInstanceName = driver.toString();
		// System.out.println(driverInstanceName);// FirefoxDriver: firefox on WINDOWS (26c7b31d-648f-4b34-be31-2da4b55f8e90)
		// Close browser/driver
		// if (driverInstanceName.contains("internetexplorer")) {
		// Sleep cứng thêm 5s sau mỗi sự kiện chuyển page
		// try {
		// Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }

		// Loại trừ khoảng trắng/ xuống dòng/ tab
		String helloWorld = "   \n  \t           Hello World!                 ";
		System.out.println(helloWorld.trim());

		helloWorld = " ";

		System.out.println("Empty = " + helloWorld.isEmpty());// false
		System.out.println("Blank = " + helloWorld.isBlank());// true

		// Dynamic locator
		// Đại diện cho 1 chuỗi: %s
		// %b %t %d
		String dynamicButtonXpath = "//button[@id='%s']";
		System.out.println("Click to Login button = " + dynamicButtonXpath.format(dynamicButtonXpath, "login"));
		System.out.println("Click to Search button = " + dynamicButtonXpath.format(dynamicButtonXpath, "search"));
		System.out.println("Click to Register button = " + dynamicButtonXpath.format(dynamicButtonXpath, "register"));

	}

}
