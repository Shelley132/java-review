package threads;

import java.util.concurrent.TimeUnit;

import org.junit.runner.Runner;

/**
 * @author JUANJUAN
 * @version 2017年9月13日下午4:08:38
*/
public class Shutdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Runner one = new Runner();
		Thread countThread = new Thread(one, "CountThread");
		countThread.start();
		//睡眠一秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束
		TimeUnit.SECONDS.sleep(1);
		countThread.interrupt();
		Runner two = new Runner();
		countThread = new Thread(two, "CountThread");
		countThread.start();
		
		TimeUnit.SECONDS.sleep(1);
		two.cancel();
		
	}

	
	public static class Runner implements Runnable{
		private long i;
		private volatile boolean on = true;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(on && !Thread.currentThread().isInterrupted()){
				i++;
			}
			System.out.println("Count i = " + i);
		}
		public void cancel(){
			on = false;
		}
	}
}
