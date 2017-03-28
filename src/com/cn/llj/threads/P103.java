package com.cn.llj.threads;

/**
 * @author LLJ
 * @version 2017年3月26日上午10:55:00
 */
class P103Service {
	public static void print(Object string) {
		try {
			synchronized (string) {
				while (true) {
					System.out.println(Thread.currentThread().getName());

					Thread.sleep(1000);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class P103A extends Thread {
	private P103Service service;

	public P103A(P103Service service) {
		super();
		this.service = service;
	}

	public void run() {
		super.run();
		service.print("AA");
	}
}

class P103B extends Thread {
	private P103Service service;

	public P103B(P103Service service) {
		super();
		this.service = service;
	}

	public void run() {
		service.print("AA");
	}
}

// 线程A和线程B持有相同的对象锁，常量字符串AA
public class P103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P103Service service = new P103Service();
		P103A a = new P103A(service);
		a.setName("A");
		a.start();
		P103B b = new P103B(service);
		b.setName("B");
		b.start();
	}

}
