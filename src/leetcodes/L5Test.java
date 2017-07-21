package leetcodes;

import org.junit.Test;

public class L5Test {
	L5_LongestPalindromicSubstring five = new L5_LongestPalindromicSubstring();

	@Test
	public void testLongestPalindrome() {
		System.out.println("abcbadcbd  "+ five.longestPalindrome("abcbadcbd"));
		System.out.println("abcdc      "+five.longestPalindrome("adcdc"));
		System.out.println("aabcdcbadg "+five.longestPalindrome("aabcdcbadg"));
		System.out.println("bb         "+five.longestPalindrome("bb"));
		System.out.println("abc        "+five.longestPalindrome("abcb"));
		System.out.println("abcbab     "+five.longestPalindrome("abcbab"));
	}
}
