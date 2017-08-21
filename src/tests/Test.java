package tests;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

class Test {

	public static void main(String[] args) {

		System.out.println(Runtime.getRuntime().availableProcessors());
		int[] b = new int[10];
		Queue q;
		char a = 'a';
	
		PriorityQueue pq;
		HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
		ConcurrentHashMap map2;
		System.out.println(1<<30);
		int c = 35 / 4;
        if (c * 4 < 35)
            ++c;
        System.out.println(c);
        int cap = 2;
        while (cap < c)
            cap <<= 1;
        System.out.println(cap);
	}

}
