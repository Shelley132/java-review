package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��16�� ����8:00:30
 * ��˵����
 * �������
 */
public class ThreadTest1 {
	
	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest("t1");
		ThreadTest t2 = new ThreadTest("t2",200);
		t1.start();
		t2.start();
	}

}

class ThreadTest extends Thread{
	private final static int DEFAULT_VALUE = 100;
	private int maxValue = 0;
	private String threadName = "";
	public ThreadTest(String threadName){
		this(threadName,DEFAULT_VALUE);
	}
	public ThreadTest(String threadName, int defaultValue) {
		this.maxValue = defaultValue;
		this.threadName = threadName;
	}
	public void run(){
		int i = 0;
		while(i<maxValue){
			i++;
			System.out.println("Thread:"+threadName+":"+i);
		}
	}
}