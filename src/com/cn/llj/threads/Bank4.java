package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��20�� ����4:39:59
 * ��˵����ʹ��this��ʵ���߳�ͬ��
 */
public class Bank4 {

	public static void main(String[] args) {
		TicketWindow4 tw4 = new TicketWindow4();
		Thread t1 = new Thread(tw4);
		Thread t2 = new Thread(tw4);
		
		t1.start();
		tw4.change();
		t2.start();
	}

}

class TicketWindow4 implements Runnable{
	private static int max_value = 0;
	private boolean flag = true;
	//private Object lock = new Object();
	@Override
	public void run() {
		if(flag){
			while(true){
				synchronized(this){
					if(max_value > 500){
						break;
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":lock..." + max_value++);
				}
			}
		}else{
			while(true){
				if(ticket())
					break;
			}
		}
		
	}
	private synchronized boolean ticket(){
		if(max_value > 500){
			return true;
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ": method..." + max_value++);
		return false;
	}
	public void change(){
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("change for now......");
		this.flag = false;
	}
}