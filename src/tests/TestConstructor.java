package tests;
/**
 * @author LLJ
 * @version 2017年3月7日下午7:45:00
 */
/*
 * 如果父类没有无参构造器，则报错
 * Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	Implicit super constructor TestCon() is undefined. Must explicitly invoke another constructor
 * */
class TestCon{
	public TestCon(){
		
	}
	public TestCon(String s){
		System.out.println("------"+ s);
	}
}
public class TestConstructor extends TestCon{

	public TestConstructor(){
		
		System.out.println(this.getClass().getName());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestConstructor();
	}

}
