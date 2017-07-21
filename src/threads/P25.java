package threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午4:51:59
*/
public class P25 extends Thread{

	public void run() {
		super.run();
		try {
			for (int i = 0; i < 10000; i++) {
				System.out.println("i=" + (i + 1));
				if (this.isInterrupted()) {
					System.out.println("已经是停止状态了！我要退出了！");
					throw new InterruptedException();
				}
			}
			System.out.println("我被输出，如果此代码是for又继续运行，线程并未停止！");
		} catch (InterruptedException e) {
			System.out.println("进run方法中的catch块了");
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			P25 myThread = new P25();
			myThread.start();
			Thread.sleep(20);
		//	System.out.println(Thread.currentThread().getName());
			myThread.interrupt();
			System.out.println("是否停止1？"+ myThread.isInterrupted());
			System.out.println("是否停止2？"+ myThread.isInterrupted());
			//Thread.currentThread().interrupt();
			//System.out.println("是否停止1？"+ myThread.interrupted());
			//System.out.println("是否停止2？"+ myThread.interrupted());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}

}
