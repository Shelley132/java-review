package tests;

import java.io.Serializable;

import tools.CloneUtils;

/**
 * @author JUANJUAN
 * @version 2017年7月25日上午11:16:40
*/
class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2932690695627307059L;
	public int number;
	public Email email;
	public Person(int num, Email email){
		this.number = num;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Person [number=" + number + ", email=" + email + "]";
	}
	
}
class Email implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3534382381431787644L;
	public String emailname;
	public Email(String name){
		this.emailname = name;
	}
	@Override
	public String toString() {
		return "Email [emailname=" + emailname + "]";
	}
	
}
public class TestCloneUtils {
	public static void main(String[] args) {
		Email email = new Email("lilijuan132@qq.com");
		Person p1 = new Person(1,email);
		
		
		Person cloneObj = CloneUtils.clone(p1);
		cloneObj.number = 2;
		System.out.println(p1 + ", "+ cloneObj);
	}
}
