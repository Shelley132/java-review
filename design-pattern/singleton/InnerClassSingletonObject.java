package singleton;
/**
 * @author JUANJUAN
 * @version 2017年7月26日上午10:59:56
*/
public class InnerClassSingletonObject {
	private static class InnerClassSingleton{
		private static final InnerClassSingletonObject instance = new InnerClassSingletonObject();
	}
	private InnerClassSingletonObject(){
		
	}
	public static final InnerClassSingletonObject getInstance(){
		return InnerClassSingleton.instance;
	}
}
