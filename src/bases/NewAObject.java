package bases;

/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年3月5日 下午10:06:44 类说明：
 */
public class NewAObject implements Cloneable {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NewAObject() {
		this("unknown", 0);
		System.out.println("call default constructor");
	}

	public NewAObject(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("call second constructor");
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		/**
		 * instanceof 运算符是用来在运行时指出对象是否是特定类的一个实例。
		 * instanceof通过返回一个布尔值来指出，这个对象是否是这个特定类或者是它的子类的一个实例。
		 * */
		if (!(o instanceof NewAObject))
			return false;
		final NewAObject other = (NewAObject) o;
		if (this.name.equals(other.name) && this.age == other.age)
			return true;
		else
			return false;
	}

	public String toString() {
		return "name=" + name + ",age=" + age;
	}

	public static void main(String args[]) throws Exception {
		// 运用反射手段创建NewAObject对象
		@SuppressWarnings("rawtypes")
		Class objClass = Class.forName("com.cn.llj.class_info.NewAObject");
		NewAObject c1 = (NewAObject) objClass.newInstance(); // 会调用NewAObject类的默认构造方法
		System.out.println("c1: " + c1); // 打印name=unknown,age=0

		// 用new语句创建NewAObject对象
		NewAObject c2 = new NewAObject("Tom", 20);
		System.out.println("c2: " + c2); // 打印name=tom,age=20
		System.out.println(c2.getName().hashCode());
		
		// 运用克隆手段创建NewAObject对象
		NewAObject c3 = (NewAObject) c2.clone(); // 不会调用NewAObject类的构造方法
		System.out.println("c2: " + c2); // 打印name=tom,age=20
		System.out.println("c2==c3 : " + (c2 == c3)); // 打印false
		System.out.println("c2.equals(c3) : " + c2.equals(c3)); // 打印true
		System.out.println("c3: " + c3); // 打印name=tom,age=20
		System.out.println(c3.getName().hashCode());
	}
}
