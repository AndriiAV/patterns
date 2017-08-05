package singleton;

public class SingletonMultithreadApp {
		public static void main(String[] args) throws InterruptedException{
			final int SIZE = 1000;
			Thread t[] = new Thread[SIZE];
			
			for(int i=0; i<SIZE; i++) {
			 t[i] = new Thread(new M());
			 t[i].start();
			}
			
			for(int i=0; i<SIZE; i++) {
				t[i].join();
			}
			
			System.out.println(SingletonWokrMultithead.counter);
		}
	}

	class M implements Runnable{
		@Override
		public void run() {
			SingletonWokrMultithead.getInstance();
		}
	}

	class SingletonWokrMultithead{
		public static int counter = 0;
		//private static SingletonWokrMultithead instance = new SingletonWokrMultithead();
		private static volatile SingletonWokrMultithead instance = null;
		private SingletonWokrMultithead() {
			counter++;
		}
		/*public static SingletonWokrMultithead getInstance() {
			return instance;
		}*/
		public static SingletonWokrMultithead getInstance() {
			if(instance == null) {
				 synchronized(SingletonWokrMultithead.class) {
					 if(instance == null)
				instance = new SingletonWokrMultithead(); 
				 }
			}
			return instance;
		}
}
