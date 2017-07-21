package threads;

import java.util.Random;

/**
 * @author LLJ
 * @version 2017年3月25日下午7:19:39
*/
public class P45 extends Thread{

	public void run(){
		long beginTime = System.currentTimeMillis();
		long addResult = 0;
		for(int j = 0; j < 10 ;j++){
			for(int i = 0; i< 50000; i++){
				Random random = new Random();
				random.nextInt();
				addResult = addResult + i;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("☆☆☆☆☆ thread1 use time=" + (endTime-beginTime));
	}
	public static void main(String[] args) {
		for(int i = 0; i< 50; i++){
			P45 t1 = new P45();
			t1.setPriority(5);
			t1.start();
			P44 t2 = new P44();
			t2.setPriority(6);
			t2.start();
		}
	}
	
}

class P44 extends Thread{
	public void run(){
		long beginTime = System.currentTimeMillis();
		long addResult = 0;
		for(int j = 0; j < 10 ;j++){
			for(int i = 0; i< 50000; i++){
				Random random = new Random();
				random.nextInt();
				addResult = addResult + i;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("△△△△△   thread2  use time=" + (endTime-beginTime));
	}
}