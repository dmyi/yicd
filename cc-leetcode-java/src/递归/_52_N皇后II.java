package 递归;

/**
 * https://leetcode-cn.com/problems/n-queens-ii/
 * @date   2020年11月8日 下午12:47:26
 * @author cc
 *
 */
public class _52_N皇后II {
	
	int[] cols;
	int ways = 0;
	public int totalNQueens(int n) {
		if(n < 1) return 0;
		
		cols = new int[n];
		place(0);	
		return ways;
    }
	
	public void place(int row) {
		if(row == cols.length) {
			ways++;
			return;
		}
		
		for (int col = 0; col < cols.length; col++) {
			if(isValid(row, col)) {
				cols[row] = col;
				place(row + 1);
			}
		}
	}
	
	public boolean isValid(int row, int col) {
		for (int i = 0; i < row; i++) {
			if(cols[i] == col) return false;
			if(row - i == Math.abs(col - cols[i])) return false;
		}
		
		return true;
	}
	
}
