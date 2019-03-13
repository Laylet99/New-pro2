package sin;

public class Main {

	public static void main(String[] args) {
		 ThreadCounter th1 = new ThreadCounter(1000);
		 ThreadCounter th2 = new ThreadCounter(1000);
		 th1.start();
		 th2.start();
		 
		 th1.join();
		 th2.join();
		 System.out.println("Gloabal counter value =" + GlobalCounter.value);
		 
		 System.out.println("Gloabal atomic value =" + GlobalCounter.aValue);
	}

}
