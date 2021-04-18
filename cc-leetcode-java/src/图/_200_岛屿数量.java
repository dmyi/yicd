package 图;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * @date   2021年2月6日 下午5:02:35
 * @author cc
 *
 */

public class _200_岛屿数量 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int numIslands(char[][] grid) {
		int count = 0;
		for(int i = 0; i < grid.length; i++) { 
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}
		
		return count;
    }
	
	public void dfs(char[][] grid, int r, int c) {
		if(!inArea(grid, r, c)) {
			return;
		}
		
		if(grid[r][c] != '1') {
			return;
		}
		
		grid[r][c] = '2';
		
		dfs(grid, r - 1, c);
		dfs(grid, r + 1, c);
		dfs(grid, r, c - 1);
		dfs(grid, r, c + 1);
	}
	
	public boolean inArea(char[][] grid, int r, int c) {
		return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
	}

}
