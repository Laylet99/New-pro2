
package javaapplication74;

public class MyThread1 extends Thread {
    
    private int steps;

    public MyThread1(int steps, String string) {
        super(string);
        this.steps = steps;
    }

    @Override
    public void run() {
        for (int i = 0; i < steps; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - " + i);
        }
    }
  
}
