package leetcodes;

import org.junit.Test;

/**
 * @author LLJ
 *
 */
public class L4Test {
	int[] nums1 = {416,456,567,588};
	int[] nums2 = {878,888,989,1023,3456};
	int[] nums3 = {312,456,567,588};
	int[] nums4 = {434,456};
	L4_MedianofTwoSortedArrays four = new L4_MedianofTwoSortedArrays();

	/**
	 * Test method for {@link L4_MedianofTwoSortedArrays#findMedianSortedArrays2(int[], int[])}.
	 */
	@Test
	public void testFindMedianSortedArrays2() {
		four.findMedianSortedArrays(nums1, nums2);
		four.findMedianSortedArrays(nums1, nums3);
		four.findMedianSortedArrays(nums1, nums4);
		four.findMedianSortedArrays(nums2, nums3);
		four.findMedianSortedArrays(nums2, nums4);
		four.findMedianSortedArrays(nums3, nums4);
		
	}


	/**
	 * Test method for {@link L4_MedianofTwoSortedArrays#findMedianSortedArrays(int[], int[])}.
	 */
	@Test
	public void testFindMedianSortedArrays() {
		four.findMedianSortedArrays(nums1, nums2);
		four.findMedianSortedArrays(nums1, nums3);
		four.findMedianSortedArrays(nums1, nums4);
		four.findMedianSortedArrays(nums2, nums3);
		four.findMedianSortedArrays(nums2, nums4);
		four.findMedianSortedArrays(nums3, nums4);
	}

}
