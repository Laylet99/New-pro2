package tictak;

public class ThreadTwo implements Runnable
{
    private Thread thread;

    public Thread getThread () {
        return thread;
    }

    public ThreadTwo() {
        thread = new Thread (this);
    }
    
    public void run() {
        try {
            Thread.sleep(1);
            for (int i = 0; i < TicTak.num; i++) {
                System.out.println(2);

            }
        }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
}
