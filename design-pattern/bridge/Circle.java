package bridge;
/**
 * 使用的类，你就只管用就好了，不用管怎么实现的
 * @author JUANJUAN
 * @version 2017年7月27日下午3:10:42
*/
public class Circle extends Shape{
	private int x, y , radius;
	public Circle(int x, int y, int radius, DrawAPI drawAPI){
		super(drawAPI);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		drawAPI.drawCircle(radius, x, y);
	}

}
