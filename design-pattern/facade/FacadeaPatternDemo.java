package facade;
/**
 * @author JUANJUAN
 * @version 2017年7月30日下午8:04:15
*/
public class FacadeaPatternDemo {
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();
		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}
}
