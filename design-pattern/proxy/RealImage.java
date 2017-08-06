package proxy;
/**
 * @author JUANJUAN
 * @version 2017年8月6日下午9:15:44
*/
public class RealImage implements Image{
	public String fileName;
	public RealImage(String fileName){
		this.fileName = fileName;
		loadFromDisk(fileName);
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("display "+ fileName);
	}

	public void loadFromDisk(String fileName){
		System.out.println("load from disk..."+ fileName);
	}
	
}
