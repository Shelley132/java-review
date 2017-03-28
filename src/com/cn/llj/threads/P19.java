package com.cn.llj.threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午4:27:24
*/
public class P19 extends Thread{
	public P19(){
		System.out.println("CountOperate---begin");
		System.out.println("Thread.currentThread().getName()="+ Thread.currentThread().getName());
		System.out.println("Thread.currentThread().isAlive()="+ Thread.currentThread().isAlive());
		//这里的this其实就是P19，那么初始化时，P19还没有启动线程，所以非活动状态
		System.out.println(this.getClass().getName());
		System.out.println("this.getName()="+ this.getName());
		System.out.println("this.isAlive()="+ this.isAlive());
		System.out.println("CountOperate---end");
	}
	public void run(){
		System.out.println("run---begin");
		System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
		System.out.println("Thread.currentThread().isAlive()="+ Thread.currentThread().isAlive());
		
		System.out.println(this.getClass().getName());
		System.out.println("this.getName()="+ this.getName());
		System.out.println("this.isAlive()="+ this.isAlive());
		System.out.println("run---end");
	}
	
	public static void main(String[] args) {
		P19 c = new P19();
		
		Thread t1 = new Thread(c);
		System.out.println("main begin t1 isAlive="+t1.isAlive());
		t1.setName("A");
		t1.start();
		//c.start();
		System.out.println("main end t1 isAlive=" + t1.isAlive());
	}
}
