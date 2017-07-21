package leetcodes;


import java.util.HashMap;
import java.util.Map;

public class L1_TwoSum {
	//复杂度O(n*n)
	public int[] twoSum(int[] nums, int target) {
		int length = nums.length;
		if (length == 1) {
			return null;
		} else if (length == 2) {
			if (nums[0] + nums[1] == target)
				return new int[] { 0, 1 };
			else
				return null;
		} else {
			int index1, index2;
			for (int i = 0; i < length - 1; i++) {
				index1 = nums[i];

				for (int j = i + 1; j < length; j++) {
					index2 = nums[j];
					if (index1 + index2 == target) {
						return new int[] { i, j };
					}
				}
			}
			return null;
		}
	}
	//复杂度O(n)
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		int[] test = { 3, 2, 4 };
		L1_TwoSum test2 = new L1_TwoSum();
		System.out.println(test2.twoSum2(test, 6)[0] + "\t" + test2.twoSum2(test, 6)[1]);
		
	}

}
