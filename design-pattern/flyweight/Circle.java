package flyweight;
/**
 * @author JUANJUAN
 * @version 2017年8月6日下午4:38:08
*/
public class Circle implements Shape{

	private String color;
	private int x;
	private int y;
	private int radius;
	
	public Circle(String color){
		this.color = color;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Circle: Draw() [Color : " + color 
		         +", x : " + x +", y :" + y +", radius :" + radius);
	}
	
}
