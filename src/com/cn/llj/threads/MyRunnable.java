package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��15�� ����8:12:25
 * ��˵����
 */
public class MyRunnable implements Runnable{//ʵ��Runnable�ӿ�

	public static void main(String[] args) {
		// ����һ��MyRunnable���ʵ��������MyRunnableʵ����Runnable�ӿ�
		MyRunnable runnable = new MyRunnable();
		Thread thread = new Thread(runnable);//����Thread��Ӧ�Ĺ��췽�����������
		thread.start();//�����߳�
		System.out.println(thread.getId()+thread.getName());
		
	}

	@Override
	public void run() {//ʵ��run()����
		
		System.out.println("�������̣߳�");//���һ�仰
	}//run()��������

}
