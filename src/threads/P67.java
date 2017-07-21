package threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午9:04:52
*/
class P67Father{
	public int i = 10;
	synchronized public void operateFather(){
		try {
			i--;
			System.out.println("father print i="+ i);
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class P67Son extends P67Father{
	synchronized public void operate(){
		try {
			while(i>0){
			i--;
			System.out.println("son print i="+ i);
			Thread.sleep(200);
			this.operateFather();//这里其实就是调用了父类的方法
		}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class P67 extends Thread{
	
	public P67(){
		
	}
	public void run(){
		P67Son son = new P67Son();
		System.out.println(Thread.currentThread().getName());
		son.operate();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P67 t = new P67();
		Thread t1 = new Thread(t,"A");
		t1.start();
		P67 t2 = new P67();
		Thread t22 = new Thread(t2,"B");
		t22.start();
	}

}
