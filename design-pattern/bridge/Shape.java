package bridge;
/**
 * 抽象类，依赖了实现接口
 * @author JUANJUAN
 * @version 2017年7月27日下午3:03:15
*/
public abstract class Shape {
	protected DrawAPI drawAPI;
	protected Shape(DrawAPI drawAPI){
		this.drawAPI = drawAPI;
	}
	public abstract void draw();
}
