package proxy;
/**
 * @author JUANJUAN
 * @version 2017年8月6日下午9:25:11
*/
public class ProxyPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Image image = new ProxyImage("diss someone.jpg");
		image.display();
		System.out.println("");
		image.display();
	}

}
