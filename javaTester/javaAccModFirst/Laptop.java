package javaAccModFirst;

public class Laptop {

	public static void main(String args[]) {
		Computer comp = new Computer();

		// comp.cpuProductName = "Intel";
		//
		// System.out.println(comp.cpuProductName);
		//
		// comp.setCpuProductName("AMD");
		//
		// System.out.println(comp.cpuProductName);

		comp.vgaSize = 6;

		System.out.println(comp.vgaSize);

		comp.setVgaSize(4);

		System.out.println(comp.vgaSize);
	}
}
