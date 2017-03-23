package com.cn.llj.leetcodes;

import org.junit.Test;

public class FiveTest {
	Five five = new Five();
	@Test
	public void testIsPalindrome() {
		System.out.println(five.isPalindrome("abcba")==true);
		System.out.println(five.isPalindrome("abc")==false);
		System.out.println(five.isPalindrome("abcdcba")==true);
		System.out.println(five.isPalindrome("a")==true);
		System.out.println(five.isPalindrome("ab")==false);
		
		System.out.println(five.isPalindrome("bcbadcb")==false);
	
	}
	@Test
	public void testLongestPalindrome() {
		System.out.println("abcbadcbd  "+ five.longestPalindrome("abcbadcbd"));
		System.out.println("abcd  "+five.longestPalindrome("abcd"));
		System.out.println("aabcdcbadg    "+five.longestPalindrome("aabcdcbadg"));
		System.out.println("bb    "+five.longestPalindrome("bb"));
		System.out.println("abc  "+five.longestPalindrome("abc"));
		System.out.println("abcbab   "+five.longestPalindrome("abcbab"));
	}
}
