package 动态规划;

import java.util.HashSet;
import java.util.Set;

public class _128_最长连续序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello, world");
		
	}
	
	public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums) {
        	set.add(i);
        }
        
        int max = 1;
        for(int num : nums) {
        	if(set.remove(num)) {
        		int val = num;
            	int count = 1;
            	
            	while(set.remove(val - 1)) {
            		val--;
            	}
            	count += num - val;
            	
            	val = num;
            	while(set.remove(val + 1)) {
            		val++;
            	}
            	count += val - num;
            	
            	max = Math.max(max, count);
        	}
        }
        	
        return max;
    }

}
