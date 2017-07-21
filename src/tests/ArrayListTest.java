package tests;

/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年3月7日 下午10:58:22
 * 类说明：
 */
public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		for(int i = 2334; i < 3454777; i++){
			int j = i + i >> 1;
		}
		long end = System.currentTimeMillis();
		long start1 = System.currentTimeMillis();
		for(int i = 2334; i < 3454777; i++){
			int j = (int) (i * 1.5);
		}
		long end1 = System.currentTimeMillis();
		System.out.println("1=="+(end-start));
		System.out.println("2=="+(end1-start1));
	}
	

}
