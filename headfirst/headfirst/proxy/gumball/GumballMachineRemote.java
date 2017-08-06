package headfirst.proxy.gumball;

import java.rmi.*;
//制作远程接口
//扩展java.rmi.Remote
//声明所有的方法都会抛出RemoteException
//确定变量和返回值是属于原语类型或者可序列化类型
public interface GumballMachineRemote extends Remote {
	public int getCount() throws RemoteException;
	public String getLocation() throws RemoteException;
	public State getState() throws RemoteException;
}
