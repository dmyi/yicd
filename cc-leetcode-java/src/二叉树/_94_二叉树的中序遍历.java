package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class _94_二叉树的中序遍历 {
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
	
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	     TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	     }
	  }

    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
    	inorder(root);
    	
    	return list;
    }
    
    // 递归的方法实现
    public void inorder(TreeNode node) {
    	if(node == null) return;
    	
    	inorder(node.left);
    	list.add(node.val);
    	inorder(node.right);
    }

}
