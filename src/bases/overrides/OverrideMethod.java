package bases.overrides;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年3月7日 下午6:52:18
 * 类说明：
 */
public class OverrideMethod {
	//java.lang里面有一个注释类型是Override，O必须是大写，不然显示有错误。
	//表示一个方法声明打算重写超类中的另一个方法声明。如果方法利用此注释类型进行注解但没有重写超类方法，则编译器会生成一条错误消息。 
	@Override
	//public boolean equals(OverrideMethod o){
	public boolean equals(Object obj){
		System.out.println("调用了此equals方法");
		return true;
	}
	public static void main(String[] args) {
		Object o1 = new OverrideMethod();
		Object o2 = new OverrideMethod();
		
		OverrideMethod om1 = new OverrideMethod();
		OverrideMethod om2 = new OverrideMethod();
		
		if(o1.equals(o2)){
			System.out.println("o1.equals(o2)");
		}
		if(om1.equals(om2)){
			System.out.println("om1.equals(om2)");
		}
	}

}
