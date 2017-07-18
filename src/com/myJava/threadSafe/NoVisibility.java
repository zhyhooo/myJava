package com.myJava.concurrency;

/**
 * Created by hzzhaoyihua on 2017/7/17.
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public  void run() {
            System.out.println("The init number is "+number);
            while (!ready) Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        System.out.println("Start main func");
        new ReaderThread().start();
        // the order of the following two lines is not guaranteed,
        // as long as the reordering is not detectable from within that thread
        number = 41;
        ready = true;
    }
}
