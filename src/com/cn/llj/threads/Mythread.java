package com.cn.llj.threads;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年1月15日 下午7:46:32
 * 类说明：
 * 线程使用演示
 */
public class Mythread extends Thread{
	public static int i = 0;
	public void run(){
		System.out.println("调用了第"+(i++)+"线程！");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mythread thread = new Mythread();
		thread.start();
		Mythread thread2 = new Mythread();
		thread2.start();
	}

}
