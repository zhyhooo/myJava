package concurrent.myJava.com;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	public static void fixedThreadPool(){
		int nthreads = 5;
		ExecutorService threadpool = Executors.newFixedThreadPool(nthreads);
		for ( int i=1; i<=nthreads*2; i++ ){
			final int taskID = i;
			threadpool.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i=1; i<=3; i++){
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("fixed -- 第" + taskID + "次任务的第" + i + "次执行");
					}
				}
			});
		}
		threadpool.shutdown();
	}
	
	public static void cachedThreadPool(){
		ExecutorService threadpool = Executors.newCachedThreadPool();
		for ( int i=1; i<=5; i++ ){
			final int taskID = i;
			threadpool.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i=1; i<=3; i++){
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("cached -- 第" + taskID + "次任务的第" + i + "次执行");
					}
				}
			});
		}
		threadpool.shutdown();
	}
	
	public static void scheduledThreadPool(){
		//int niter = 5;
		ScheduledExecutorService schedulepool = Executors.newScheduledThreadPool(1);
		Date date = new Date();
		System.out.println("main thread -- time is " + date);
		schedulepool.schedule(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Date date = new Date();
				System.out.println("new thread -- time is " + date);
			}
		}, 5, TimeUnit.SECONDS);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("This is fixedThreadPool:");
		fixedThreadPool();
		System.out.println("This is cachedThreadPool");
		cachedThreadPool();
		System.out.println("This is scheduledThreadPool");
		scheduledThreadPool();

	}

}
