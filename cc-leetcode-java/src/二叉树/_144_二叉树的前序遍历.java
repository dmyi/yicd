package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @date   2020年11月5日 上午11:23:50
 * @author cc
 *
 */
public class _144_二叉树的前序遍历 {
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if(root == null) return list;
		
		LinkedList<Integer> stack1 = new LinkedList<>();
		LinkedList<TreeNode> stack2 = new LinkedList<>();
		
		
		stack2.add(root);
		TreeNode node = null;
		while((node = stack2.pollLast()) != null) {
			stack1.add(node.val);
			if(node.right != null) {
				// 把根节点右节点加入栈
				stack2.add(node.right);
			}
			
			while(node.left != null) {
				node = node.left;
				stack1.add(node.val);
				if(node.right != null) {
					stack2.add(node.right);
				}
			}
		}
		
		while(!stack1.isEmpty()) {
			list.add(stack1.pollLast());
		}
		
		// 反转数组
		Collections.reverse(list);
		return list;
    }
}

///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode() {}
// *     TreeNode(int val) { this.val = val; }
// *     TreeNode(int val, TreeNode left, TreeNode right) {
// *         this.val = val;
// *         this.left = left;
// *         this.right = right;
// *     }
// * }
// */
//class Solution {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//		if(root == null) return list;
//		
//		LinkedList<Integer> stack1 = new LinkedList<>();
//		LinkedList<TreeNode> stack2 = new LinkedList<>();
//		
//		
//		stack2.add(root);
//		TreeNode node = null;
//		while((node = stack2.pollLast()) != null) {
//			stack1.push(node.val);
//			if(node.right != null) {
//				// 把根节点右节点加入栈
//				stack2.add(node.right);
//			}
//			
//			while(node.left != null) {
//				node = node.left;
//				stack1.push(node.val);
//				if(node.right != null) {
//					stack2.add(node.right);
//				}
//			}
//		}
//		
//		while(!stack1.isEmpty()) {
//			list.add(stack1.pop());
//		}
//		
//		// 反转数组
//		Collections.reverse(list);
//		return list;
//    }
//}
