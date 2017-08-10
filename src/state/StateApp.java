package state;

public class StateApp {
	public static void main(String[] args) {
		Human human = new Human();
		human.setState(new Work());
		
		for(int i=0; i<10; i++) {
			human.doSomething();
		}
	}
}

//Context
class Human{
	private Activity state;
	public void setState(Activity s) {
		this.state = s;
	}
	
	public void doSomething() {
		state.doSomething(this);
	}
} 

interface Activity{
	void doSomething (Human context);
}

class Work implements Activity{
	public void doSomething(Human context) {
		System.out.println("Work!");
		context.setState(new WeekEnd());
	}
}

class WeekEnd implements Activity{
	private int count = 0;
	public void doSomething(Human context) {
		if (count<3) {
		System.out.println("Holiday...");
		count++;
		}
		else {
			context.setState(new Work());
		}
	}
}