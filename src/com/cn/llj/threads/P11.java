package com.cn.llj.threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午1:50:57
*/
public class P11 extends Thread {

	private int count =5;
	synchronized public void run(){
		super.run();
		count--;
		System.out.println("由"+ this.currentThread().getName() + "计算得到count="+ count);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P11 thread = new P11();
		Thread t1 = new Thread(thread, "A");
		Thread t2 = new Thread(thread, "B");
		Thread t3 = new Thread(thread, "C");
		Thread t4 = new Thread(thread, "D");
		Thread t5 = new Thread(thread, "E");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
