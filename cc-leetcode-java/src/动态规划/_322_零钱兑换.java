package 动态规划;
/**
 * https://leetcode-cn.com/problems/coin-change/
 * @date   2021年2月13日 上午7:51:00
 * @author cc
 *
 */

public class _322_零钱兑换 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int coinChange(int[] coins, int amount) {
		if(amount == 0) {
			return 0;
		}
		
		int[] dp = new int[amount + 1];
		for(int i = 1; i <= amount; i++) {
			int min = Integer.MAX_VALUE;
			for(int num : coins) {
				if(i < num || dp[i - num] < 0) {
					continue;
				}
				min = Math.min(min, dp[i-num]);
			}
			
			if(min == Integer.MAX_VALUE) {
				dp[i] = -1;
			} else {
				dp[i] = min + 1;
			}
		}
		
		return dp[amount];
	}
	
	// 递归实现
//	public int coinChange2(int[] coins, int amount) {
//		if(amount < 1) {
//			return Integer.MAX_VALUE;
//		}
//		for(int num : coins) {
//			if(num == amount) {
//				return 1;
//			}
//		}
//		
//
//		for(int num : coins) {
//			if(i < num || dp[i - num] < 0) {
//				continue;
//			}
//			
//			min = Math.min(dp[i - num], min);
//		}
//
//		return dp[amount];
//	}
	
//	if(amount == 0) {
//		return 0;
//	}
//	
//	int[] dp = new int[amount + 1];
//	for(int i = 1; i < amount+1; i++) {
//		int min = Integer.MAX_VALUE;
//		// 求出所有面值中的最小值
//		for(int num : coins) {
//			if(i < num || dp[i - num] < 0) {
//				continue;
//			}
//			
//			min = Math.min(dp[i - num], min);
//		}
//		
//		if(min == Integer.MAX_VALUE) {
//			dp[i] = -1;
//		} else {
//			dp[i] = min + 1;
//		}
//	}
//	
//	return dp[amount];

}
