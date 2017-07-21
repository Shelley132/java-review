package threads;
/**
 * @author LLJ
 * @version 2017年3月25日下午2:07:40
*/
public class P12 {

	private static String usernameRef;
	private static String passwordRef;
	synchronized public static void doPost(String username, String password){
		try {
			usernameRef = username;
			if(username.equals("a")){
				Thread.sleep(5000);
			}
			passwordRef = password;
			System.out.println("usernmae="+usernameRef + " passwordRef="+passwordRef);
		}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ALogin a = new ALogin();
		a.start();
		System.out.println(Thread.currentThread().getName());
		BLogin b = new BLogin();
		b.start();
	}

}
class ALogin extends Thread{
	public void run(){
		P12.doPost("a", "aa");
	}
}
class BLogin extends Thread{
	public void run(){
		P12.doPost("b", "bb");
	}
}
