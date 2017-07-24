package jvm;
import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

/**
 * JVM 262页示例
 * @author JUANJUAN
 * @version 2017年7月23日上午11:17:00
*/
public class MethodHandleTest {
	static class ClassA{
		public void println(String s){
			System.out.println(s);
		}
	}
	private static MethodHandle getPrintlnMH(Object reveiver) throws Throwable{
		MethodType mt = MethodType.methodType(void.class, String.class);
		//一定不能忘记bintTo，否则报错
		return lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);
	}
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object obj = System.currentTimeMillis() %2 ==0? System.out : new ClassA();
		
		
		getPrintlnMH(obj).invokeExact("icyfenix");
	}

}
