package flyweight;

import java.util.HashMap;

/**
 * @author JUANJUAN
 * @version 2017年8月6日下午7:21:52
*/
public class ShapeFactory {
	private static final HashMap<String, Shape> circleMap = new HashMap<String, Shape>();

	   public static Shape getCircle(String color) {
	      Circle circle = (Circle)circleMap.get(color);

	      if(circle == null) {
	         circle = new Circle(color);
	         circleMap.put(color, circle);
	         System.out.println("Creating circle of color : " + color);
	      }
	      return circle;
	   }
	   
}
