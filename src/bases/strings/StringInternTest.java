package bases.strings;
/**
 * @author LLJ
 * @version 2017年4月25日下午2:47:32
*/
public class StringInternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String(new char[]{'1','4','7'});    
	    s.intern();
	    String s2 = "147";
	    System.out.println(s==s2);
	    
		String str1 ="1234";
		
		
		String str2 = new String("1234");
		str2.intern();
		String str3 ="1234";
		System.out.println(str1==str3);
	}

}
