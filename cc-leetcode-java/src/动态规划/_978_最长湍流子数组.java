package 动态规划;

import java.awt.image.RescaleOp;

/**
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/
 * @date   2021年2月14日 下午4:21:12
 * @author cc
 *
 */
public class _978_最长湍流子数组 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxTurbulenceSize(int[] arr) {
		int len = arr.length;
		if(len < 2) {
			return len;
		}
		
		int[] increased = new int[len];
		int[] decreased = new int[len];
		
		increased[0] = 1;
		decreased[0] = 1;
		int res = 1;
		for(int i = 1; i < len; i++) {
			if(arr[i-1] > arr[i]) {
				increased[i] = decreased[i-1] + 1;
				decreased[i] = 1;
			} else if(arr[i-1] < arr[i]) {
				decreased[i] = increased[i-1] + 1;
				increased[i] = 1;
			} else {
				// 重置
				increased[i] = 1;
				decreased[i] = 1;
			}
			res = Math.max(res, Math.max(increased[i], decreased[i]));
		}
		
		return res;
    }
}
