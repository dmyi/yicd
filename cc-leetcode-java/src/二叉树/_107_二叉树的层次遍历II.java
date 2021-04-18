package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * @date   2020年11月5日 上午10:43:27
 * @author cc
 *
 */
public class _107_二叉树的层次遍历II {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;
        
        // 用栈来存储一维数组
        LinkedList<List<Integer>> stack = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {         
            int size = queue.size();           
            List<Integer> list = new ArrayList<>();
            
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            stack.push(list);
        }
        
        while(!stack.isEmpty()) {
        	lists.add(stack.pop());
        }
        
        return lists;
    }
}
