package singleton;
/**
 * @author JUANJUAN
 * @version 2017年7月26日上午10:38:26
*/
public class SingleObject {
	private static SingleObject instance;
	private SingleObject(){
		
	}
	public static SingleObject getInstance(){
		if(instance == null){
			instance = new SingleObject();
		}
		return instance;
	}
	public void showMessage(){
		System.out.println("Hello world");
	}
}
