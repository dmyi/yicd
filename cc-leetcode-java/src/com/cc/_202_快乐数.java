package com.cc;

import java.util.HashSet;
import java.util.Set;

public class _202_快乐数 {
	public int bitSquareSum(int x) {
		int sum = 0,cur;
		while(x > 0) {
			cur = x % 10;
			sum += cur * cur;
			x /= 10;
		}		
		return sum;
	}
	
	public boolean isHappy(int n) {
		Set<Integer> seen = new HashSet<Integer>();
		seen.add(n);
		
		while(n != 1) {
			n = bitSquareSum(n);
			if(!seen.add(n)) {
				return false;
			}
		}
		
		return true;
	}
	
}
