package leetcodes;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L155_ReverseWords {
	// 用正则表达式做
	public String reverseWords(String s) {
		Pattern pattern = Pattern.compile("\\s+");
		Matcher matcher = pattern.matcher(s);
		String str = "";
		int last = 0;
		while (matcher.find()) {
			// System.out.println(s.substring(0,matcher.start()));

			str = s.substring(last, matcher.start()) + " " + str;
			last = matcher.end();

		}
		str = s.substring(last) + " " + str;
		return str.trim();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L155_ReverseWords obj = new L155_ReverseWords();
		System.out.println(obj.reverseWords("Hello world you are smart"));
	}

}