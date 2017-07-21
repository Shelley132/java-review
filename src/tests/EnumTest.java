package tests;
/**
 * @author LLJ
 * @version 2017年3月10日上午11:06:10
*/
enum T{
	FIRST(1),SECOND(2),THIRD(3);
	private int index;
	private T(){
		System.out.println("This is a enum constructor...");
	}
	private T(int index){
		this.index = index;
	}
}

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(T.SECOND);
		T t =T.valueOf(T.class, "FIRST");
		System.out.println(t.THIRD);
	}

}

class EnumTest2{
	static{
		System.out.println("enumtest2");
	}
}
