package sinh;



public class Sinhro1 {

	public static void main(String[] args)  throws InterruptedException {
		
		Test test = new Test();
		
		Runnable runner1 = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i< 10; i++) {
				test.increment();
			}
			}
		};
		
		
		Monitor m = new Monitor();
		Runnable runner2 = new Runnable() {
			
		}
			@Override
			public void run() {
				 for (int i=0; i<3; i++) {
					 synchronized (m) {
						 m.x++;
						//мо
					}
			}
		}
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		
		Thread [] threads = new Thread[3];
		
		for (int i=0; i<3; i++) {
		threads[i] = new Thread(runner2) ;
		threads[i].start();
		System.out.println(test.getX));
		System.out.println(m.x);
		
		
		}
		for  (int i=0; i<3; i++) {
			threads[i].start();
		}
class Test {
	private int x;
	public int getX( ) {
		return x;
	}
		
	
	
	public  synchronized void increment() {
	      x++;
	}
	
	class Monitor {
	public int x;
	}
}

	
	}

	
 