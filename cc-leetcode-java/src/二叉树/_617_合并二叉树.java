package 二叉树;

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
/*
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class _617_合并二叉树 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null) return t2;
		if(t2 == null) return t1;
		
		TreeNode mergeNode = new TreeNode(t1.val + t2.val);
		mergeNode.left = mergeTrees(t1.left, t2.left);
		mergeNode.right = mergeTrees(t1.right, t2.right);
		
		return mergeNode;
    }

}
