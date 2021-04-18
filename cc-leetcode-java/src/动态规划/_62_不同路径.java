package 动态规划;

import java.util.concurrent.ForkJoinPool.ManagedBlocker;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * @date   2020年11月6日 下午4:06:19
 * @author cc
 *
 */
public class _62_不同路径 {
	public static void main(String[] args) {
		
		System.out.println(uniquePaths(3, 2));
	}
	
	// 这种方法也是可以的
	public static int uniquePaths(int m, int n) {       
		int[][] dp = new int[m][n];
		
		if(m == 1 || n== 1) return 1;
		dp[0][1] = dp[1][0] = 1;
		for (int i = 1; i < m; i++) {			
			for (int j = 1; j < n; j++) {
				dp[i][0] = 1;
				dp[0][j] = 1;
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		return dp[m-1][n-1];
    }
	
	public static int uniquePaths2(int m, int n) {       
		int[][] dp = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {			
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		return dp[m-1][n-1];
    }
}
