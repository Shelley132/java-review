package leetcodes;
public class L5_LongestPalindromicSubstring {
	private int lo, maxLen;
	//中心扩展法，从中间的字母向外一一扩展，找最长回文子串
	//假设字符串是abba，那么i=1时，是从b和b开始对比的，如果字符串是aba，从b和自身开始对比的。
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++) {
			extendPalindrome(s, i, i); // 奇数, try to extend
										// Palindrome as possible
			extendPalindrome(s, i, i + 1); //偶数
		}
		return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
}