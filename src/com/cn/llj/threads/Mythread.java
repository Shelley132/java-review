package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��15�� ����7:46:32
 * ��˵����
 * �߳�ʹ����ʾ
 */
public class Mythread extends Thread{
	public static int i = 0;
	public void run(){
		System.out.println("�����˵�"+(i++)+"�̣߳�");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mythread thread = new Mythread();
		thread.start();
		Mythread thread2 = new Mythread();
		thread2.start();
	}

}
