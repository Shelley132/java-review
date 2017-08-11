package bases;
/**
 * @author JUANJUAN
 * @version 2017年8月9日下午9:08:45
*/
public class Outer {
		 
	    class Inner {}
	 
	    public static void foo() { new Outer().new Inner(); }
	 
	    public void bar() { new Inner(); }
	 
	    public static void main(String[] args) {
	        new Outer().new Inner();
	    }
}
