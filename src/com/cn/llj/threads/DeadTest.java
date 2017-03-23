package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��20�� ����5:38:45
 * ��˵����������ʾ����
 */
public class DeadTest {

	public static void main(String[] args) {
		
		final Dead dead = new Dead();
		//ʹ�������ڲ�������һ���̣߳����ڵ��÷���A
		new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					dead.methodA();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}			
			}			
		}).start();
		//ʹ�������ڲ�������һ���̣߳����ڵ��÷���B
		new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					dead.methodB();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}			
			}			
		}).start();
	}
}
/**
 * �����������߳�A��B������A����B��Ҫ��������B����A��Ҫ�������������ڵȴ������ͷ�����Ҫ���������������������������������ķ��� 
 * */
class Dead{
	private Object lock = new Object();
	private int x = 0;	
	/**
	 * �÷�����ʹ���Զ���������ʹ��this��
	 */
	public void methodA(){
		synchronized (lock){
			synchronized(this){
				System.out.println("method a..."+ (x++));
			}
		}
	}
	/**
	 * �÷�����ʹ��this������ʹ���Զ�����
	 */
	public void methodB(){
		synchronized(this){
			synchronized(lock){
				System.out.println("method b..."+ (x++));
			}
		}
	}
	
}