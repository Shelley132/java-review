package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��20�� ����7:18:14
 * ��˵�����������������ߵĳ���ģ�⣬��xֵ��ʱ���Ͳ���ȷ��
 */
public class ProductAndCustomer {
		final static NumberFactory numberFactory = new NumberFactory();
		
		public static void main(String[] args) {
			new Thread(new Runnable(){
				public void run(){
					while(true){
						numberFactory.create();
					}
				}
			}).start();
			
			new Thread(new Runnable(){
				public void run(){
					while(true){
						numberFactory.consume();
					}
				}
			}).start();
		}

	}

	class NumberFactory{
		private int i = 0;
		private Object lock = new Object();
		/**
		 * �÷���ģ�����������
		 * */
		public void create(){
			synchronized (lock){
				System.out.println("create...i-" + i++);
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