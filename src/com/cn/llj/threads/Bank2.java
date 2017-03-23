package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��19�� ����7:25:48
 * ��˵�������߳�ʵ�֣�newһ��ʵ����new���Thread����ЩThread������һ��ʵ����
 */
public class Bank2 {

	public static void main(String[] args) {
		
		TicketWindow2  tw = new TicketWindow2();
		Thread t1 = new Thread(tw);
		Thread t2 = new Thread(tw);
		Thread t3 = new Thread(tw);
		
		t1.start();
		t2.start();
		t3.start();
	}

}

class TicketWindow2 implements Runnable{
	private int max_value = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
			if(ticket()){
				break;
		}
	}
	private synchronized boolean ticket(){
		if(max_value > 200){
			return true;
		}else{
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":" + (max_value++));
			return false;
		}
		
	}
}
