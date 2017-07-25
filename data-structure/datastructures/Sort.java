package datastructures;

/**
 * @author LLJ
 * @version 2017年3月22日下午8:37:28
*/
public class Sort {
	/**
	 * 冒泡排序
	 * @author LLJ
	 * @version 2017年3月22日下午8:57:17
	 * @param array
	 */
	public static void bubble(int[] array){
		int[] a = array.clone();
		for(int i = 0; i<a.length; i++){
			for(int j = 0; j< a.length -1-i; j++){
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		printArray(a);
	}
	
	/**
	 * 插入排序
	 * @author LLJ
	 * @version 2017年3月22日下午9:55:41
	 * @param array
	 */
	public static void insert(int[] array){
		int[] a = array.clone();
		int temp,i,j;
		//有序|i|无序
		//有序i有序|i+1|无序
		for(i = 1; i< a.length; i++){
			temp = a[i];
			j = i-1;
			while(j>=0 && a[j]>temp){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
		}
		printArray(a);
	}
	
	/**
	 * 选择排序（不稳定）
	 * @author LLJ
	 * @version 2017年3月22日下午9:55:36
	 * @param array
	 */
	public static void selection(int[] array){
		int[] a = array.clone();
		int min;
		for(int i = 0; i < a.length-1; i++){
			min = i;
			for(int j = i+1; j < a.length; j++){
				if(a[j]<a[min]){
					min = j;
				}
			}
			int temp = a[min];
			a[min] = a[i];
			a[i] =temp;
		}
		printArray(a);
	}
	static int[] arr;
	private static void quick_sort_recursive(int start, int end) {
		if (start >= end)
			return;
		int mid = arr[end];
		int left = start, right = end - 1;
		while (left < right) {
			while (arr[left] <= mid && left < right)
				left++;
			while (arr[right] >= mid && left < right)
				right--;
			swap(left, right);
		}
		if (arr[left] >= arr[end])
			swap(left, end);
		else
			left++;
		quick_sort_recursive(start, left - 1);
		quick_sort_recursive(left + 1, end);
	}

	/**
	 * 快速排序，选一个基准，每次递归都找到这个基准所在的最后位置
	 * @author LLJ
	 * @version 2017年4月14日下午4:40:22
	 * @param arrin
	 */
	public static void quick(int[] arrin) {
		arr = arrin;
		quick_sort_recursive(0, arr.length - 1);
		printArray(arr);
	}

	public static void swap(int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/**
	 * 希尔排序
	 * @author LLJ
	 * @version 2017年4月14日下午9:36:24
	 */
	public static void shell(int[] array){
		int[] a = array.clone();
		
		int gap =1, i, j, len = a.length;
		int temp;
		while(gap<len/3){
			gap = gap*3+1;
		}
		for(;gap>0;gap/=3){
			for(i=gap; i<len;i++){
				temp= a[i];
				for(j=i-gap; j>=0 && a[j]>temp;j-=gap){
					a[j+gap] = a[j];
				}
				a[j+gap] = temp;
			}
		}
		printArray(a);
	}
	
	public static void printArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {45,6,34,5,7,12,65,23,4,5,2,34,34,67,234};
		//selection(array);
		//quick(array);
		shell(array);
		//Arrays.sort(array);
	}

}