package concurrent.myJava.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest {


	static void incrementTest(){
	    ExecutorService executor = Executors.newFixedThreadPool(2);
	    final Counter counter = new Counter();
	    for (int i=0; i<100; i++){
	    	executor.submit(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					counter.add();
				}
			});
	    }
	    executor.shutdown();
	}
	
	
	static void incrementSyncTest(){
	    ExecutorService executor = Executors.newFixedThreadPool(2);
	    final Counter counter = new Counter();
	    for (int i=0; i<100; i++){
	    	executor.submit(new Runnable() {	
				@Override
				public void run() {
					// TODO Auto-generated method stub
					counter.addSync();
				}
			});
	    }
	    executor.shutdown();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//incrementTest();
		incrementSyncTest();
	}

}

class Counter{
	int count = 0;
	void add(){
		count = count + 1;
		System.out.println("this is "+count);
	}
	synchronized void addSync(){
		count = count + 1;
		System.out.println("this is "+count);
	}
}
