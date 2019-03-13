
package javaapplication74;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyThread2 implements Runnable {
    
    private int steps;
    private Thread self;

    public MyThread2(int steps, String name) {
        this.steps = steps;
        self = new Thread(this, name);
        //self.start();
    }

    public void start() {
        //we can read configuration file
        self.start();
    }
    
    public void join() {
        try {
            self.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void run() {
        for (int i = 0; i < steps; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - " + i);
        }
    }
 
}
