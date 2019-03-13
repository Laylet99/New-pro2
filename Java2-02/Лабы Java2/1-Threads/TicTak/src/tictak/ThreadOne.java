package tictak;

public class ThreadOne extends Thread {
  
    public ThreadOne() {

    }

    public void run () {
        //try 
        {
            for (int i = 0; i < TicTak.num; i++) {
                System.out.print(1+" - ");

            }
        }
        //catch (InterruptedException e) { e.printStackTrace(); }
    }
}
