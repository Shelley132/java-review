package com.cn.llj.leetcodes;
/* *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * */
public class Four {
	
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
	    int leftMedian = (nums1.length+nums2.length+1)/2;
	    int rightMedian = (nums1.length+nums2.length+2)/2;
	    return (helper(nums1,0,nums2,0,leftMedian)+helper(nums1,0,nums2,0,rightMedian))/2.0;
	}

	public double helper(int[] nums1, int start1, int[]nums2, int start2, int topK){
	    if(start1 > nums1.length-1) return nums2[start2+topK-1];
	    if(start2 > nums2.length-1) return nums1[start1+topK-1];
	    if(topK == 1) return Math.min(nums1[start1],nums2[start2]);
	    
	    if(start2+topK/2-1 > nums2.length-1) return helper(nums1,start1+topK/2,nums2,start2,topK-topK/2);
	    if(start1+topK/2-1 > nums1.length-1) return helper(nums1,start1,nums2,start2+topK/2,topK-topK/2);
	    
	    if(nums1[start1+topK/2-1] < nums2[start2+topK/2-1]) return helper(nums1,start1+topK/2,nums2,start2,topK-topK/2);
	    else return helper(nums1,start1,nums2,start2+topK/2,topK-topK/2);
	    
	}
	
	public double findKSortedArrays(int[] nums1, int[] nums2, int k){
		int i = 0, j = 0;
		int kth = 0;
		while(i < nums1.length && j < nums2.length && k >=0){
			kth = nums1[i]<nums2[j]?nums1[i++]:nums2[j++];
			k--;
		}
		while(i < nums1.length && k>=0){
			kth = nums1[i++];
			k--;
		}
		while(j < nums2.length && k>=0){
			kth = nums2[j++];
			k--;
		}
		return kth;
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		  	int m = nums1.length;
			int n = nums2.length;
			
			int middle = (m+n)%2;
			if(middle==0){
				return (findKSortedArrays(nums1,nums2,(m+n)/2)+findKSortedArrays(nums1,nums2,(m+n)/2-1))/2;
			}else{
				return findKSortedArrays(nums1,nums2,(m+n)/2);
			}
    }
	public static void main(String[] args) {
		int[] nums1 = {416,456,567,588};
		int[] nums2 = {878,888,989,1023,3456};
		System.out.println(new Four().findMedianSortedArrays(nums1, nums2));
		int[] nums3 = {416,456,567,588};
		int[] nums4 = {878,888,989};
		System.out.println(new Four().findMedianSortedArrays(nums3, nums4));
	}

}
