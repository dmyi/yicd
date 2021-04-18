package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * @date   2021年2月14日 上午7:36:43
 * @author cc
 *
 */
public class _300_最长递增子序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int max = 1;
		for(int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(nums[i] <= nums[j]) {
					continue;
				}
				dp[i] = Math.max(dp[i], dp[j] + 1);					
			}
			max = Math.max(dp[i], max);
		}
		
		return max;
    }
}












//class Solution {
//    public int lengthOfLIS(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//		int[] dp = new int[nums.length];
//		int max = dp[0] = 1;
//		
//		for (int i = 1; i < dp.length; i++) {
//			dp[i] = 1;
//			for (int j = 0; j < i; j++) {
//				if(nums[i] <= nums[j]) continue;
//				dp[i] = Math.max(dp[i], dp[j] + 1);
//			}
//			max = Math.max(dp[i], max);
//		}
//		return max;
//    }
//}
