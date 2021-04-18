package 动态规划;

/**
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 * @date   2021年2月14日 下午3:20:42
 * @author cc
 *
 */
public class _523_连续的子数组和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean checkSubarraySum(int[] nums, int k) {
		if(nums == null || nums.length <2) {
			return false;
		}
		if(k < 0) {
			return false;
		}
		
		for(int i = 1; i < nums.length; i++) {
			int sum = 0;
			for(int j = 0; j <= i; j++) {
				// for(int k = )
			}
		}
		
		return false;
    }

}



