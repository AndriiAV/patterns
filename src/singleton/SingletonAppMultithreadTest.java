package singleton;

public class SingletonAppMultithreadTest {
	public static void main(String[] args) throws InterruptedException{
		
		final int SIZE = 1000;
		
		Thread t[] = new Thread[SIZE];
		
		for(int i=0; i<SIZE; i++) {
		 t[i] = new Thread(new R());
		 t[i].start();
		}
		
		for(int i=0; i<SIZE; i++) {
			t[i].join();
		}
		
		System.out.println(SingletonMultithead.counter);
	}
}

class R implements Runnable{

	@Override
	public void run() {
		
		SingletonMultithead.getInstance();
	}
	
}

class SingletonMultithead{
	public static int counter = 0;
	private static SingletonMultithead instance;
	private SingletonMultithead() {
		counter++;
	}
	static public SingletonMultithead getInstance() {
		if(instance == null) {
			instance = new SingletonMultithead(); 
		}
		return instance;
	}
}