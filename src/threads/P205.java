package threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LLJ
 * @version 2017年4月4日下午9:55:53
 * 由p205修改而得的p208的正确示例
*/

class P205Service{
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void await(){
		try{
			lock.lock();
			System.out.println("await 时间为"+ System.currentTimeMillis());
			condition.await();
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			lock.unlock();
			
		}
	}
	public void signal(){
		try{
			lock.lock();
			System.out.println("signal 时间为" + System.currentTimeMillis());
			condition.signal();
		}finally{
			lock.unlock();
		}
	}
}
class P205ThreadA extends Thread{
	private P205Service service;
	public P205ThreadA(P205Service service){
		super();
		this.service = service;
	}
	@Override
	public void run(){
		service.await();
	}
}

public class P205 {

public static void main(String[] args) throws InterruptedException {
	P205Service service = new P205Service();
	P205ThreadA a = new P205ThreadA(service);
	a.start();
	Thread.sleep(3000);
	service.signal();
}
}
