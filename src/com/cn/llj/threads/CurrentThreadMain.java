package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��16�� ����8:49:26
 * ��˵����
 * ��CurrentThreadNamePrinter�����ʹ��
 */
public class CurrentThreadMain {

	public static void main(String[] args) {
		Runnable runnable = new Runnable(){
			public void run(){
				CurrentThreadNamePrinter printer = new CurrentThreadNamePrinter();
				printer.printCurrentThreadName();
			}
		};
		Thread thread = new Thread(runnable,"�߳�-1");
		thread.start();

	}

}
