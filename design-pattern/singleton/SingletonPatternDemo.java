package singleton;
/**
 * @author JUANJUAN
 * @version 2017年7月26日上午10:40:35
*/
public class SingletonPatternDemo {
	public static void main(String[] args) {
		SingleObject object = SingleObject.getInstance();
		object.showMessage();
	}
}
