/**
 * https://leetcode-cn.com/problems/can-place-flowers/
 * @date   2021年2月5日 下午8:59:06
 * @author cc
 *
 */
public class _605_种花问题 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();

	}
	
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		int first = 0;
		int last = 0;
		
		for(int i = 0; i < flowerbed.length; i++) {
			if(flowerbed[i] == 1) {
				if(first != 0) {
					count += (i - last - 1) >> 1;
					last = i + 1;
				} else {
					first = i + 1;
					last = i + 1;
				}				
			}		
		}

		if(first == 0) {
			count = (flowerbed.length + 1) >> 1;			
		} else {
			count += (first - 1) >> 1;
            count += (flowerbed.length - last) >> 1;
		}
				
		if(count >= n) {
			return true;
		}	
		return false;	
    }

}
