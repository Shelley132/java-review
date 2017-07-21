package leetcodes;
/**
 * @author LLJ
 * @version 2017年3月27日下午9:57:10
*/
public class KMP {

	public void matchByKMP(String pattern, String string){
		int[] values = getMatchValue(pattern);
		for(int i = 0; i < values.length;i++){
			System.out.println(values[i]);
		}
	}
	public int[] getMatchValue(String pattern){
		int[] values = new int[pattern.length()];
		for(int i = 1; i < pattern.length(); i++){
			String s = pattern.substring(0,i);
			System.out.println(s);
			values[i] =0;
			for(int j = 1; j < i; j++){
				System.out.println(s.substring(0,j));
				System.out.println(s.length()-j);
				System.out.println(s.substring(s.length()-j));
				System.out.println("========");
				if(s.length()>1 && s.substring(0, j).equals(s.substring(s.length()-j))){
					values[i] = j;
				}
			}
		}
		
		return values;
	}
	public static void main(String[] args) {
		String str = "BBC ABCDAB ABCDABCDABDE";
		String pattern = "ABCDABD";
		KMP test = new KMP();
		test.matchByKMP(pattern, str);
		
	}
}
