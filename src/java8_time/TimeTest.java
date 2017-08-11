package java8_time;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author JUANJUAN
 * @version 2017年8月10日下午8:29:03
 */
public class TimeTest {
	public static void main(String[] args) {
		LocalTime time1 = LocalTime.now();
		System.out.println(time1);
		ZoneId.of("");
		Stack stack = new Stack();
		Set set = new HashSet();
		TreeSet se2 = new TreeSet();
		TreeMap m2 = new TreeMap();
	}
}
