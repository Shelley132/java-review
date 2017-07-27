package bridge;
/**
 * @author JUANJUAN
 * @version 2017年7月27日下午3:12:47
*/
public class BridgePatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape redCircle = new Circle(100,100,10, new RedCircle());
		Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());
		
		redCircle.draw();
		greenCircle.draw();
	}

}
