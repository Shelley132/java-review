package com.cn.llj.threads;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年1月15日 下午8:40:26
 * 类说明：
 */
public class UseRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new Runnable(){
			public void run(){
				System.out.println("这是在另一个线程中执行的代码。");
			}
		});
		thread.start();
	}

}
