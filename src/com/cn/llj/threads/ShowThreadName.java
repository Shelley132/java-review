package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��15�� ����9:04:00
 * ��˵����
 */
public class ShowThreadName extends Thread{

	public ShowThreadName(){
		super();
	}
	public ShowThreadName(String name){
		super(name);
	}
	public void run(){
		System.out.println("����̵߳�������"+this.getName());
	}
	public static void main(String[] args) {
		new ShowThreadName().start();//thread-0
		new ShowThreadName("ThreadName").start();//thread-1
		
		Thread currentThread = Thread.currentThread();
		String threadName = currentThread.getName();
		System.out.println("Now threadName��"+threadName);
		
		
		
	}

}
