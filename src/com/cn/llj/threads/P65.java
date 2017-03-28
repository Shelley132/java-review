package com.cn.llj.threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午8:56:56
*/

class Service{
	synchronized public void service1(){
		System.out.println("Service1");
		service2();
	}
	synchronized public void service2(){
		System.out.println("Service2");
		service3();
	}
	synchronized public void service3(){
		System.out.println("Service3");
	}
}

public class P65 extends Thread{
	private Service service;
	public P65(Service service){
		this.service = service;
	}
public void run(){
	service.service1();
	service.service2();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P65 t = new P65(new Service());
		t.start();
	}

}
