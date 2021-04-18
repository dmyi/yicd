package 二叉树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @date   2020年11月5日 下午9:06:07
 * @author cc
 *
 */
//前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class _105_从前序与中序遍历序列构造二叉树 {
	public static void main(String[] args) {
		// System.out.println("hello world");
		TreeNode root = buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
		// System.out.println(rooTreeNode);
		preorderTravesal(root);
	}
	
	public static TreeNode getLeft(TreeNode node, ArrayList<Integer> pre, ArrayList<Integer> in) {
		int val = node.val;	
		if(pre.contains(val)) {
			pre.remove(pre.indexOf(val));
			return new TreeNode(pre.get(0));
		}
		return null;
	}
	
	public static TreeNode getRight(TreeNode node, ArrayList<Integer> pre, ArrayList<Integer> in) {
		int val = node.val;			
		int index = in.indexOf(val);
		int size = pre.size();
		for (int i = 0; i < size; i++) {
			if(in.indexOf(pre.get(i)) > index) {
				in.remove(in.indexOf(val));
				return new TreeNode(pre.get(i));
			}
		}
		
		return null;
	}
	
	public static void preorderTravesal(TreeNode node) {
		if(node == null) return;
		
		System.out.println(node.val);
		preorderTravesal(node.left);
		preorderTravesal(node.right);
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode root = new TreeNode(preorder[0]);
		TreeNode node = root;

		ArrayList<Integer> pre = new ArrayList<>();
		ArrayList<Integer> in = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		
		for(int num : preorder) {
			pre.add(num);
		}	
		for(int num : inorder) {
			in.add(num);
		}
		
		queue.offer(root);
		while(!queue.isEmpty()) {
			node = queue.poll();
			
			node.left = getLeft(node, pre, in);
			node.right = getRight(node, pre, in);
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}			
		}
		
		return root;
    }
	
	public int singleNumber(int[] nums) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums) {
			Integer count = map.get(num);
			// count = count == null ? 1 : ++count;
			count = count == null ? 1 : ++count;
			map.put(num, count);
		}
		
		// 遍历哈希表
		for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.
	}
}

//int flag = 0;
//for(int num : inorder) {
//	if(num == preorder[0]) {
//		flag = 1;
//		continue;
//	}
//	if(flag == 0) {
//		left.add(num);
//	} else {
//		right.add(num);
//	}
//}
//
//for (int i = 1; i < inorder.length; i++) {
//	if(!left.contains(preorder[i])) {
//		root.right = new TreeNode(preorder[i]);
//	}
//		
//}

