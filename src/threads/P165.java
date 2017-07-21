package threads;

import java.util.ArrayList;

/**
 * @author LLJ
 * @version 2017年4月4日上午10:09:37
 * 一生产者与一消费者：操作栈，及升级版一生产者与多消费者：操作值
 * 详见Java多线程编程核心技术P165
*/
class P165Stack{
	private ArrayList list = new ArrayList();
	synchronized public void push(){
		try{
			while(list.size() == 1){// 如果这里是if的话，一生产者多消费者的情况下可能无法得到及时的响应，多个呈wait状态的线程被唤醒。
				System.out.println("push操作中的：" + Thread.currentThread().getName() + " 呈wait状态...");
				this.wait();
			}
			list.add("anyString = " + Math.random());
			this.notifyAll();
			System.out.println("push = " + list.size());
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	synchronized public void pop(){
		String returnValue = "";
		try{
			while(list.size() == 0){
				System.out.println("pop操作中的：" + Thread.currentThread().getName() + "呈wait状态!!!");
				this.wait();
			}
			returnValue = (String) list.get(0);
			System.out.println("pop = " + returnValue);
			list.remove(0);
			this.notifyAll();
			System.out.println("pop = " + list.size());
			
		}catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}

class P165P{
	private P165Stack p;
	public P165P(P165Stack p){
		this.p = p;
	}
	public void pushService(){
		p.push();
	}
}

class P165C{
	private P165Stack p;
	public P165C(P165Stack p){
		this.p = p;
	}
	public void popService(){
		p.pop();
	}
}

class P165ThreadP extends Thread{
	private P165P p;
	public P165ThreadP(P165P p){
		super();
		this.p = p;
	}
	@Override
	public void run(){
		while(true){
			p.pushService();
		}
	}
}
class P165ThreadC extends Thread{
	private P165C c;
	public P165ThreadC(P165C c){
		super();
		this.c = c;
	}
	@Override
	public void run(){
		while(true){
			c.popService();
		}
	}
}
public class P165 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P165Stack stack = new P165Stack();
		P165P p = new P165P(stack);
		P165C c1 = new P165C(stack);
		P165C c2 = new P165C(stack);
		P165C c3 = new P165C(stack);
		P165C c4 = new P165C(stack);
		P165C c5 = new P165C(stack);
		P165ThreadP pThread = new P165ThreadP(p);
		P165ThreadC cThread1 = new P165ThreadC(c1);
		P165ThreadC cThread2 = new P165ThreadC(c2);
		P165ThreadC cThread3 = new P165ThreadC(c3);
		P165ThreadC cThread4 = new P165ThreadC(c4);
		P165ThreadC cThread5 = new P165ThreadC(c5);
		pThread.start();
		cThread1.start();
		cThread2.start();
		cThread3.start();
		cThread4.start();
		cThread5.start();
	}

}
