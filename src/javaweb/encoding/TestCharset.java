package javaweb.encoding;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author JUANJUAN
 * @version 2017年7月5日下午8:58:45
*/
public class TestCharset {
public static void main(String[] args) {
	Charset test = Charset.forName("UTF-8");
	ByteBuffer b = test.encode("I love u");
	System.out.println(test.decode(b));
	byte[] bs = b.array();
	for(int i=0; i< bs.length; i++){
		System.out.format("%x", bs[i]);
	}
	System.out.println(Arrays.toString(b.array()));
	String name = "I am Juanjuan";

	
}
}
