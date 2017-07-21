package threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午7:40:03
*/
class P49A extends Thread{
	private int count = 0;
	public int getCount(){
		return count;
	}
	public void run(){
		while(true){
			count++;
		}
	}
}
class P49B extends Thread{
	private int count = 0;
	public int getCount(){
		return count;
	}
	public void run(){
		while(true){
			count++;
		}
	}
}
public class P49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			P49A t1 = new P49A();
			t1.setPriority(Thread.NORM_PRIORITY-3);
			
			P49B t2 = new P49B();
			t2.setPriority(Thread.NORM_PRIORITY+3);
			t1.start();
			t2.start();
			
			Thread.sleep(3000);
			
			System.out.println("t1="+ t1.getCount());
			System.out.println("t2="+ t2.getCount());
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
