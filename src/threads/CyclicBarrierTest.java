package threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author LLJ
 * @version 2017年3月15日下午9:06:27
*/
public class CyclicBarrierTest {
	
	//为俩线程设置了一个可循环利用的屏障，只有当两个线程都到达了屏障之后，这俩线程才会继续执行。等着大家都到了才能走。
	static CyclicBarrier c = new CyclicBarrier(2);
	
	public static void main(String[] args) {
		new Thread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					c.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(1);
			}
			
		}).start();;
		
		try {
			c.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(2);
	}

}
