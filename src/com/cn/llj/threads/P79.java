package com.cn.llj.threads;
/**
 * @author LLJ
 * @version 2017年3月26日上午9:22:54
*/
class P79Service{
	public void methodA(){
		synchronized(this){
			try {
				System.out.println("A begin time="+ System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println("A end time=" + System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void methodB(){
		synchronized(this){
			System.out.println("B begin time="+ System.currentTimeMillis());
			System.out.println("B end time="+ System.currentTimeMillis());
		}
	}
}

class P79A extends Thread{
	private P79Service object;
	public P79A(P79Service object){
		super();
		this.object = object;
	}
	public void run(){
		super.run();
		object.methodA();
	}
}
class P79B extends Thread{
	private P79Service object;
	public P79B(P79Service object){
		super();
		this.object = object;
	}
	public void run(){
		super.run();
		object.methodB();
	}
}
public class P79 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P79Service obj = new P79Service();
		P79A a = new P79A(obj);
		a.start();
		//因为它俩持有的锁是同一个对象锁，都是obj的锁
		//A begin time=1490491936686
		//A end time=1490491938688
		//B begin time=1490491938688
		//B end time=1490491938688
		
		P79B b = new P79B(obj);
		b.start();
	}

}
