package javaAccModSecond;

import javaAccModFirst.Computer;

public class PC extends Computer {
	public void showCpuProductName() {
		cpuProductName = "Intel";

		System.out.println(cpuProductName);

		setCpuProductName("AMD");

		System.out.println(cpuProductName);
	}
}
