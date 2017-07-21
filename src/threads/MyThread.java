package threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午12:53:22
*/
public class MyThread extends Thread{
	@Override
	public void run(){
		for(int i = 0; i < 10; i++){
			try {
				int time = (int) (Math.random()* 10000);
				Thread.sleep(time);
				System.out.println("sleep="+time + "\trun="+ Thread.currentThread().getName()+" "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
