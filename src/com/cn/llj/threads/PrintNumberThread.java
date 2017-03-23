package com.cn.llj.threads;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年1月16日 上午10:18:03
 * 类说明：
 */
public class PrintNumberThread extends Thread{
	private int times;
	public PrintNumberThread(int times){
		this.times = times;
	}
	public void run(){
		for(int i = 0; i < times; i++){
			String content = this.getName() + "\t:\t" + i;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.out.println("程序出错，错误信息："+e.getMessage());
				return;
			}
			System.out.println(content);
		}
		System.out.println("线程\""+this.getName()+"\"结束了！");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintNumberThread thread = new PrintNumberThread(5);
		PrintNumberThread thread2 = new PrintNumberThread(8);
		thread.setName("线程1");
		thread2.setName("线程2");
		thread.start();
		thread2.start();
	}

}
