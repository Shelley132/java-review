package threads;
/**
 * @author LLJ
 * @version 2017年4月4日下午3:18:47
 * ThreadLocal类的使用，验证隔离性
*/
class P191Tools{
	public static ThreadLocal t1 = new ThreadLocal();
}
class P191ThreadA extends Thread{
	public void run(){
		try{
			for(int i = 0; i < 100; i++){
				P191Tools.t1.set("Thread A " + (i+1));
				System.out.println("ThreadA get Value = " + P191Tools.t1.get());
				Thread.sleep(200);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}	
}
class P191ThreadB extends Thread{
	public void run(){
		try{
			for(int i =0; i< 100; i++){
				P191Tools.t1.set("Thread B " + (i+1));
				System.out.println("ThreadB get Value = " + P191Tools.t1.get());
				Thread.sleep(200);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

public class P191 {
	//public static ThreadLocal t1 = new ThreadLocal();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*if(t1.get() == null){
			System.out.println("从未放过值");
			t1.set("我的值");
		}
		System.out.println(t1.get());
		System.out.println(t1.get());*/
		
		try{
			P191ThreadA a = new P191ThreadA();
			P191ThreadB b = new P191ThreadB();
			a.start();
			b.start();
			for(int i = 0; i< 100; i++){
				P191Tools.t1.set("Main " + (i+1));
				System.out.println("Main get Value = " + P191Tools.t1.get());
				Thread.sleep(200);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
