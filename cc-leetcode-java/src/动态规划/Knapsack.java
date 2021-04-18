package 动态规划;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] values = {6,3,5,4,6};
//		int[] weights = {2,2,6,5,4};
//		int capacity = 10;
//		System.out.println(maxValue(values, weights, capacity));
		System.out.println("hello");
	}
	
//	static int maxValue(int[] values, int[] weights, int capacity) {
//		if(values == null || values.length == 0) {
//			return 0;
//		}
//		
//		if(weights == null || weights.length == 0) {
//			return 0;
//		}
//		
//		if(values.length != weights.length || capacity <= 0) {
//			return 0;
//		}
//		
//		int[][] dp = new int[values.length + 1][capacity];
//		for(int i = 1; i <= values.length; i++) {
//			for(int j = 1; j <= capacity; j++) {
//				if(capacity < weights[i]) {
//					dp[i][j] = dp[i-1][j];
//				} else {
//					dp[i][j] = values[i] + dp[i-1][j - weights[i]];
//				}
//			}
//		}
//		
//		return dp[values.length][capacity];
//	}

}
