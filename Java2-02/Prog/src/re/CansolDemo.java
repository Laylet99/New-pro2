package re;

class CansolDemo implements Runnable {

	//
	private int counter = 0;
		
	
	private Thread self;
	public void CansolDemo() {
		self = new Thread(this);
		self.start();
		
	}
	 public void join (long ms) {
		 try {
			 self.join(ms);
			 catch (InterruptedException ex) {
				 System.out.println(Thread.currentThread().getName);
			 }
		 
			 public void cancel() {
				 self.interrupt();
			 }
			 @Overrible
			 public void run( ) {
				// while(true) {
				//	 System.out.println(Thread.currenrThread().getName);
				 //}
					 
			 while(canWork) {
				 System.out.println(Thread.currentThread().getName ( ) + "-" - counter);
				 counter++;
			 }
			 

	

}
