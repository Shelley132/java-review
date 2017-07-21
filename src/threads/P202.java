package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LLJ
 * @version 2017年4月4日下午9:03:29
*/

class P202Service{
	private Lock lock = new ReentrantLock();
	public void methodA(){
		try{
			lock.lock();
			System.out.println("methodA begin ThreadName = " + Thread.currentThread().getName() + " time = "+ System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("methodA end ThreadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	public void methodB(){
		try{
			lock.lock();
			System.out.println("methodB begin ThreadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("methodB end ThreadName = " + Thread.currentThread().getName()+ " time = "+ System.currentTimeMillis());
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}
class P202ThreadA extends Thread{
	private P202Service service;
	public P202ThreadA(P202Service service){
		super();
		this.service = service;
	}
	@Override
	public void run(){
		service.methodA();
	}
}
class P202ThreadAA extends Thread{
	private P202Service service;
	public P202ThreadAA(P202Service service){
		super();
		this.service = service;
	}
	@Override
	public void run(){
		service.methodA();
	}
}
class P202ThreadB extends Thread{
	private P202Service service;
	public P202ThreadB(P202Service service){
		this.service = service;
	}
	@Override
	public void run(){
		service.methodB();
	}
}
class P202ThreadBB extends Thread{
	private P202Service service;
	public P202ThreadBB(P202Service service){
		this.service = service;
	}
	@Override
	public void run(){
		service.methodB();
	}
}
public class P202 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P202Service service = new P202Service();
		P202ThreadA a = new P202ThreadA(service);
		a.setName("A");
		a.start();
		P202ThreadAA aa = new P202ThreadAA(service);
		aa.setName("AA");
		aa.start();
		P202ThreadB b = new P202ThreadB(service);
		b.setName("B");
		b.start();
		P202ThreadBB bb = new P202ThreadBB(service);
		b.setName("BB");
		bb.start();
	}

}
