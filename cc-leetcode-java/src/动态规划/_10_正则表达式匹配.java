package 动态规划;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * @date   2021年2月14日 下午3:50:34
 * @author cc
 *
 */
public class _10_正则表达式匹配 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	public boolean isMatch(String s, String p) {
//		
//    }
//	
//	public boolean matches(String s, String p, int i, int j) {
//		
//	}

}

//class Solution {
//    public boolean isMatch(String s, String p) {
//        int m = s.length();
//        int n = p.length();
//
//        boolean[][] f = new boolean[m + 1][n + 1];
//        f[0][0] = true;
//        for (int i = 0; i <= m; ++i) {
//            for (int j = 1; j <= n; ++j) {
//                if (p.charAt(j - 1) == '*') {
//                    f[i][j] = f[i][j - 2];
//                    if (matches(s, p, i, j - 1)) {
//                        f[i][j] = f[i][j] || f[i - 1][j];
//                    }
//                } else {
//                    if (matches(s, p, i, j)) {
//                        f[i][j] = f[i - 1][j - 1];
//                    }
//                }
//            }
//        }
//        return f[m][n];
//    }
//
//    public boolean matches(String s, String p, int i, int j) {
//        if (i == 0) {
//            return false;
//        }
//        if (p.charAt(j - 1) == '.') {
//            return true;
//        }
//        return s.charAt(i - 1) == p.charAt(j - 1);
//    }
//}
//
//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/regular-expression-matching/solution/zheng-ze-biao-da-shi-pi-pei-by-leetcode-solution/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

