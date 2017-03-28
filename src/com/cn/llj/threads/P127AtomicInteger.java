package com.cn.llj.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LLJ
 * @version 2017年3月26日下午1:59:39
*/
class AddCountThread extends Thread{
	private AtomicInteger count = new AtomicInteger(0);
	public void run(){
		for(int i = 0; i < 10000; i++){
			System.out.println(count.incrementAndGet());
		}
	}
}

public class P127AtomicInteger {
public static void main(String[] args) {
	AddCountThread countService = new AddCountThread();
	Thread t1 = new Thread(countService);
	t1.start();
	Thread t2 = new Thread(countService);
	t2.start();
	Thread t3 = new Thread(countService);
	t3.start();
	Thread t4 = new Thread(countService);
	t4.start();
	Thread t5 = new Thread(countService);
	t5.start();
}
}
