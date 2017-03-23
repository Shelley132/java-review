package com.cn.llj.leetcodes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class MinHeap
{
	// 堆的存储结构 - 数组,改成ArrayList即可
	private ArrayList<Entry<Integer,Integer>> data;
	
	// 将一个数组传入构造方法，并转换成一个小根堆
	public MinHeap(ArrayList<Entry<Integer,Integer>> data)
	{
		this.data = data;
		buildHeap();
	}
	
	// 将数组转换成最小堆
	private void buildHeap()
	{
		// 完全二叉树只有数组下标小于或等于 (data.length) / 2 - 1 的元素有孩子结点，遍历这些结点。
		// *比如上面的图中，数组有10个元素， (data.length) / 2 - 1的值为4，a[4]有孩子结点，但a[5]没有*
        for (int i = (data.size()) / 2 - 1; i >= 0; i--) 
        {
        	// 对有孩子结点的元素heapify
            heapify(i);
        }
    }
	
	private void heapify(int i)
	{
		// 获取左右结点的数组下标
        int l = left(i);  
        int r = right(i);
        
        // 这是一个临时变量，表示 跟结点、左结点、右结点中最小的值的结点的下标
        int smallest = i;;
        
        // 存在左结点，且左结点的值小于根结点的值
        if (l < data.size() && data.get(l).getValue() < data.get(i).getValue())  
        	smallest = l;  
        
        // 存在右结点，且右结点的值小于以上比较的较小值
        if (r < data.size() && data.get(r).getValue() < data.get(smallest).getValue())  
        	smallest = r;  
        
        // 左右结点的值都大于根节点，直接return，不做任何操作
        if (i == smallest)  
            return;  
        
        // 交换根节点和左右结点中最小的那个值，把根节点的值替换下去
        swap(i, smallest);
        
        // 由于替换后左右子树会被影响，所以要对受影响的子树再进行heapify
        heapify(smallest);
    }
	
	// 获取右结点的数组下标
	private int right(int i)
	{  
        return (i + 1) << 1;  
    }   

	// 获取左结点的数组下标
    private int left(int i) 
    {  
        return ((i + 1) << 1) - 1;  
    }
    
    // 交换元素位置
    private void swap(int i, int j) 
    {  
    	Entry<Integer,Integer> tmp = data.get(i);
    	data.set(i, data.get(j));
    	data.set(j, tmp);
    }
    
    // 获取对中的最小的元素，根元素
    public Entry<Integer,Integer> getRoot()
    {
    	    return data.get(0);
    }

    // 替换根元素，并重新heapify
	public void setRoot(Entry<Integer,Integer> root)
	{
		data.set(0, root);
		heapify(0);
	}
}
public class ThreeHundredFortySeven {

	
	 public List<Integer> topKFrequent(int[] nums, int k) {
		 
		 Map<Integer,Integer> map = new HashMap<Integer,Integer>();
			
			for(int i = 0; i < nums.length; i++){
				if(map.containsKey(nums[i])){
					Integer value = map.get(nums[i]);
					map.replace(nums[i], value+1);
				}else{
					map.put(nums[i], 1);
				}
			}
			
			ArrayList<Entry<Integer,Integer>> data = new ArrayList<Entry<Integer,Integer>>();
			Iterator<Entry<Integer, Integer>> iter  = map.entrySet().iterator();
			while(iter.hasNext()){
				Entry<Integer,Integer> entry = (Entry<Integer, Integer>) iter.next();
				data.add(entry);
			}
		 ArrayList<Entry<Integer,Integer>> topk = new ArrayList<Entry<Integer,Integer>>();
			for (int i = 0; i < k; i++) {
				topk.add(data.get(i));
			}
			// 转换成最小堆
			MinHeap heap = new MinHeap(topk);
			// 从k开始，遍历data
			for (int i = k; i < data.size(); i++) {
				Entry<Integer,Integer> root = heap.getRoot();
				// 当数据小于堆中最大的数（根节点）时，替换堆中的根节点，再转换成堆
				if (data.get(i).getValue() > root.getValue()) {
					heap.setRoot(data.get(i));
				}
			}
			List<Integer> result = new ArrayList<Integer>();
			for(int i = 0; i < topk.size(); i++){
				result.add(topk.get(i).getKey());
			}
			return result;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
