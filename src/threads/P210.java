package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LLJ
 * @version 2017年4月9日下午7:06:18
*/
class P210Service{
	private Lock lock = new ReentrantLock();
	public Condition conditionA = lock.newCondition();
	public Condition conditionB = lock.newCondition();
	public void awaitA(){
		try {
			lock.lock();
			System.out.println("begin awaitA 时间为 " + System.currentTimeMillis() + "ThreadName = "+ Thread.currentThread().getName());
			conditionA.await();
			System.out.println("end awaitA 时间为 " + System.currentTimeMillis() + "ThreadName = "+ Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		
	}
	
	public void awaitB(){
		try {
			lock.lock();
			System.out.println("begin awaitB 时间为 " + System.currentTimeMillis() + "ThreadName = "+ Thread.currentThread().getName());
			conditionB.await();
			System.out.println("  end awaitB 时间为 " + System.currentTimeMillis() + "ThreadName = "+ Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

	public void signalAllA(){
		try{
			lock.lock();
			System.out.println("  signallAllA 时间为 "+ System.currentTimeMillis()+ "ThreadName = "+ Thread.currentThread().getName());
			conditionA.signalAll();
		}finally{
			lock.unlock();
		}
	}
	
	public void signalAllB(){
		try{
			lock.lock();
			System.out.println("  signalAllB 时间为 " + System.currentTimeMillis() + "ThreadName = "+ Thread.currentThread().getName());
			conditionB.signalAll();
		}finally{
			lock.unlock();
		}
	}
}

class P210ThreadA extends Thread{
	private P210Service service;
	public P210ThreadA(P210Service service){
		super();
		this.service = service;
	}
	public void run(){
		service.awaitA();
	}
}
class P210ThreadB extends Thread{
	private P210Service service;
	public P210ThreadB(P210Service service){
		super();
		this.service = service;
	}
	public void run(){
		service.awaitB();
	}
}
public class P210 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		P210Service service = new P210Service();
		P210ThreadA ta = new P210ThreadA(service);
		ta.setName("A");
		ta.start();
		
		P210ThreadB tb = new P210ThreadB(service);
		tb.setName("B");
		tb.start();
		Thread.sleep(3000);
		service.signalAllA();
	}

}
