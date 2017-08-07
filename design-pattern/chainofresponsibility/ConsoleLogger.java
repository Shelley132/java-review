package chainofresponsibility;

/**
 * @author JUANJUAN
 * @version 2017年8月7日下午4:29:30
 */
public class ConsoleLogger extends AbstractLogger {
	public ConsoleLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		// TODO Auto-generated method stub
		System.out.println("Standard Console::Logger: " + message);
	}

}
