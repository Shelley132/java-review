package iterator;
/**
 * @author JUANJUAN
 * @version 2017年7月28日下午12:40:04
*/
public class IteratorPatternDemo {
	public static void main(String[] args) {
		NameResponsitory  namesResponsitory = new NameResponsitory();
		for(Iterator iter = namesResponsitory.getIterator(); iter.hasNext();){
			String name = (String) iter.next();
			System.out.println("Name: "+ name);
		}
	}
}
