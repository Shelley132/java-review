package threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午6:35:55
*/
public class P31 extends Thread{
public void run(){
	super.run();
	try{
		System.out.println("run begin!");
		Thread.sleep(200000);
		System.out.println("run end!");
	}catch(InterruptedException e){
		System.out.println("在沉睡中被停止！进入catch！"+ this.isInterrupted());
		e.printStackTrace();
	}
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			P31 thread = new P31();
			thread.start();
			Thread.sleep(200);
			thread.interrupt();
			thread.resume();
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		//System.exit(0);
	}

}
