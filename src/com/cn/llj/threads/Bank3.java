package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��20�� ����4:39:59
 * ��˵����ʹ��static��ʵ���߳�ͬ��
 */
public class Bank3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketWindow3 tw3 = new TicketWindow3();
		Thread t1 = new Thread(tw3);
		Thread t2 = new Thread(tw3);
		
		t1.start();
		System.out.println("change for now......");
		tw3.change();
		t2.start();
	}

}

class TicketWindow3 implements Runnable{
	private static int max_value = 0;
	private boolean flag = true;
	
	@Override
	public void run() {
		if(flag){
			while(true){
				synchronized(TicketWindow3.class){
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
	private synchronized static boolean ticket(){
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
		
		this.flag = false;
	}
}