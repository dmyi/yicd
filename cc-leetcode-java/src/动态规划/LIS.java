package 动态规划;

public class LIS {
	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] {100, 2, 102, 180}));
	}
	
	public static int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int[] dp = new int[nums.length];
		int max = dp[0] = 1;
		
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(nums[i] <= nums[j]) continue;
				dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}
}
