package com.cn.llj.threads;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年1月16日 上午8:51:25
 * 类说明：
 * 打印当前线程名字
 */
public class CurrentThreadNamePrinter extends Thread{
	public CurrentThreadNamePrinter(){
		super();
	}
	public CurrentThreadNamePrinter(String name){
		super(name);
	}
	/**
	 * 该方法实现了打印当前线程名字的功能，主要使用了Thread.currentThread()。
	 */
	public void printCurrentThreadName(){
		Thread currentThread = Thread.currentThread();
		String threadName = currentThread.getName();
		System.out.println("当前线程为："+threadName);
	}
}
