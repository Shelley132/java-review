package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author LLJ
 * @version 2017年4月26日下午9:20:27
*/
public class HeapOOM {

	static class OOMObject{
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
		
	}

}
