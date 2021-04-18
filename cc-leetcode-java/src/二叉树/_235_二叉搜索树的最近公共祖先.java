package 二叉树;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @date   2021年2月7日 下午10:58:05
 * @author cc
 *
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class _235_二叉搜索树的最近公共祖先 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val <= root.val && q.val >= root.val) {
        	return root;
        } else if(p.val >= root.val && q.val <= root.val) {
        	return root;
        } else if(p.val <= root.val) {
        	return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q); 
        }
        
        // return lowestCommonAncestor(root.right, p, q); 
    }

}
