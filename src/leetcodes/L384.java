package leetcodes;
import java.util.Random;

/**
 * Shuffle an Array 
 * Shuffle a set of numbers without duplicates
 * */
public class L384 {
	
	int[] nums;
	Random rd;
	
	public L384(int[] nums) {
        this.nums = nums;
        this.rd = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	if(nums == null) return null;
        int[] a = nums.clone();
        for(int j = 1; j < a.length; j++) {
            int i = rd.nextInt(j + 1);
            swap(a, i, j);
        }
        return a;
    }
	
	private int[] swap(int[] a ,int i, int j){
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    	return a;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
