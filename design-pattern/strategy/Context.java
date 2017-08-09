package strategy;

/**
 * @author JUANJUAN
 * @version 2017年8月9日上午9:46:17
 */
public class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public int executeStrategy(int num1, int num2) {
		return strategy.doOperation(num1, num2);
	}
}
