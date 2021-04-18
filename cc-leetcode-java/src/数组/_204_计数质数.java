package 数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/count-primes/
 * @date   2021年2月6日 下午6:37:53
 * @author cc
 *
 */

public class _204_计数质数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	public int countPrimes(int n) {
//		int[] isPrimes = new int[n];
//		Arrays.fill(isPrimes, 1);
//		
//		int ans = 0;
//		for(int i = 2; i < n; i++) {
//			if(isPrimes[i] == 1) {
//				ans += 1;
//				
//				if((long)i * i < n) {
//					for(int j = i * i; j < n; j += i) {
//						isPrimes[j] = 0;
//					}
//				}
//			}
//		}
//		
//		return ans;
//    }
	
	public int countPrimes(int n) {
		int ans = 0;
		for(int i = 2; i < n; i++) {
			ans += isPrimes(i) ? 1 : 0;
		}
		
		return ans;
	}
	
	public boolean isPrimes(int n) {
		for(int i = 2; i <= n; i++) {
			if((n % i) == 0) {
				return false;
			}
		}
		
		return true;
	}

}
