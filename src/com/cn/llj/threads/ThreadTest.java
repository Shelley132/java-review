package com.cn.llj.threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午12:45:00
*/
public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MyThread thread = new MyThread();
			thread.setName("myThread");
			thread.start();
			for(int i =0; i< 10; i++){
				int time = (int) (Math.random()* 10000);
				Thread.sleep(time);
				System.out.println("sleep="+time + "\tmain="+ Thread.currentThread().getName()+" "+i);
			} 
		}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
