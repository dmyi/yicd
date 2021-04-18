package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
public class _102_二叉树的层序遍历 {
	
	 public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

	 public List<List<Integer>> levelOrder(TreeNode root) {
		 
		 Stack<List<Integer>> stack = new Stack<List<Integer>>();
		 
		 
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            lists.add(list);
        }

        return lists;
    }
	  
}
