package sin;

public class ThreadCounter implements Runnable {
	
	
	
	private int counter, steps;
	private Thread self;
	
	
	public ThreadCounter (int steps) {
		this.steps = steps;
		//counter = 0;
		self = Thread(this);
	}
	 public void start( ) {
		 counter=0;
		 self.start();
	 }

	 public void join( ) {
		 try {
			 catch(InterruptedException ex) {
				 System.out.println(ex.getMessage());
				 
			 }
			 @Override
			 public void run () {
				 for (int i=0; i<steps; i++);
				 counter++;
				 GlobalCounter.value++;
				 GlobalCounter.aValue.getAndIncrement();
				 
			 }
		 System.out.println((Thread.currentThread().getName()
                 + " , counter = " + counter);
		
	 }
	 }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	 
	 
	 
	 
	 
}