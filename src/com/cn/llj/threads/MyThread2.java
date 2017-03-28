package com.cn.llj.threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午1:30:13
*/
public class MyThread2 extends Thread {
	private int count = 5;
	public MyThread2(String name){
		super();
		this.setName(name);
	}
	public void run(){
		//super.run();
		while(count>0){
			count--;
			System.out.println("由"+ this.currentThread().getName()+ "计算，count=" + count);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread2 a = new MyThread2("A");
		MyThread2 b = new MyThread2("B");
		MyThread2 c = new MyThread2("C");
		MyThread2 d = new MyThread2("D");
		a.start();
		b.start();
		c.start();
		d.start();
		
	}

}
