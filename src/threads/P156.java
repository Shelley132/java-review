package threads;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LLJ
 * @version 2017年4月3日下午4:03:34
 */
class P156Add {
	private String lock;

	public P156Add(String lock) {
		super();
		this.lock = lock;
	}

	public void add() {
		synchronized (lock) {
			P156ValueObject.list.add("anyString");
			System.out.println(P156ValueObject.list.size());
			lock.notifyAll();
		}
	}

}

class P156Subtract {
	private String lock;

	public P156Subtract(String lock) {
		super();
		this.lock = lock;
	}

	public void subtract() {
		try {
			synchronized(lock){
				while (P156ValueObject.list.size() == 0) {
					System.out.println("wait begin ThreadName = " + Thread.currentThread().getName());
					lock.wait();
					System.out.println("wait end ThreadName = " + Thread.currentThread().getName());
				}
				P156ValueObject.list.remove(0);
				System.out.println("list size = " + P156ValueObject.list.size());
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class P156ValueObject {
	public static List list = new ArrayList();
}

class P156ThreadAdd extends Thread{
	private P156Add p;
	public P156ThreadAdd(P156Add p){
		super();
		this.p = p;
	}
	public void run(){
		//Add中封装业务逻辑，而ThreadAdd中实现多线程
		p.add();
	}
}

class P156ThreadSubtract extends Thread{
	private P156Subtract p;
	public P156ThreadSubtract(P156Subtract p){
		this.p = p;
	}
	public void run(){
		p.subtract();
	}
}
public class P156 {
public static void main(String[] args) throws InterruptedException {
	String lock = new String("");
	P156Add add = new P156Add(lock);
	P156Subtract subtract = new P156Subtract(lock);
	
	P156ThreadSubtract subtractThread = new P156ThreadSubtract(subtract);
	subtractThread.setName("subtractThread1");
	subtractThread.start();
	
	P156ThreadSubtract subtractThread2 = new P156ThreadSubtract(subtract);
	subtractThread2.setName("subtractThread2");
	subtractThread2.start();
	
	Thread.sleep(1000);
	P156ThreadAdd addThread = new P156ThreadAdd(add);
	addThread.setName("addThread");
	addThread.start();
	
	
	
}
}
