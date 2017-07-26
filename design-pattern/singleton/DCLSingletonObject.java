package singleton;
/**
 * @author JUANJUAN
 * @version 2017年7月26日上午10:56:50
*/
public class DCLSingletonObject {
	private volatile static DCLSingletonObject instance= null;
	private DCLSingletonObject(){}
	public static DCLSingletonObject getInstance(){
		if(instance == null){
			synchronized(DCLSingletonObject.class){
				if(instance == null){
					instance = new DCLSingletonObject();
				}
			}
		}
		return instance;
	}
}
