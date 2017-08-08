package state;

/**
 * @author JUANJUAN
 * @version 2017年8月8日下午4:36:19
 */
public class Context {
	private State state;

	public Context() {
		state = null;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}
}
