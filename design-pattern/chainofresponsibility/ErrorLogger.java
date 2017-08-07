package chainofresponsibility;

/**
 * @author JUANJUAN
 * @version 2017年8月7日下午4:30:28
 */
public class ErrorLogger extends AbstractLogger {
	public ErrorLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Error Console::Logger: " + message);
	}
}
