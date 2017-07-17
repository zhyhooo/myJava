package com.myJava.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DiceCallable dice = new DiceCallable();
        
        FutureTask<Integer> future = new FutureTask<Integer>(dice);
        new Thread(future).start(); 
        try {
        	System.out.println("This is main thread...");
        	Thread.sleep(5000); //do sth
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class DiceCallable implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int x = new Random().nextInt(100);
		System.out.println("start new thread...");
		Thread.sleep(3000);
		System.out.println("new thread end...");
		return x;
	}
	
}