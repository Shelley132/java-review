package threads;
/**
 * @author LLJ
 * @version 2017年4月4日下午2:15:50
*/
class P177DBTools{
	volatile private boolean prevIsA = false;//这里用来标记是打印A的还是打印B的
	synchronized public void backupA(){
		try{
			while(prevIsA== true){
				wait();
			}
			for(int i = 0; i< 5; i++){
				System.out.println("★ ★ ★ ★ ★");
			}
			prevIsA = true;
			notifyAll();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	synchronized public void backupB(){
		try{
			while(prevIsA == false){
				wait();
			}
			for(int i = 0; i < 5; i++){
				System.out.println("☆ ☆ ☆ ☆ ☆");
			}
			prevIsA = false;
			notifyAll();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
class P177ThreadA extends Thread{
	private P177DBTools dbtools;
	public P177ThreadA(P177DBTools dbtools){
		this.dbtools = dbtools;
	}
	@Override
	public void run(){
		dbtools.backupA();
	}
}
class P177ThreadB extends Thread{
	private P177DBTools dbtools;
	public P177ThreadB(P177DBTools dbtools){
		this.dbtools = dbtools;
	}
	@Override
	public void run(){
		dbtools.backupB();
	}
}

public class P177 {
public static void main(String[] args) {
	P177DBTools tool = new P177DBTools();
	for(int i = 0; i< 20; i++){
		P177ThreadA aThread = new P177ThreadA(tool);
		aThread.start();
		P177ThreadB bThread = new P177ThreadB(tool);
		bThread.start();
	}
}
}
