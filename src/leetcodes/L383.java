package leetcodes;
import java.util.HashMap;

public class L383 {

	public boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		//把magazine放到HashMap里
		for(int i = 0; i< magazine.length(); i++){
			if(!map.containsKey(magazine.charAt(i))){
				map.put(magazine.charAt(i), 0);
			}else{
				map.put(magazine.charAt(i), map.get(magazine.charAt(i))+1);
			}
		}
		
		for(int i = 0; i < ransomNote.length(); i++){
			if(!map.containsKey(ransomNote.charAt(i))){
				return false;
			}
			int temp = map.get(ransomNote.charAt(i))-1;
			if(temp < 0)
				return false;
			map.put(ransomNote.charAt(i), temp);
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
