package com.cn.llj.threads;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年1月15日 下午9:04:00
 * 类说明：
 */
public class ShowThreadName extends Thread{

	public ShowThreadName(){
		super();
	}
	public ShowThreadName(String name){
		super(name);
	}
	public void run(){
		System.out.println("这个线程的名字是"+this.getName());
	}
	public static void main(String[] args) {
		new ShowThreadName().start();//thread-0
		new ShowThreadName("ThreadName").start();//thread-1
		
		Thread currentThread = Thread.currentThread();
		String threadName = currentThread.getName();
		System.out.println("Now threadName："+threadName);
		
		
		
	}

}
