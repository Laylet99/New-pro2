package tictaksolution;

public class ThreadOne extends Thread {

  private Object monitor;
  
  public ThreadOne(Object monitor) {
    this.monitor = monitor;
  }

  public void run () {
    try {
        for (int i = 0; i < TicTakSolution.num; i++) {
            System.out.print(1+" - ");
            synchronized (monitor) {
                monitor.notify();
                if (i < TicTakSolution.num-1)
                    monitor.wait();
            }
        }
    }
    catch (InterruptedException e) { e.printStackTrace(); }
  }
}
