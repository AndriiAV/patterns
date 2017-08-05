package facade;

public class FacadeApp {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.copy();
		
	}
}

//class Facade
class Computer{
	Power power = new Power();
	DVDRom dvdRom = new DVDRom();
	HDD hdd = new HDD();
	
	void copy() {
		power.on();
		dvdRom.load();
		hdd.copyFromDVD(dvdRom);
	}
}

class Power {
	void on() {
		System.out.println("Power ON");
	};
	
	void off() {
		System.out.println("Power OFF");
	};
}

class DVDRom{
	private boolean data = false;
	public boolean hasData() {
		return data;
	}
	void load() {
		data = true;
	}
	void unload() {
		data = false;
	}
}

class HDD{
	void copyFromDVD (DVDRom dvdRom) {
		if(dvdRom.hasData()) {
			System.out.println("Copy data from DVD");
		}
		else {
			System.out.println("Please, insert DVD");
		}
	}
}