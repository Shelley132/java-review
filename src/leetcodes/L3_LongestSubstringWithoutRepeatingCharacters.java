package leetcodes;


import java.util.HashMap;
import java.util.Map;

public class L3_LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
        int left = 0, right = 0;
        int len = s.length();

        if(len == 0 || len == 1) return len;
        //思路：遍历字符串，并将当前字符和其位置放在map里，如果map里有该字符，则从那个字符的右侧第一个开始到当前字符则是最长的字符串
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);

        for(int i=1; i<len; i++) {
            char c = s.charAt(i);
            right = i;
            if(map.containsKey(c)) {
                int index = map.get(c);
                if(index >= left) {
                    left = index+1;
                }
            }
            map.put(c, i);
            max = Math.max(max, right-left+1);
        }

        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new L3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkewkewke"));
	}

}
