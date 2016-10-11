package concurrent.myJava.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<String>> futures = new ArrayList<Future<String>>();
		
		for( int i=0; i<5; i++){
			futures.add(exec.submit(new RandomTask()));
		}
		for(Future<String> fs: futures){
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class RandomTask implements Callable<String> {

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		int x = new Random().nextInt(100);
		return "result is " + x;
	}
	
}
