package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��16�� ����8:51:25
 * ��˵����
 * ��ӡ��ǰ�߳�����
 */
public class CurrentThreadNamePrinter extends Thread{
	public CurrentThreadNamePrinter(){
		super();
	}
	public CurrentThreadNamePrinter(String name){
		super(name);
	}
	/**
	 * �÷���ʵ���˴�ӡ��ǰ�߳����ֵĹ��ܣ���Ҫʹ����Thread.currentThread()��
	 */
	public void printCurrentThreadName(){
		Thread currentThread = Thread.currentThread();
		String threadName = currentThread.getName();
		System.out.println("��ǰ�߳�Ϊ��"+threadName);
	}
}
