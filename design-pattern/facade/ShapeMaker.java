package facade;
/**
 * 这个就是Facade，子系统的入口
 * @author JUANJUAN
 * @version 2017年7月30日下午7:59:13
*/
public class ShapeMaker {
	private Shape circle;
	private Shape rectangle;
	private Shape square;
	public ShapeMaker(){
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}
	public void drawCircle(){
		circle.draw();
	}
	public void drawRectangle(){
		rectangle.draw();
	}
	public void drawSquare(){
		square.draw();
	}
	
}
