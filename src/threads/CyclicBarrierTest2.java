package threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author LLJ
 * @version 2017年3月15日下午9:14:04
*/
public class CyclicBarrierTest2 {

	static CyclicBarrier c = new CyclicBarrier(2,new A());
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Thread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					c.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(1);
			}
		}).start();
		try {
			c.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(2);
	}

	static class A implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			System.out.println(3);
		}
		
	}
}
