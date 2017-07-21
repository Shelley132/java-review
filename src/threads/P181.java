package threads;
/**
 * @author LLJ
 * @version 2017年4月4日下午2:36:42
*/
class P181Thread extends Thread{
	public void run(){
		try{
			int secondValue = (int)(Math.random()* 10000);
			System.out.println(secondValue);
			Thread.sleep(secondValue);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
public class P181 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		P181Thread t = new P181Thread();
		t.start();
		t.join();
		System.out.println("我在t对象执行完毕后再执行，我做到了");
	}

}
