package com.cn.llj.threads;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年1月16日 上午9:27:24
 * 类说明：
 * 使用Thread.sleep()方法实现在给定思考时间之后给出结果
 */
public class AddingWithSleep {
	
	public void addWithThink(){
		int a = (int) (Math.random() * 100);
		int b = (int) (Math.random() * 100);
		System.out.println("请在5秒钟内计算出下面两个整数的和："+a+"+"+b);
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("执行当前代码的线程名："+currentThreadName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {			
			System.out.println("程序运行出错，错误信息："+e.getMessage());
			return;
		}
		int result = a+b;
		System.out.println(a+"+"+b+"的运算结果是"+result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable runnable = new Runnable(){
			public void run(){
				AddingWithSleep aws = new AddingWithSleep();
				aws.addWithThink();
			}
		};
		Thread thread = new Thread(runnable,"加法测试线程");
		thread.start();
		System.out.println("主线程结束了！");
		//new AddingWithSleep().addWithThink();
	}

}
