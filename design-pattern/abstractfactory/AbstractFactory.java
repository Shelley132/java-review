package abstractfactory;
/**
 * @author JUANJUAN
 * @version 2017年7月21日下午5:06:09
*/
public abstract class AbstractFactory {
	abstract Color getColor(String color);
	abstract Shape getShape(String shapeTypes);
}
