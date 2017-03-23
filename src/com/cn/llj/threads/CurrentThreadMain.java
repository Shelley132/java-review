package com.cn.llj.threads;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年1月16日 上午8:49:26
 * 类说明：
 * 对CurrentThreadNamePrinter类测试使用
 */
public class CurrentThreadMain {

	public static void main(String[] args) {
		Runnable runnable = new Runnable(){
			public void run(){
				CurrentThreadNamePrinter printer = new CurrentThreadNamePrinter();
				printer.printCurrentThreadName();
			}
		};
		Thread thread = new Thread(runnable,"线程-1");
		thread.start();

	}

}
