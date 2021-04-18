package 字符串;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 * @date   2020年11月8日 下午4:20:16
 * @author cc
 *
 */
public class _168_Excel表列名称 {
	
	// 本质考察的是1进制转化为26进制，1. 字符串的插入
	public String convertToTitle(int n) {
        StringBuilder str = new StringBuilder();
        while(n > 0) {
            int c = n % 26;
            if(c == 0) {
                c = 26;
                n -= 1;
            }
            str.insert(0, (char)('A' + c -1));
            n /= 26;
        }

        return str.toString();
    }
}
