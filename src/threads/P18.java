package threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午4:08:58
*/
public class P18 extends Thread{

	public void run(){
		System.out.println("run="+ this.isAlive());
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		P18 mythread = new P18();
		System.out.println("begin="+mythread.isAlive());
		mythread.start();
		Thread.sleep(1000);//主线程睡了1000ms，它重新醒来的时候，mythread线程已经结束了，不是活动状态
		System.out.println("end="+ mythread.isAlive());
	}

}
