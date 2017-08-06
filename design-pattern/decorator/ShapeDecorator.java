package decorator;

/**
 * @author JUANJUAN
 * @version 2017年8月6日上午11:07:51
 */
public class ShapeDecorator implements Shape {
	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		decoratedShape.draw();
	}

}
