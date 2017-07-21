package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author LLJ
 * @version 2017年4月24日下午7:06:07
*/
class CallableTest implements Callable<Object>{

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("call...");
		String str="";
		for(int i=1100000; i>0; i++){
			str+=i;
		}
	/*	
		while(true){
			if(Thread.interrupted()){
				System.out.println("停止了");
				
				break;
			}	
		}*/
		System.out.println("end...");
		return Boolean.TRUE;
	}
	
}
public class FutureTaskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		for(int i =0; i< 1000; i++){
			FutureTask<Object> task = new FutureTask<Object>(new CallableTest());
			pool.submit(task);
			try {
				Boolean result = (Boolean) task.get(100,TimeUnit.MILLISECONDS);
				System.out.println(result);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				System.out.println("超时..."+i);
				task.cancel(true);
				
				e.printStackTrace();
				
			}finally{
				
				System.out.println(task.isDone()+" "+task.isCancelled()+"==========");
			}
		}
		pool.shutdown();
		try {
			pool.awaitTermination(2000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(pool.isShutdown())
				System.out.println("关闭");
		System.exit(0);
	}

}
