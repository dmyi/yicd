package com.cc;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 * @date   2020年11月8日 下午2:08:17
 * @author cc
 *
 */
public class _69_x的平方根 {
	public int mySqrt(int x) {
		if(x == 0) return 0;
		int left = 0, right = x, res = -1;
		
		// 二分查找最合适的接近值
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if((long)mid * mid <= x) {
				res = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return res;
    }
}
