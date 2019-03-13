package javaapplication1;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Sum extends RecursiveTask<Long> {   

      int low;
      int high;
      long[] array;
  
      Sum(long[] arr, int lo, int hi) {
          array = arr;
          low   = lo;
          high  = hi;
      }
      @Override
      protected Long compute() {
      
        if(high - low <= 100) {
            
          long sum = 0;
          for(int i=low; i < high; ++i) {            
            sum += array[i];            
          }      
          return sum;
            
        } else {           
          int mid = low + (high - low) / 2;
          Sum left  = new Sum(array, low, mid);
          Sum right = new Sum(array, mid, high);
          left.fork();
          long rightAns = right.compute();
          long leftAns  = left.join();
          return leftAns + rightAns;                
        }
      }
  }  


public class JavaApplication1 {
    
  static void randomFill(long[] a) {
    final Random rng = new Random();
    for (int i = 0; i < a.length; ++i)
      a[i] = rng.nextInt();
  }
  
  public static void main(String[] args) {
        long[] a1 = new long[10000];
        randomFill(a1);
        
        long sum=0;
        for (int i = 0; i < 10000; i++)          
            sum += a1[i];
        System.out.println(sum);
        
        ForkJoinPool pool = new ForkJoinPool();
        long s2=pool.invoke(new Sum(a1,0,a1.length));
        System.out.println(s2);
    }
}
