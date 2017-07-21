package bases;
/**
 * @author LLJ
 * @version 2017年4月16日下午7:58:05
*/
public class OverLoadTest {


	public static void toShort(short n){
		System.out.println("short");
	}
	public static void toShort(Short n){
		System.out.println("Short");
	}
	public static void toShort(Long n){
		System.out.println("Long");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 5;
		//toShort(i);这个直接就有错误
		short iss = 5;
		toShort(iss);
		Short is =5;
		toShort(is);
		
	}

}
