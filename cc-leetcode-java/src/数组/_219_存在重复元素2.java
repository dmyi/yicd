package 数组;

// https://leetcode-cn.com/problems/contains-duplicate-ii/
//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
//
// 
//
//示例 1:
//
//输入: nums = [1,2,3,1], k = 3
//输出: true
//示例 2:
//
//输入: nums = [1,0,1,1], k = 1
//输出: true
//示例 3:
//
//输入: nums = [1,2,3,1,2,3], k = 2
//输出: false
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/contains-duplicate-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class _219_存在重复元素2 {
	
	public static void main(String[] args) {
		
		// System.out.println(containsNearbyDuplicate(new int[] {1,2,3,1,2,3}, 2));
		System.out.println(containsNearbyDuplicate(new int[] {1,2,3,1}, 3));
	}
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		
		for (int i = 0; i < nums.length; i++) {
			int len = (i+k) < nums.length ? (i+k) : nums.length - 1;
			for (int j = i+1; j <= len; j++) {
				if(nums[i] == nums[j]) return true;
			}
		}
		return false;
    }
		
}
