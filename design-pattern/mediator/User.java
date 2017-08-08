package mediator;
/**
 * @author JUANJUAN
 * @version 2017年8月8日上午11:17:59
*/
public class User {
	private String name;
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public User(String name){
		this.name = name;
	}
	//通过中介者来交互
	public void sendMessage(String message){
		ChatRoom.showMessage(this, message);
	}
}
