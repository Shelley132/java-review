package bases;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年3月7日 下午6:34:54
 * 类说明：
 * 使用new和不使用new的区别：不使用new时，复合flyweight模式，即对象复用。
 */
public class StringEquals {
	
	public static void main(String[] agrs){
		Object o1 = new String("Hello");
		Object o2 = new String("Hello");
		if(o1==o2){
			System.out.println("o1==o2");
		}else if(o1.equals(o2)){
			System.out.println("o1.equals(o2)");
		}
		
		Object s1 = "Hello";
		Object s2 = "Hello";
		if(s1==s2){
			System.out.println("s1==s2");
		}else if(s1.equals(s2)){
			System.out.println("s1.equals(s2)");
		}
		
		//运行结果：
		//o1.equals(o2)
		//s1==s2
	}
	
}
