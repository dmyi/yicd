package com.cc;

/**
 * https://leetcode-cn.com/problems/island-perimeter/
 * @date   2020年11月10日 下午5:05:57
 * @author cc
 *
 */
//方法一：迭代
//思路与算法
//
//对于一个陆地格子的每条边，它被算作岛屿的周长当且仅当这条边为网格的边界或者相邻的另一个格子为水域。 
// 因此，我们可以遍历每个陆地格子，看其四个方向是否为边界或者水域，如果是，将这条边的贡献（即 11）加入答案 \textit{ans}ans 中即可。

//一块土地原则上会带来 4 个周长，但岛上的土地存在接壤，每一条接壤，会减掉 2 个边长。
//所以，总周长 = 4 * 土地个数 - 2 * 接壤边的条数。

public class _463_岛屿的周长 {

    public int islandPerimeter(int[][] grid) {
    	int n = grid.length, m = grid[0].length;
        int land = 0;
        int border = 0;
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {          	
                if (grid[i][j] == 1) {
                    land++;
                    if(i < n - 1 && grid[i+1][j] == 1) {
                    	border++;
                    }
                    if(j < m - 1 && grid[i][j+1] == 1) {
                    	border++;
                    }
                }              
            }
        }
        return (land << 2) - (border << 1);
    }

}
