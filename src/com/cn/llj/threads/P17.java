package com.cn.llj.threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午3:36:38
*/
public class P17 extends Thread{
	public P17(){
		System.out.println("CountOperate---begin");
		System.out.println("Thread.currentThread().getName()="+ Thread.currentThread().getName());
		System.out.println("this.getName()="+ this.getName());
		System.out.println("CountOperate---end");
	}
	public void run(){
		System.out.println("run---begin");
		System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
		System.out.println("this.getName()="+ this.getName());
		System.out.println("run---end");
	}
	//在P17创建实例c时，只是调用了构造器， 尚未启动，故当前线程为main，之后，创建了一个线程，并启动，这时才执行了run方法。
	public static void main(String[] args) {
		P17 c = new P17();
		Thread t1 = new Thread(c);
		t1.setName("A");
		t1.start();
	}

}
