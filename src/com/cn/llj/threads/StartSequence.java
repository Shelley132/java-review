package com.cn.llj.threads;
/**
 * 执行start()方法的顺序并不代表线程启动的顺序
 * @author LLJ
 * @version 2017年3月25日下午1:11:09
*/
class MyThread1 extends Thread{
	private int i;
	public MyThread1(int i){
		super();
		this.i= i;
	}
	public void run(){
		System.out.println(i);
	}
}
public class StartSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread1 t1 = new MyThread1(1);
		MyThread1 t2 = new MyThread1(2);
		MyThread1 t3 = new MyThread1(3);
		MyThread1 t4 = new MyThread1(4);
		MyThread1 t5 = new MyThread1(5);
		MyThread1 t6 = new MyThread1(6);
		MyThread1 t7 = new MyThread1(7);
		MyThread1 t8 = new MyThread1(8);
		MyThread1 t9 = new MyThread1(9);
		MyThread1 t10 = new MyThread1(10);
		MyThread1 t11 = new MyThread1(11);
		MyThread1 t12 = new MyThread1(12);
		MyThread1 t13 = new MyThread1(13);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
		t12.start();
		t13.start();
		
	}

}
