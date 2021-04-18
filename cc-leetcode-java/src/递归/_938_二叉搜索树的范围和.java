package 递归;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * @date   2020年11月6日 下午11:07:58
 * @author cc
 *
 */
public class _938_二叉搜索树的范围和 {
	
	public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        
		ArrayList<Integer> list = new ArrayList<>();
		inorder(root, list);
		int begin = list.indexOf(low);
		int end = list.indexOf(high);
		int sum = 0;
		
		for (int i = begin; i <= end; i++) {
			sum += list.get(i);
		}
		return sum;
    }
	
	// 用中序遍历实现
    public static void inorder(TreeNode node, ArrayList<Integer> list) {
        if(node == null) return;
		
		inorder(node.left, list);
        list.add(node.val);
		inorder(node.right, list);
	}
}
