package 链表;

import 二叉树.TreeNode;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * @date   2021年2月12日 上午11:14:09
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

//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}

public class _114_二叉树展开为链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void flatten(TreeNode root) {
		if(root == null) return;
		
		if(root.left != null) {
            TreeNode oldRight = root.right;
            root.right = root.left;
            root.left = null;
            
            TreeNode rightMost = root;
            while(rightMost.right != null) {
                rightMost = rightMost.right;
            }
            rightMost.right = oldRight;
		}
				
		flatten(root.right);		
    }

}
