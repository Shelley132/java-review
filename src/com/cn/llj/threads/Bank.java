package com.cn.llj.threads;

import java.util.Timer;

/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��17�� ����12:25:37 ��˵����
 */
public class Bank{

	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();
		TicketWindow tw = new TicketWindow();
		for(int i = 0; i< 5; i++){
			Thread thread = new Thread(tw);
			thread.start();
		}
		
		long time2 = System.currentTimeMillis();
		System.out.println(time2-time1);
	}

}

class TicketWindow  implements Runnable {
	private int max_value = 0;
	private Object  lock = new Object();
	@Override
	public void run() {
		synchronized (lock) {
			while (true) {
				if (max_value > 50) 
					break;
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ":" + (max_value++));
			}
		}
		
		
	}
}