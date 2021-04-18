package 动态规划;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @date   2021年2月13日 上午11:36:37
 * @author cc
 *
 */
public class _53_最大子序和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		
		// 自下而上递推求子问题的解
		for(int i = 1; i < nums.length; i++) {
			if(dp[i - 1] <= 0) {
				dp[i] = nums[i];
			} else {
				dp[i] = dp[i - 1] + nums[i];
			}
			
			// 选出最优解
			max = Math.max(dp[i], max);
		}
		
		return max;
    }

}
