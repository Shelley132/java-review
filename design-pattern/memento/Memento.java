package memento;
/**
 * @author JUANJUAN
 * @version 2017年8月8日下午2:28:38
*/
public class Memento {
	private String state;
	
	public Memento(String state){
		this.state = state;
	}
	
	public String getState(){
		return this.state;
	}
}
