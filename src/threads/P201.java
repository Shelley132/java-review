package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LLJ
 * @version 2017年4月4日下午4:28:59
*/
class P201Service{
	private Lock lock = new ReentrantLock();
	public void testMethod(){
		lock.lock();
		for(int i = 0; i< 5; i++){
			System.out.println("ThreadName = " + Thread.currentThread().getName()+ " " + (i+1));
		}
		lock.unlock();
	}
}
class P201Thread extends Thread{
	private P201Service service;
	public P201Thread(P201Service service){
		super();
		this.service = service;
	}
	@Override
	public void run(){
		service.testMethod();
	}
}
public class P201 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P201Service service = new P201Service();
		P201Thread t1 = new P201Thread(service);
		P201Thread t2 = new P201Thread(service);
		P201Thread t3 = new P201Thread(service);
		P201Thread t4 = new P201Thread(service);
		P201Thread t5 = new P201Thread(service);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
