package com.myJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	
	static void lockTest(){
		ExecutorService executor = Executors.newFixedThreadPool(2);
		final ReentrantLock lock = new ReentrantLock();
		
		executor.submit(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				lock.lock();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					lock.unlock();
				}
			}
		});
		
		executor.submit(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Locked: " + lock.isLocked());
				System.out.println("Held by me: " + lock.isHeldByCurrentThread());
				boolean locked = lock.tryLock();
				System.out.println("Lock acquired: " + locked);
			}
		});
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lockTest();
	}

}
