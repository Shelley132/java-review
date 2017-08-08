package memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUANJUAN
 * @version 2017年8月8日下午2:31:50
 */
public class CareTaker {
	private List<Memento> mementoList = new ArrayList<Memento>();

	public void add(Memento state) {
		mementoList.add(state);
	}

	public Memento get(int index) {
		return mementoList.get(index);
	}
}
