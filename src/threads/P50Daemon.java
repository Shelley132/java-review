package threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午7:59:51
*/
public class P50Daemon extends Thread{
	private int i = 0;
	public void run(){
		try{
			while(true){
				i++;
				System.out.println("i="+ i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			P50Daemon thread = new P50Daemon();
			thread.setDaemon(true);
			thread.start();
			
			Thread.sleep(5000);
			System.out.println("我离开thread对象也不再打印了，也就是停止了！");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
