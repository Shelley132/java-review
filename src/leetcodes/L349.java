package leetcodes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class L349 {

	//求两个数组的交叉集，且按序输出
	public int[] intersection(int[] nums1, int[] nums2) {
	    HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
	   
	    for(int i = 0; i< nums1.length; i++){
	    	//set1.add(nums1[i]);
	    	if(map1.containsKey(nums1[i])){
	    		map1.put(nums1[i], map1.get(nums1[i])+1);
	    	}else{
	    		map1.put(nums1[i], 1);
	    	}
	    }
	    HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
	    for(int i = 0; i< nums2.length; i++){
	    	if(map1.containsKey(nums2[i])){
	    		if(map2.containsKey(nums2[i])){
	    			map2.put(nums2[i], map2.get(nums2[i])+1);
	    		}else{
	    			map2.put(nums2[i], 1);
	    		}
	    	}
	    }
		Iterator<Entry<Integer, Integer>> iter = map2.entrySet().iterator();
		int[] result = new int[map2.size()];
		int i =0;
		while(iter.hasNext()){
			Entry<Integer, Integer> key = (Entry<Integer, Integer>) iter.next();
			result[i] = key.getKey();
			i++;
		}
		return result;
	}
	public int[] intersection2(int[] nums1, int[] nums2) {
	   
	   HashSet<Integer> set1 = new HashSet<Integer>();
	    for(int i = 0; i< nums1.length; i++){
	    	set1.add(nums1[i]);	
	    }
	   HashSet<Integer> set2 = new HashSet<Integer>();
		for(int i = 0; i < nums2.length; i++){
			if(set1.contains(nums2[i])){
				set2.add(nums2[i]);
			}
		}
		int[] result = new int[set2.size()];
		Iterator<Integer> iter = set2.iterator();
		int i =0;
		while(iter.hasNext()){
			Integer key = (Integer) iter.next();
			result[i] = key;
			i++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L349 obj = new L349();
		int[] nums1 = {1,2,2,3,5,4,1};
		int[] nums2 = {2,3,4};
		int[] result = obj.intersection2(nums1, nums2);
		for(int i = 0; i< result.length; i++){
			System.out.println(result[i]);
		}
	}

}
