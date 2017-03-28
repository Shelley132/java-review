package com.cn.llj.threads;
/**
 * @author LLJ
 * @version 2017年3月26日下午1:36:41
*/
class P124Thread extends Thread{
	volatile public static int count = 0;
	//这里如果是实例方法，则结果也无法保证是正确的，因为锁不是一个啊,static修饰的方法锁是P124Thread类，而实例方法的锁则是对象。
	synchronized private static void addCount(){
		for(int i = 0 ; i< 100; i++)
			count++;
		System.out.println("count="+count);
	}
	public void run(){
		addCount();
	}
}

public class P124Volatile {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		P124Thread[] threads = new P124Thread[100];
		for(int i = 0; i < 100; i++){
			threads[i] = new P124Thread();
		}
		for(int i = 0; i < 100; i++){
			threads[i].start();
		}
		Thread.sleep(2000);
		System.out.println(P124Thread.count);
	}

}
