package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 * @date   2021年2月11日 下午2:24:25
 * @author cc
 *
 */

public class _119_杨辉三角II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
			
		for(int i = 0; i <= rowIndex; i++) {
			List<Integer> row = new ArrayList<Integer>();
			for(int j = 0; j <= i; j++ ) {
				if(j == 0 || j == i) {
					row.add(1);
				} else {
					row.add(list.get(j-1)+list.get(j));
				}
			}
			list = row;
		}
		
		return list;
    }

}
