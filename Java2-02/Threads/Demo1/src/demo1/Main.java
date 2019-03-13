package demo1;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		final MyThread1 mt = new MyThread1();
		MyThread2 omt = new MyThread2();
		mt.start();
		omt.thread.start();
                
//		new Thread() {
//@Override public void run()
//			{
//				for (int i = 0; i < 30; i++)
//					System.out.println("Name = " + Thread.currentThread().getName() +
//							", i = " + i);
//			}
//		}.start();

		//mt.join();
		//omt.thread.join();
                
                System.out.println("end of main");
	}

}
