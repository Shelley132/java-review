package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��16�� ����9:27:24
 * ��˵����
 * ʹ��Thread.sleep()����ʵ���ڸ���˼��ʱ��֮��������
 */
public class AddingWithSleep {
	
	public void addWithThink(){
		int a = (int) (Math.random() * 100);
		int b = (int) (Math.random() * 100);
		System.out.println("����5�����ڼ�����������������ĺͣ�"+a+"+"+b);
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("ִ�е�ǰ������߳�����"+currentThreadName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {			
			System.out.println("�������г���������Ϣ��"+e.getMessage());
			return;
		}
		int result = a+b;
		System.out.println(a+"+"+b+"����������"+result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable runnable = new Runnable(){
			public void run(){
				AddingWithSleep aws = new AddingWithSleep();
				aws.addWithThink();
			}
		};
		Thread thread = new Thread(runnable,"�ӷ������߳�");
		thread.start();
		System.out.println("���߳̽����ˣ�");
		//new AddingWithSleep().addWithThink();
	}

}
