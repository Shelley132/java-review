package threads;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author LLJ
 * @version 2017年4月12日下午9:30:43
*/
public class P274SingletonSerializable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static class P274SingletonHandler{
		private static final P274SingletonSerializable instance = new P274SingletonSerializable();
	}
	private P274SingletonSerializable(){}
	public static P274SingletonSerializable getInstance(){
		System.out.println("===========");
		return P274SingletonHandler.instance;
	}
	protected Object readResovle() throws ObjectStreamException{
		return P274SingletonHandler.instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P274SingletonSerializable ins = P274SingletonSerializable.getInstance();
	}

}
