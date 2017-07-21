package threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午2:17:05
*/
public class P14 extends Thread{
	private int i = 5;
	public void run(){
		//println方法是线程安全的，但是i--则是在进入println之前执行的，i--并不线程安全。
		System.out.println("i="+(i--)+" threadName=" + Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P14 run = new P14();
		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		Thread t3 = new Thread(run);
		Thread t4 = new Thread(run);
		Thread t5 = new Thread(run);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
