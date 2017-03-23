package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��20�� ����7:18:14
 * ��˵�����������������ߵ�ģ�⣬
 */
public class ProductAndCustomer2 {
		
	public static void main(String[] args) {
	
	}
}

class NumberFactory2{
	private int i = 0;
	private Object lock = new Object();
	private boolean created = false;
	/**
	 * �÷���ģ�����������
	 * */
	public void create(){
		synchronized(lock){
			if(!created){
				i++;
				System.out.println("create:" + i);
				lock.notify();//��ǰ���߳��Ѿ���������Դ��ռ��
				created = true;
			}
			
		}
	}
	/**
	 * �÷���ģ�����������
	 * */
	public void consume(){
		synchronized(lock){
			System.out.println("consume...i-" + i);
		}
	}
}