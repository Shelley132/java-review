package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��15�� ����8:40:26
 * ��˵����
 */
public class UseRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new Runnable(){
			public void run(){
				System.out.println("��������һ���߳���ִ�еĴ��롣");
			}
		});
		thread.start();
	}

}
