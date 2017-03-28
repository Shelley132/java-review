package com.cn.llj.threads;
/**
 * @author LLJ
 * @version 2017年3月26日下午12:34:25
*/
class P121Thread extends Thread{
	private volatile boolean isRunning = true;
	public boolean isRunning(){
		return isRunning;
	}
	public void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	public void run(){
		System.out.println("进入run了");
		while(isRunning == true){
		}
		System.out.println("线程被停止了！");
	}
}

public class P121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			P121Thread t = new P121Thread();
			t.start();
			Thread.sleep(1000);
			t.setRunning(false);
			System.out.println("isRunning已经被赋值为false！");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
