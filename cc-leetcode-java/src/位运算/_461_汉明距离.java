package 位运算;

public class _461_汉明距离 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
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
