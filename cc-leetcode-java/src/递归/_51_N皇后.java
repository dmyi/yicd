package 递归;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * @date   2020年11月8日 上午8:24:35
 * @author cc
 *
 */

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//提示：
//皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
public class _51_N皇后 {
    int[] cols;
	List<List<String>> lists = new ArrayList<List<String>>();

    public List<List<String>> solveNQueens(int n) {
        if(n < 1) {
			return lists;
		}	
		cols = new int[n];
		place(0);		
		return lists;
    }

    public void place(int row) {
    	if(row == cols.length) {
			show();
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
			if(row -i == Math.abs(col - cols[i])) return false;
		}
		return true;
	}
	
	public void show() {
        List<String> list = new ArrayList<String>();
		for (int row = 0; row < cols.length; row++) {
            StringBuilder str = new StringBuilder();			
			for (int col = 0; col < cols.length; col++) {
				if(cols[row] == col) {
					str.append("Q");
				} else {
					str.append(".");
				}
			}
			list.add(str.toString());
		}
		lists.add(list);
	}
}
