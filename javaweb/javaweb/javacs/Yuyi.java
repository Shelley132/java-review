package javaweb.javacs;

import java.util.Arrays;
import java.util.List;

/**
 * @author JUANJUAN
 * @version 2017年7月18日下午7:19:25
*/
public class Yuyi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i = 1;
		Long l = i+2L;
		System.out.println(l);
		List<Integer> array = Arrays.asList(1,2,3);
		for(int a : array){
			System.out.println(a);
		}
	}

}
