package mediator;

/**
 * @author JUANJUAN
 * @version 2017年8月8日上午11:21:45
 */
public class MediatorPatternDemo {
	public static void main(String[] args) {
		User robert = new User("Robert");
		User john = new User("John");

		robert.sendMessage("Hi! John!");
		john.sendMessage("Hello! Robert!");
	}
}
