package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @date   2020年11月5日 下午3:44:38
 * @author cc
 *
 */
public class _145_二叉树的后序遍历 {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        if(root.right != null) {
        	stack.add(root.right);
        }
        if(root.left != null) {
        	stack.add(root.left);
        }
        
        TreeNode node = null;
        TreeNode lastNode = root;
        while (!stack.isEmpty()) {
			node = stack.peekLast();
			if(node.right == lastNode || node.left == lastNode) {
				lastNode = stack.pollLast();
				list.add(lastNode.val);
				continue;
			}
			
			while(node.left != null || node.right != null) {
				if(node.right != null) {
		        	stack.add(node.right);
		        }
		        if(node.left != null) {
		        	stack.add(node.left);
		        }
		        node = node.left != null ? node.left : node.right;
			}
			lastNode = stack.pollLast();
			list.add(lastNode.val);
		}
        
        return list;
    }
}
