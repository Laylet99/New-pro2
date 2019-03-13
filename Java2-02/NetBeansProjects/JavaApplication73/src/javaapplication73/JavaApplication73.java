
package javaapplication73;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaApplication73 {

    public static void main(String[] args) {
        
        System.out.println("Hello from "
                + Thread.currentThread().getName());
        
        MyThread thread = new MyThread();
        thread.start();
        
        //...........................for
        
        try {
            //thread.run();
            thread.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("end of main()");
 
    }
    
}
