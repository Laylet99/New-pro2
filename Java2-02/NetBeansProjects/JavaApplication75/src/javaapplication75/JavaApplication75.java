
package javaapplication75;

import java.io.File;


public class JavaApplication75 {

    public static void main(String[] args) {
        
        CancelDemo demo = new CancelDemo();
        
        
        demo.join(1000);
        //demo.cancel();
        demo.stop();
        
        System.out.println("end of main()");
        
    }
    
}
