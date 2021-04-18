package 动态规划;

// https://leetcode-cn.com/problems/contiguous-sequence-lcci/
public class _面试题1617连续数列 {
	 public int maxSubArray(int[] nums) {
	        if(nums == null || nums.length == 0) return 0;
	        
	        int[] dp = new int[nums.length];
	        dp[0] = 0;
	        int max = dp[0];
	        
	        for (int i = 1; i < dp.length; i++) {
				if(dp[i - 1] <= 0) {
					dp[i] = nums[i];
				} else {
					dp[i] = dp[i - 1] + nums[i];
				}
				max = Math.max(dp[i], max);
			}
	        
	        return max;
	 }
}
