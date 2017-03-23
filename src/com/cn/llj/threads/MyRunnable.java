package com.cn.llj.threads;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年1月15日 下午8:12:25
 * 类说明：
 */
public class MyRunnable implements Runnable{//实现Runnable接口

	public static void main(String[] args) {
		// 创建一个MyRunnable类的实例，其中MyRunnable实现了Runnable接口
		MyRunnable runnable = new MyRunnable();
		Thread thread = new Thread(runnable);//调用Thread相应的构造方法，传入参数
		thread.start();//启动线程
		System.out.println(thread.getId()+thread.getName());
		
	}

	@Override
	public void run() {//实现run()方法
		
		System.out.println("这里是线程！");//输出一句话
	}//run()方法结束

}
