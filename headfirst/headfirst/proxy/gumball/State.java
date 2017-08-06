package headfirst.proxy.gumball;

import java.io.*;
//可序列化类型
public interface State extends Serializable {
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}
