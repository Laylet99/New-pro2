package cal;


public class natifay {

	public static void main(String[] args) {
		Monitor m = new Monitor() {
           Thread th1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
			
				for (int i = 0; i < 10; i++) {
					System.out.println("1 - " + i);
				}
					synchronized (m) {
						m.x++;
						if(m.x>49)
						m.notify();
					}
				
			
			}
			}
		);
           Thread th2 = new Thread (() -> {
           synchronized (m) {
        	   while(m.x<50) try { m.wait(); }
			catch (InterruptedException ex) {
				System.out.println(ex.getMessage());
			}
		}
           for (int i=0; i<3; i++) {
        	   System.out.println("2 - " + i);
           }
           });  
           
           th1.start();
           Thread.sleep(1);
           th2.start();
           
           th1.join();
           th2.join();
	

		
 class Monitor {
public volatile int x ;
 }
	

	

	
