package re;

public class m {
	public static void main(string[] args) {
		
		throws InterruptedException {
		MyThread1 th1 = new MyThread1 (10, "Count1");
		MyThread2 th2 = new MyThread2 (10, "Count2");
		
		t1.start();
		t2.start();
		
		
		t1.join();
		t2.join();
		
	}
	}
}
