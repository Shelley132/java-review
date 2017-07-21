package threads;

import java.util.Date;

/**
 * @author LLJ
 * @version 2017年4月4日下午3:48:26
*/
class InheritableThreadLocalExt extends InheritableThreadLocal{
	@Override
	protected Object initialValue(){
		return new Date().getTime();
	}
	protected Object childValue(Object parentValue){
		return parentValue + " 我在子线程加的~！";
	}
}
class P195Tools{
	public static InheritableThreadLocalExt tl = new InheritableThreadLocalExt();
}
class P195Thread extends Thread{
	@Override
	public void run(){
		try{
			for(int i = 0; i< 10; i++){
				System.out.println("在Thread线程中取值=" + P195Tools.tl.get());
				Thread.sleep(100);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
public class P195 {
	//public static ThreadLocalExt tl = new ThreadLocalExt();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try{
		for(int i =0; i< 10; i++){
			System.out.println("  在main线程中取值=" + P195Tools.tl.get());
			Thread.sleep(100);
		}
		Thread.sleep(5000);
		P195Thread t = new P195Thread();
		t.start();
	}catch(InterruptedException e){
		e.printStackTrace();
	}
		
		/*if(tl.get() == null){
			System.out.println("从未放过值");
			tl.set("我的值");
		}
		System.out.println(tl.get());
		System.out.println(tl.get());*/
	}

}
