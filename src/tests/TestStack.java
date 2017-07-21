package tests;

import java.util.Stack;

/**
 * @author JUANJUAN
 * @version 2017年5月17日下午9:48:09
*/
public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> s = new Stack<Integer>();
		for(int i=0; i< 10; i++){
			s.push(i);
		}
		
		for(Integer i: s){
			System.out.println(i);
		}
	}

}
