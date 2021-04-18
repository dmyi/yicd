package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * @date   2021年2月14日 上午10:19:40
 * @author cc
 *
 */

public class _1143_最长公共子序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text1.length() == 0) {
        	return 0;
        }
        if(text2 == null || text2.length() == 0) {
        	return 0;
        }
        
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i = 1; i <= text1.length(); i++) {
        	for(int j = 1; j <= text2.length(); j++) {
        		
        		char c1 = text1.charAt(i - 1);
        		char c2 = text2.charAt(j - 1);
            	if(c1 == c2) {
            		dp[i][j] = dp[i-1][j-1] + 1;
            	} else {
            		dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            	}
            }
        }
        
        return dp[text1.length()][text2.length()];
    }

}








class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text1.length() == 0) return 0;
		if(text2 == null || text2.length() == 0) return 0;
		
		int[][] dp = new int[text1.length()+1][text2.length()+1];
		for (int i = 1; i <= text1.length(); i++) {
			for (int j = 1; j <= text2.length(); j++) {
                char c1 = text1.charAt(i-1), c2 = text2.charAt(j-1);
				if(c1 == c2) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		return dp[text1.length()][text2.length()];
    }
}
