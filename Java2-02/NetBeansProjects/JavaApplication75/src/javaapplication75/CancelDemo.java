
package javaapplication75;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CancelDemo implements Runnable {
    
    private boolean canWork = true;
    private int counter = 0;
    private Thread self;

    public CancelDemo() {
        self = new Thread(this);
        self.start();
    }
    
    public void join(long ms) {
        try {
            self.join(ms);
        } catch (InterruptedException ex) {
            System.out.println(Thread.currentThread().getName() + 
                    " was interrupted in join()!");
        }
    }
    
    public void cancel() {
        self.interrupt();
    }
    
    public void stop() {
        canWork = false;
    }

    @Override
    public void run() {
//        while(true) {
//            System.out.println(Thread.currentThread().getName() +
//                    " - " + counter);
//            counter++;
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                System.out.println(Thread.currentThread().getName() + 
//                        " was interrupted in run()!");
//                break;
//            }
//        }
        while(canWork) {
            System.out.println(Thread.currentThread().getName() +
                    " - " + counter);
            counter++;
        }
    }

}
