package builder;

public class BuilderApp {
	public static void main(String[] args) {
		Car car = new CarBuilder()
				.buidMaker("Mercedes")
				.buidTransmission(Transmission.AUTO)
				.buidMaxSped(300)
				.builder();
		
		System.out.println(car);
	}
}

enum Transmission{
	MANUAL, 
	AUTO
}

class Car {
	String maker;
	Transmission transmission;
	int maxSpead;
	
	public void setMaker(String maker) {this.maker = maker;}
	public void setTransmission(Transmission transmission) {this.transmission = transmission;}
	public void setMaxSpead(int maxSpead) {this.maxSpead = maxSpead;}
	@Override
	public String toString() {
		return String.format("Car [maker=%s, transmission=%s, maxSpead=%s]", maker, transmission, maxSpead);
	}
	
	
}

class CarBuilder{
	String m = "Default";
	Transmission t = Transmission.MANUAL;
	int s = 120;
	
	CarBuilder buidMaker(String m) {
		this.m = m;
		return this;
	}
	
	CarBuilder buidTransmission(Transmission t) {
		this.t = t;
		return this;
	}
	
	CarBuilder buidMaxSped(int s) {
		this.s = s;
		return this;
	}
	
	Car builder () {
		Car car = new Car();
		car.setMaker(m);
		car.setTransmission(t);
		car.setMaxSpead(s);
		return car;
	}
	
}