package com.cn.llj.threads;

import java.awt.List;
import java.util.ArrayList;

/**
 * @author LLJ
 * @version 2017年3月26日上午10:04:43
*/
class P89List{
	private ArrayList list = new ArrayList();
	synchronized public void add(String data){
		list.add(data);
	}
	synchronized public int getSize(){
		return list.size();
	}
}

class P89Service{
	public P89List addMethod(P89List list, String data){
		try {
			//System.out.println(list.getSize());
			//synchronized(list){
				if(list.getSize() < 1){
					Thread.sleep(2000);
					list.add(data);
				}
			//}
			
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return list;	
	}
}
class P89A extends Thread{
	private P89List list;
	public P89A(P89List list){
		super();
		this.list = list;
	}
	public void run(){
		P89Service service = new P89Service();
		service.addMethod(list, "A");
	}
}
class P89B extends Thread{
	private P89List list;
	public P89B(P89List list){
		super();
		this.list = list;
	}
	public void run(){
		P89Service service = new P89Service();
		service.addMethod(list, "B");
	}
}
public class P89 {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		P89List list = new P89List();
		P89A a = new P89A(list);
		a.setName("A");
		a.start();
		//Thread.sleep(200);
		P89B b = new P89B(list);
		b.setName("B");
		b.start();
		Thread.sleep(6000);
		
		System.out.println("listSize=" + list.getSize());
	}

}
