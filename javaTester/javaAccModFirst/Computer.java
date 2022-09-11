package javaAccModFirst;

public class Computer {
	// Property
	private int ssdSize;

	String ramProductName;

	protected String cpuProductName;

	public int vgaSize;

	public void setVgaSize(int vgaSize) {
		this.vgaSize = vgaSize;
	}

	protected void setCpuProductName(String cpuProductName) {
		this.cpuProductName = cpuProductName;
	}

	protected String getCpuProductName() {
		return this.cpuProductName;
	}

	void setRamProductName(String ramProductName) {
		this.ramProductName = ramProductName;
	}

	String getRamProductName() {
		return this.ramProductName;
	}

	// Method
	public int getSsdSize() {
		return this.ssdSize;
	}

	public void setSsdSize(int ssdSize) {
		this.ssdSize = ssdSize;
	}

	public static void main(String args[]) {
		Computer comp = new Computer();

		// comp.ssdSize = 500;
		//
		// System.out.println(comp.ssdSize);
		//
		// comp.setSsdSize(600);
		//
		// System.out.println(comp.ssdSize);

		// comp.ramProductName = "Kingston";
		//
		// System.out.println(comp.ramProductName);
		//
		// comp.setRamProductName("Kingmax");
		//
		// System.out.println(comp.ramProductName);

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
