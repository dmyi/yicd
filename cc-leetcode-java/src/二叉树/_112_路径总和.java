package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/path-sum/
 * @date   2021年2月12日 下午2:29:03
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

public class _112_路径总和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// 方法1 广度优先
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) {
			return false;
		}
		
		Queue<TreeNode> queNode = new LinkedList<TreeNode>();
		Queue<Integer> queVal = new LinkedList<Integer>();
		
		queNode.offer(root);
		queVal.offer(root.val);
		while (!queNode.isEmpty()) {
			TreeNode now = queNode.poll();
			int temp = queVal.poll();
			
			if(now.left == null && now.right == null) {
				if(temp == targetSum) {
					return true;
				}
				continue;
			}
			
			if(now.left != null) {
				queNode.offer(now.left);
				queVal.offer(now.left.val + temp);
			}
			
			if(now.right != null) {
				queNode.offer(now.right);
				queVal.offer(now.right.val + temp);
			}
		}
		
		return false;	
	}
	
	
	// 方法2递归
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) return false;
		// 判断是不是叶子节点
		if(root.left == null && root.right == null) {
			return targetSum == root.val;
		}
		
		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
	
}
