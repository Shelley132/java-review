package threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午9:31:04
*/
class P77Task{
	public void doLongTimeTask(){
		for(int i = 0; i < 100; i++){
			System.out.println("nosynchronized threadName=" + Thread.currentThread().getName() + " i="+ (i+1));
		}
		System.out.println("");
		synchronized(this){
			for(int i = 0; i < 100; i++){
				System.out.println("synchronized threadName=" + Thread.currentThread().getName() + " i="+ (i+1));
			}
		}
	}
}

class P77A extends Thread{
	private P77Task task;
	public P77A(P77Task task){
		super();
		this.task = task;
	}
	public void run(){
		super.run();
		task.doLongTimeTask();
	}
}
class P77B extends Thread{
	private P77Task task;
	public P77B(P77Task task){
		super();
		this.task = task;
	}
	public void run(){
		super.run();
		task.doLongTimeTask();
	}
}

public class P77 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P77Task task = new P77Task();
		P77A a = new P77A(task);
		a.start();
		P77B b = new P77B(task);
		b.start();
	}

}
