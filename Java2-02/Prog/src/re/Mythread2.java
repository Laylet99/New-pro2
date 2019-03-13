package re;

public class Mythread2 implements Runnable {
	
	private int steps;
	private Thread self;
	
	public Mythread2(int steps, String name) 
	this.steps = steps;
	self = new Thread(this, name);
	self.start();
}


Public void start() {
	self.start();
}
public void join() {
	try {
		self.join();
			
	}
}
@Override
public void run() {
	for(int i=o; i < steps; i++) {
		System.out.println(Thread.currentThread().getName());
	}
}
