package 二叉树;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * @date   2020年11月4日 下午8:57:53
 * @author cc
 *
 */
public class _589_N叉树的前序遍历 {
	
	public List<Integer> preorder(Node root) {
		LinkedList<Node> stack = new LinkedList<>();
		LinkedList<Integer> list = new LinkedList<>();
		if(root == null) return list;
		
		stack.add(root);
		while(!stack.isEmpty()) {
			Node node = stack.pollLast();
			list.add(node.val);
			
			Collections.reverse(node.children);
			for(Node item : node.children) {
				stack.add(item);
			}
		}
		
		return list;
	}
	
//	public List<Integer> preorder(Node root) {
//		LinkedList<Node> stack = new LinkedList<>(); 
//		LinkedList<Integer> output = new LinkedList<>();
//		if(root == null) return output;
//		
//		stack.add(root);
//		while (!stack.isEmpty()) {
//			Node node = stack.pollLast();
//			output.add(node.val);
//			Collections.reverse(node.children);
//			for(Node item : node.children) {
//				stack.add(item);
//			}		
//		}
//		return output;
//	}
	
	/**
	 * 递归版本的实现
	 */
//	LinkedList<Integer> output = new LinkedList<>();
//    public List<Integer> preorder(Node root) {
//		if(root == null) return output;
//        
//		output.add(root.val);
//        for(Node item : root.children) {
//            preorder(item);
//        }
//		
//		return output;
//    }
}
