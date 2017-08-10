package state;

public class StateContextApp {

	public static void main(String[] args) {
		Station fm = new RadioFM();
		Radio radio = new Radio();
		radio.setStation(fm);
		
		for (int i=0; i<=10; i++) {
			radio.play();
			radio.nextStation();
			
		}
	}

}

//State
interface Station{
	void play();
}

class Radio1 implements Station{
	public void play() {System.out.println("Radio one");}
}

class RadioFM implements Station{
	public void play() {System.out.println("Radio FM");}
}

class RadioAM implements Station{
	public void play() {System.out.println("Radio AM");}
}

//Context
class Radio{
	Station station;
	void setStation (Station st) {station = st;}
	void nextStation() {
		if(station instanceof Radio1) {
			setStation(new RadioFM());
		}
		else if (station instanceof RadioFM) {
			setStation(new RadioAM());
		}
		else setStation(new Radio1());
	}
	void play() {station.play();}
}