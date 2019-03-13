package tictak;

public class TicTak {
    static int num=20;

    public static void main(String[] args) {
        ThreadOne thr1 = new ThreadOne ();
        ThreadTwo thr2 = new ThreadTwo ();

        thr1.start();
        thr2.getThread().start();

        try {
            thr1.join();
            thr2.getThread().join();
        }
        catch (InterruptedException e) { e.printStackTrace();}
    }
}