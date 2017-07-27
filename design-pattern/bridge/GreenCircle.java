package bridge;
/**
 * 实现接口
 * @author JUANJUAN
 * @version 2017年7月27日下午3:06:41
*/
public class GreenCircle implements DrawAPI{

	@Override
	public void drawCircle(int radius, int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("Drawing circle[ color: green, radius: "+ radius + ", x:"+ x + ", y:"+ y+"]");
	}

}
