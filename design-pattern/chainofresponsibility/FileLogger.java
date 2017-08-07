package chainofresponsibility;

/**
 * @author JUANJUAN
 * @version 2017年8月7日下午4:30:58
 */
public class FileLogger extends AbstractLogger {

	public FileLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("File::Logger: " + message);
	}
}