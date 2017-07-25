package factorymethod;
/**
 * @author JUANJUAN
 * @version 2017年7月24日下午8:28:59
*/
public class FactoryMethondDemo {
	public static void main(String[] args) {
		Shape shape1 = ShapeFactory.getShape("circle");
		shape1.draw();
		Shape shape2 = ShapeFactory.getShape("rectangle");
		shape2.draw();
		Shape shape3 = ShapeFactory.getShape("square");
		shape3.draw();
	}
}
