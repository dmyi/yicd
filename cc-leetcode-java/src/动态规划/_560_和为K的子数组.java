package 动态规划;

import java.util.HashMap;
import java.util.Map;

public class _560_和为K的子数组 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int res = 0;
		map.put(0,1); // 压入默认值
		
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(map.containsKey(sum - k)) {
				res += map.get(sum - k);
			}
			
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		
		return res;
    }

}
