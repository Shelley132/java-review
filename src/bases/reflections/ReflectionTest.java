package bases.reflections;

import java.lang.reflect.*;
/**
 * @author LLJ
 * @version 2017年3月13日下午8:24:56
*/
public class ReflectionTest {

	public static void printAllMethods(Class<?> clz){
		//Method[] method = clz.getMethods();
		Method[] ms = clz.getDeclaredMethods();
		for(Method m: ms){
			System.out.println(m);
			
		}
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class<?> c1 = Class.forName("callbacks.Li");
		String modifiers = Modifier.toString(c1.getModifiers());
		if(modifiers.length() >0)
			System.out.print(modifiers+" ");
		
		printAllMethods(c1);
		
	}

}
