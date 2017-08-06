package proxy;
/**
 * @author JUANJUAN
 * @version 2017年8月6日下午9:18:11
*/
public class ProxyImage implements Image{
	private RealImage realImage;
	private String fileName;
	public ProxyImage(String fileName){
		this.fileName = fileName;
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		if(realImage == null){
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}

}
