package state;

/**
 * @author JUANJUAN
 * @version 2017年8月8日下午4:37:10
 */
public class StopState implements State {

	@Override
	public void doAction(Context context) {
		System.out.println("Player is in stop state");
		context.setState(this);
	}

	public String toString() {
		return "Stop State";
	}

}
