package 动态规划;

import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * @date   2020年11月6日 下午2:01:38
 * @author cc
 *
 */
//示例：
//
//输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
public class _718_最长重复子数组 {
	public static void main(String[] args) {
		
		System.out.println(findLength(new int[] {1,2,3,2,1,7}, new int[] {3,2,1,4,7}));
	}
	 public static int findLength(int[] A, int[] B) {
		 int lenA = A.length;
		 int lenB = B.length;
		 
		 int[][] dp = new int[lenA + 1][lenB + 1];
		 int max = 0;
		 for (int i = 0; i < lenA; i++) {
			for (int j = 0; j < lenB; j++) {
				if(A[i] == B[j]) {
					dp[i+1][j+1] = dp[i][j] + 1;
				} else {
					dp[i+1][j+1] = 0;
				}				
				max = Math.max(dp[i+1][j+1], max);
			}
		 }
		 
		 return max;
	 }
}
