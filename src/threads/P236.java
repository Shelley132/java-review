package threads;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author LLJ
 * @version 2017年4月10日下午8:54:57
 * 读读共享
*/
class P236Service{
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	public void read(){
		try{
			lock.readLock().lock();
			System.out.println("获得读锁 "+ Thread.currentThread().getName()+" "+ System.currentTimeMillis());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally{
			lock.readLock().unlock();
		}
	}
	public void write(){
		try{
			lock.writeLock().lock();
			System.out.println("获得写锁 " + Thread.currentThread().getName()+ " "+ System.currentTimeMillis());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally{
			lock.writeLock().unlock();
		}
	}
}
class P236ThreadA extends Thread{
	private P236Service service;
	public P236ThreadA(P236Service service){
		super();
		this.service = service;
	}
	public void run(){
		service.read();
	}
}
class P236ThreadB extends Thread{
	private P236Service service;
	public P236ThreadB(P236Service service){
		super();
		this.service = service;
	}
	public void run(){
		service.write();
	}
}

public class P236 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P236Service service = new P236Service();
		P236ThreadA ta = new P236ThreadA(service);
		P236ThreadB tb = new P236ThreadB(service);
		ta.setName("A");
		tb.setName("B");
		ta.start();
		tb.start();
	}

}
