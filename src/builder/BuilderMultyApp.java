package builder;

public class BuilderMultyApp {

	public static void main(String[] args) {
		Director director = new Director();
		director.setBuilder(new FordMondeoBuilder());
		CarM carM = director.BuilderCarM();
		System.out.println(carM);
	}
}

enum TransmissionM{
	MANUAL, 
	AUTO
}

class CarM {
	String maker;
	Transmission transmission;
	int maxSpead;
	
	public void setMaker(String maker) {this.maker = maker;}
	public void setTransmission(Transmission transmission) {this.transmission = transmission;}
	public void setMaxSpead(int maxSpead) {this.maxSpead = maxSpead;}
	@Override
	public String toString() {
		return String.format("CarM [maker=%s, transmission=%s, maxSpead=%s]", maker, transmission, maxSpead);
	}
}

abstract class CarBuilderM{
	CarM carM;
	void createCarM() {carM = new CarM();}
	
	abstract void buildMaker();
	abstract void buildTransmission();
	abstract void buildSpead();
	
	CarM getCarM() {return carM;}
}

class FordMondeoBuilder extends CarBuilderM{
	void buildMaker() {carM.setMaker("Fordondeo");}
	void buildTransmission() {carM.setTransmission(Transmission.AUTO);}
	void buildSpead() {carM.setMaxSpead(250);}
}

class SubaruBuilder extends CarBuilderM{
	void buildMaker() {carM.setMaker("Subaru");}
	void buildTransmission() {carM.setTransmission(Transmission.MANUAL);}
	void buildSpead() {carM.setMaxSpead(270);}
}

class Director{
	CarBuilderM builder;
	void setBuilder(CarBuilderM b) {builder = b;}
	
	CarM BuilderCarM() {
			builder.createCarM();
			builder.buildMaker();
			builder.buildTransmission();
			builder.buildSpead();
			CarM carM = builder.getCarM();
			return carM;
	}
}