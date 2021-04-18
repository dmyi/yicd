
public class _42_接雨水 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int trap(int[] height) {
		int ans = 0;
		
		for(int i = 0; i < height.length; i++) {
			int max_left = 0;
			int max_right = 0;
			for(int j = i - 1; j >= 0; j--) {
				max_left = Math.max(max_left, height[j]);
			}
			
			for(int j = i + 1; j < height.length; j++) {
				max_right = Math.max(max_right, height[j]);
			}
			
			if(max_left > height[i] && max_right > height[i]) {
				ans += Math.min(max_left, max_right) - height[i];
			}
		}
		
		return ans;
    }

}
