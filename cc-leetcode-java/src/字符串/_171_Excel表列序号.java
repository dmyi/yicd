package 字符串;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 * @date   2020年11月8日 下午4:30:48
 * @author cc
 *
 */
public class _171_Excel表列序号 {
	public int titleToNumber(String s) {
		int ans = 0;
		for(int i = 0; i < s.length(); i++) {
			int num = s.charAt(i) - 'A' + 1;
			ans = ans * 26 + num;
		}
		
		return ans;
    }
}
