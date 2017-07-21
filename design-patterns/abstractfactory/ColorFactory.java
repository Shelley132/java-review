package abstractfactory;
/**
 * @author JUANJUAN
 * @version 2017年7月21日下午5:09:25
*/
public class ColorFactory extends AbstractFactory{

	@Override
	Color getColor(String color) {
		// TODO Auto-generated method stub
		if(color == null){
	         return null;
	      }		
	      if(color.equalsIgnoreCase("RED")){
	         return new Red();
	      } else if(color.equalsIgnoreCase("GREEN")){
	         return new Green();
	      } else if(color.equalsIgnoreCase("BLUE")){
	         return new Blue();
	      }return null;
	}

	@Override
	Shape getShape(String shapeTypes) {
		// TODO Auto-generated method stub
		return null;
	}

}
