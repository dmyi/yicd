package 动态规划;

//1143. 最长公共子序列
//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
//
//一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
//
//若这两个字符串没有公共子序列，则返回 0。
//
// 
//
//示例 1:
//
//输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
//示例 2:
//
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
//示例 3:
//
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
//提示:
//
//1 <= text1.length <= 1000
//1 <= text2.length <= 1000
//输入的字符串只含有小写英文字符。

// https://leetcode-cn.com/problems/longest-common-subsequence/

public class LCS {
	public static void main(String[] args) {
		// System.out.println(lcs(new int[] {1,4,9,10}, new int[] {1, 2, 4, 9, 10}));
		System.out.println(lcs1(new int[] {1,4,9,10}, new int[] {1, 2, 4, 9, 10}));
	}
	// 数组初始化的时候已完成
//	dp[0][1] = 0;
//	dp[1][0] = 0;
	
	public static int lcs(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length == 0) return 0;
		if(nums2 == null || nums2.length == 0) return 0;
		
		int[][] dp = new int[nums1.length+1][nums2.length+1];
		for (int i = 1; i <= nums1.length; i++) {
			for (int j = 1; j <= nums2.length; j++) {
				if(nums1[i-1] == nums2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		return dp[nums1.length][nums2.length];
	}
	
	// 采用递归的方式实现
	public static int lcs1(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length == 0) return 0;
		if(nums2 == null || nums2.length == 0) return 0;
		
		return lcs1(nums1,nums1.length, nums2,nums2.length);
	}
	
	public static int lcs1(int[] nums1, int i, int[] nums2, int j) {
		// 递归基
		if(i == 0 || j == 0) return 0;
		if(nums1[i-1] == nums2[j-1]) {
			return lcs1(nums1,i-1, nums2, j-1) + 1;
		} else {
			return Math.max(lcs1(nums1, i, nums2, j-1), lcs1(nums1,i-1, nums2, j));
		}
	}
	
//	class Solution {
//	    public int longestCommonSubsequence(String text1, String text2) {
//	        if(text1 == null || text1.length() == 0) return 0;
//			if(text2 == null || text2.length() == 0) return 0;
//			
//			int[][] dp = new int[text1.length()+1][text2.length()+1];
//			for (int i = 1; i <= text1.length(); i++) {
//				for (int j = 1; j <= text2.length(); j++) {
//	                char c1 = text1.charAt(i-1), c2 = text2.charAt(j-1);
//					if(c1 == c2) {
//						dp[i][j] = dp[i-1][j-1] + 1;
//					} else {
//						dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
//					}
//				}
//			}
//			
//			return dp[text1.length()][text2.length()];
//	    }
//	}
	
	
}
