package abstract_factory;

public class AbstractFactoryApp {

	public static void main(String[] args) {
		DeviceFactory factory = getFactoryByCountryCode("EN");
		Mouse m = factory.getMouse();
		Keyboard k = factory.getKeyboard();
		Touchpad t = factory.getTouchpad();
		
		m.click();
		m.dblclick();
		m.scroll(7);
		k.print();
		k.println();
		t.track(10, 25);
	}
	
	private static DeviceFactory getFactoryByCountryCode(String lang) {
		switch (lang) {
		case "EN":
			return new EnDeviceFactory();
		case "UA":
			return new UaDeviceFactory();
		default:
			throw new RuntimeException("Unsuported country code: " + lang);
		}
	}
}

interface Mouse{
	void click();
	void dblclick();
	void scroll(int direction);
}
interface Keyboard{
	void print();
	void println();
}
interface Touchpad{
	void track(int deltaX, int deltaY);
}

interface DeviceFactory{
	Mouse getMouse();
	Keyboard getKeyboard();
	Touchpad getTouchpad();
}

class EnMouse implements Mouse{
	public void click() {System.out.println("Click");}
	public void dblclick() {System.out.println("Double click");}
	public void scroll(int direction) {
		if(direction>0)
			System.out.println("Scroll up");
		else if (direction<0)
			System.out.println("Scroll down");
		else 
			System.out.println("No scroll");
	}
}
class EnKeyboard implements Keyboard{
	public void print() {System.out.println("Print");}
	public void println() {System.out.println("Print line");}
}
class EnTouchpad implements Touchpad{
	public void track(int deltaX, int deltaY) {
		int s = (int) Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
		System.out.println("Moved " + s + " pixels");
	};
}

class UaMouse implements Mouse{
	public void click() {System.out.println("Клік");}
	public void dblclick() {System.out.println("Подвійний клік");}
	public void scroll(int direction) {
		if(direction>0)
			System.out.println("Скролимо вгору");
		else if (direction<0)
			System.out.println("Скролимо вниз");
		else 
			System.out.println("Не скролимо");
	}
}
class UaKeyboard implements Keyboard{
	public void print() {System.out.println("Друкувати");}
	public void println() {System.out.println("Друкувати рядок");}
}
class UaTouchpad implements Touchpad{
	public void track(int deltaX, int deltaY) {
		int s = (int) Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaY, 2));
		System.out.println("Рух на " + s + " пікселів");
	};
}

class EnDeviceFactory implements DeviceFactory{
	public Mouse getMouse() {
		return new EnMouse();
	};
	public Keyboard getKeyboard(){
		return new EnKeyboard();
	};
	public Touchpad getTouchpad(){
		return new EnTouchpad();
	};
}

class UaDeviceFactory implements DeviceFactory{
	public Mouse getMouse() {
		return new UaMouse();
	};
	public Keyboard getKeyboard(){
		return new UaKeyboard();
	};
	public Touchpad getTouchpad(){
		return new UaTouchpad();
	};
}