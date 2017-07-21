package threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午8:14:02
*/
class P55Number{
	private int number;
	synchronized public void addI(String username){
		try{
			if(username.equals("a")){
				number = 100;
				System.out.println("a set over");
				Thread.sleep(2000);
			}else {
				number = 200;
				System.out.println("b set over");
			}
			System.out.println(username + " number=" + number);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
class P55A extends Thread{
	private P55Number num;
	public P55A(P55Number num){
		super();
		this.num = num;
	}
	public void run(){
		super.run();
		num.addI("a");
	}
}
class P55B extends Thread{
	private P55Number num;
	public P55B(P55Number num){
		super();
		this.num = num;
	}
	public void run(){
		super.run();
		num.addI("b");
	}
}
public class P55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P55Number num = new P55Number();
		P55A a = new P55A(num);
		a.start();
		P55B b = new P55B(num);
		b.start();
	}

}
