package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��16�� ����10:18:03
 * ��˵����
 */
public class PrintNumberThread extends Thread{
	private int times;
	public PrintNumberThread(int times){
		this.times = times;
	}
	public void run(){
		for(int i = 0; i < times; i++){
			String content = this.getName() + "\t:\t" + i;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println("�������������Ϣ��"+e.getMessage());
				return;
			}
			System.out.println(content);
		}
		System.out.println("�߳�\""+this.getName()+"\"�����ˣ�");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintNumberThread thread = new PrintNumberThread(5);
		PrintNumberThread thread2 = new PrintNumberThread(8);
		thread.setName("�߳�1");
		thread2.setName("�߳�2");
		thread.start();
		thread2.start();
	}

}
