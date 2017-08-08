package mediator;

import java.util.Date;

/**
 * 中介者
 * @author JUANJUAN
 * @version 2017年8月8日上午11:16:52
*/
public class ChatRoom {
	public static void showMessage(User user, String message){
		 System.out.println(new Date().toString()
		         + " [" + user.getName() +"] : " + message);
	}
}
