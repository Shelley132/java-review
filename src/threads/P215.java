package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LLJ
 * @version 2017年4月9日下午6:21:52
*/
class P215Service{
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean hasValue = false;
	public void set(){
		try{
			lock.lock();
			while(hasValue == true){
				System.out.println("有可能**连续");
				condition.await();
			}
			System.out.println("*");
			hasValue = true;
			condition.signal();
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void get(){
		try{
			lock.lock();
			while(hasValue == false){
				System.out.println("有可能--连续");
				condition.await();
			}
			System.out.println("-");
			hasValue = false;
			condition.signal();
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
}
class P215ThreadA extends Thread{
	private P215Service service;
	public P215ThreadA(P215Service service){
		super();
		this.service = service;
	}
	
	public void run(){
		service.set();
	}
}
class P215ThreadB extends Thread{
	private P215Service service;
	public P215ThreadB(P215Service service){
		super();
		this.service = service;
	}
	
	public void run(){
		service.get();
	}
}

public class P215 {
public static void main(String[] args) {
	P215Service service = new P215Service();
	P215ThreadA[] ta = new P215ThreadA[10];
	P215ThreadB[] tb = new P215ThreadB[10];
	for(int i = 0; i< 10; i++){
		ta[i] = new P215ThreadA(service);
		tb[i] = new P215ThreadB(service);
		ta[i].start();
		tb[i].start();
	}
}
}
