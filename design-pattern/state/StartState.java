package state;

/**
 * @author JUANJUAN
 * @version 2017年8月8日下午4:37:02
 */
public class StartState implements State {

	@Override
	public void doAction(Context context) {
		// TODO Auto-generated method stub
		System.out.println("Player is in start state");
		context.setState(this);
	}

	public String toString() {
		return "Start State";
	}
}
