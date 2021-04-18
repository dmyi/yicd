package 位运算;

public class _477_汉明距离总和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int totalHammingDistance(int[] nums) {
		int sum = 0;
		for(int i = 0; i < nums.length -1; i++) {
			for(int j = i+1; j < nums.length; j++) {
				sum += hammingDistance(nums[i], nums[j]);
			}
		}
		
		return sum;
    }
	
	public int hammingDistance(int x, int y) {
		int n = x ^ y;
		
		int count = 0;
		while(n != 0) {
			count++;
			n &= n-1;
		}
		
		return count;
    }

}
