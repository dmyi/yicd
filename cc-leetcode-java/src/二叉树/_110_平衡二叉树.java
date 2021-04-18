package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * @author cc
 *给定一个二叉树，判断它是否是高度平衡的二叉树。
 */
/**
 * 
 * @date   2020年11月4日 下午6:17:14
 * @author cc
 *
 */
public class _110_平衡二叉树 {
	
	public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
	
		return Math.abs(getTreeLevel(root.left) - getTreeLevel(root.right)) <= 1  && isBalanced(root.left) && isBalanced(root.right);
    }

	// 计算树的高度
    public int getTreeLevel(TreeNode root) {
        if(root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int level = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
	
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();		
				if(node.left != null) {
					queue.offer(node.left);
				}
				
				if(node.right != null) {
					queue.offer(node.right);
				}
			}
			level++;
		}
		
		return level;
	}
	
//	public boolean isBlanced(TreeNode root) {
//		if(root == null) return true;
//		
//		// return Math.abs(height(root.left) - height(root.right)) <= 1  && isBlanced(root.left) && isBlanced(root.right);
//		return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//	}
//	
//	public int height(TreeNode node) {
//		if(node == null) return 0;
//		return Math.max(height(node.left), height(node.right)) + 1;
//	}
	
//	public boolean isBalanced(TreeNode root) {
//        if(root == null) return true;
//        int left = root.left != null ? getTreeLevel(root.left) : 0;
//        int right = root.right != null ? getTreeLevel(root.right) : 0;
//        if(Math.abs(left - right) <= 1) return true;
//        
//        System.out.println();
//		
//		return false;
//    }
//	
//	public int getTreeLevel(TreeNode root) {
//		Queue<TreeNode> queue = new LinkedList<>();
//		queue.offer(root);
//		int level = 0;
//		while(!queue.isEmpty()) {
//			int size = queue.size();
//	
//			for (int i = 0; i < size; i++) {
//				TreeNode node = queue.poll();		
//				if(node.left != null) {
//					queue.offer(node.left);
//				}
//				
//				if(node.right != null) {
//					queue.offer(node.right);
//				}
//			}
//			level++;
//		}
//		
//		return level;
//	}
	
//	public int getTreeLevel(TreeNode root) {
//		Queue<TreeNode> queue = new LinkedList<>();
//		queue.offer(root);
//		int level = 0;
//		while(!queue.isEmpty()) {
//			int size = queue.size();
//			// List<Integer> list = new ArrayList<>();
//	
//			for (int i = 0; i < size; i++) {
//				TreeNode node = queue.poll();
//				// System.out.println(node.val);
//				// list.add(node.val);
//				
//				if(node.left != null) {
//					queue.offer(node.left);
//				}
//				
//				if(node.right != null) {
//					queue.offer(node.right);
//				}
//			}
//			level++;
//		}
//		
//		return level;
//	}
	
}
