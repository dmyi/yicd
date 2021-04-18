package 递归;

/**
 * https://leetcode-cn.com/problems/binary-tree-tilt/
 * @date   2020年11月7日 下午5:06:54
 * @author cc
 *
 */
public class _563_二叉树的坡度 {
	public int findTilt(TreeNode root) {
		if(root == null || root.left == null || root.right == null) return 0;
		
		find(root);
			
		return 0;
    }
	
	public static int find(TreeNode node) {
		if(node == null || node.left == null || node.right == null) return 0;
		
		return 0;
	}
}
