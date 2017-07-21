package threads;
/**
 * @author LLJ
 * @version 2017年4月3日下午4:51:22
 * Java多线程编程核心技术， 线程间通信之生产者、消费者模式实现，详见P158及P160多生产者和多消费者，操作值
*/
class P158P{
	/**
	 * 模拟生产者
	 */
	private String lock;
	public P158P(String lock){
		super();
		this.lock = lock;
	}
	public void setValue(){
		try{
			synchronized(lock){
				while(!P158ValueObject.value.equals("")){
					System.out.println("生产者" + Thread.currentThread().getName() + "WAITING 了 ★");
					lock.wait();
				}
				System.out.println("生产者"  + Thread.currentThread().getName() + "RUNNING 了");
				String value = System.currentTimeMillis() + "_"+ System.nanoTime();
				//System.out.println("set的值是"+ value);
				P158ValueObject.value = value;
				//lock.notify();	//只唤醒一个线程，容易出现假死，也就是有可能唤醒了同类，解决假死问题，就是将异类线程也唤醒
				lock.notifyAll();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
class P158C{
	/**
	 * 模拟消费者 
	 */
	private String lock;
	public P158C(String lock){
		super();
		this.lock = lock;
	}
	public void getValue(){
		try{
			synchronized(lock){
				while(P158ValueObject.value.equals("")){
					System.out.println("消费者 " + Thread.currentThread().getName() + "WAITING 了 ■");
					lock.wait();
				}
				System.out.println("消费者"  + Thread.currentThread().getName() + "RUNNING 了");
				
				//System.out.println("get的值是 "+ P158ValueObject.value);
				P158ValueObject.value = "";
				//lock.notify();	//已造成假死
				lock.notifyAll();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
class P158ThreadP extends Thread{
	/**
	 * 生产者线程
	 */
	private P158P p;
	public P158ThreadP(P158P p){
		super();
		this.p = p;
	}
	@Override
	public void run(){
		while(true){
			p.setValue();
		}
	}
}
class P158ThreadC extends Thread{
	/**
	 * 消费者线程 
	 */
	private P158C c;
	public P158ThreadC(P158C c){
		super();
		this.c = c;
	}
	@Override
	public void run(){
		while(true){
			c.getValue();
		}
	}
}

class P158ValueObject{
	public static String value = "";
}

public class P158 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String lock = new String("");
		P158P p = new P158P(lock);
		P158C c = new P158C(lock);
		//P158ThreadP threadP = new P158ThreadP(p);
		//P158ThreadC threadC = new P158ThreadC(c);
		//threadP.start();
		//threadC.start();
		P158ThreadP[] pThread = new P158ThreadP[2];
		P158ThreadC[] cThread = new P158ThreadC[2];
		for(int i = 0; i < 2; i++){
			pThread[i] = new P158ThreadP(p);
			pThread[i].setName("生产者 "+ (i+1));
			cThread[i] = new P158ThreadC(c);
			cThread[i].setName("消费者 "+ (i+1));
			pThread[i].start();
			cThread[i].start();
		}
		Thread.sleep(5000);
		Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
		Thread.currentThread().getThreadGroup().enumerate(threadArray);
		for(int i = 0; i< threadArray.length; i++){
			System.out.println(threadArray[i].getName() + " " + threadArray[i].getState());
		}
		
	}

}
