package 数组;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 * @date   2021年2月11日 上午8:10:24
 * @author cc
 *
 */


public class _118_杨辉三角 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<Integer>();
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					row.add(1);
				} else {
					row.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
				}
			}
			list.add(row);
		}
		
		return list;
    }

}
