package 二叉树;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * @date   2021年2月11日 下午3:22:32
 * @author cc
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class _99_恢复二叉搜索树 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private TreeNode prev;
	private TreeNode first;
	private TreeNode second;
	
	public void recoverTree(TreeNode root) {
		findwrongNode(root);
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
    }
	
	public void findwrongNode(TreeNode root) {
		if(root == null) return;
		findwrongNode(root.left);
		 
		if(prev != null && prev.val > root.val) {
			second = root;
			
			if(first != null) return;
			first = prev;
		}
		
		prev = root;
		findwrongNode(root.right);
	}

}
