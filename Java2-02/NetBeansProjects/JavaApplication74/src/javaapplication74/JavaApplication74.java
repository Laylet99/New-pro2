
package javaapplication74;

public class JavaApplication74 {

    public static void main(String[] args) 
            throws InterruptedException {
        
        MyThread1 th1 = new MyThread1(10, "Counter1");
        MyThread2 th2 = new MyThread2(10, "Counter2");
        
        th1.start();
        th2.start();
        
        th2.join();
        th1.join();
        
    }
    
}
