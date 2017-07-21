package threads;

import java.util.ArrayList;

/**
 * @author LLJ
 * @version 2017年4月4日上午10:34:48
 * 多生产一消费：操作栈，升级版多生产多消费：操作栈
*/
class P169Stack{
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

class P169P{
	private P169Stack p;
	public P169P(P169Stack p){
		this.p = p;
	}
	public void pushService(){
		p.push();
	}
}

class P169C{
	private P169Stack p;
	public P169C(P169Stack p){
		this.p = p;
	}
	public void popService(){
		p.pop();
	}
}

class P169ThreadP extends Thread{
	private P169P p;
	public P169ThreadP(P169P p){
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
class P169ThreadC extends Thread{
	private P169C c;
	public P169ThreadC(P169C c){
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
public class P169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P169Stack stack = new P169Stack();
		P169P p = new P169P(stack);
		P169C c = new P169C(stack);
		P169ThreadP pThread1 = new P169ThreadP(p);
		P169ThreadP pThread2 = new P169ThreadP(p);
		P169ThreadP pThread3 = new P169ThreadP(p);
		P169ThreadP pThread4 = new P169ThreadP(p);
		P169ThreadP pThread5 = new P169ThreadP(p);
		P169ThreadC cThread1 = new P169ThreadC(c);
		P169ThreadC cThread2 = new P169ThreadC(c);
		P169ThreadC cThread3 = new P169ThreadC(c);
		P169ThreadC cThread4 = new P169ThreadC(c);
		P169ThreadC cThread5 = new P169ThreadC(c);

		pThread1.start();
		pThread2.start();
		pThread3.start();
		pThread4.start();
		pThread5.start();
		cThread1.start();
		cThread2.start();
		cThread3.start();
		cThread4.start();
		cThread5.start();
	}

}
