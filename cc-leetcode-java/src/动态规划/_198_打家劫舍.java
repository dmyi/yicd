package 动态规划;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * @date   2021年2月12日 上午8:36:07
 * @author cc
 *
 */

public class _198_打家劫舍 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 可选择偷还是不偷
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
		}
		
		return dp[nums.length - 1];
     }

}
