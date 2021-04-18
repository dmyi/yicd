package 二叉树;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import 链表.ListNode;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * @date   2021年2月12日 下午5:09:12
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
public class _113_路径总和II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	List<List<Integer>> list = new LinkedList<List<Integer>>();
	Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		if(root == null) {
			return list;
		}
		
		Queue<TreeNode> queNode = new LinkedList<TreeNode>();
		Queue<Integer> queVal = new LinkedList<Integer>();
		queNode.offer(root);
		queVal.offer(root.val);
		
		while(!queNode.isEmpty()) {
			TreeNode now = queNode.poll();
			int temp = queVal.poll();
			
			if(now.left == null && now.right == null) {
				if(temp == targetSum) {
					getPath(now);
				}
				
				continue;
			}
			
			if(now.left != null) {
				
			}
			
		}
    }

}


//方法二：广度优先搜索
//思路及算法
//
//我们也可以采用广度优先搜索的方式，遍历这棵树。当我们遍历到叶子节点，且此时路径和恰为目标和时，我们就找到了一条满足条件的路径。
//
//为了节省空间，我们使用哈希表记录树中的每一个节点的父节点。每次找到一个满足条件的节点，我们就从该节点出发不断向父节点迭代，即可还原出从根节点到当前节点的路径。
//
//代码
//
//C++JavaPython3GolangC
//
//class Solution {
//    List<List<Integer>> ret = new LinkedList<List<Integer>>();
//    Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
//
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return ret;
//        }
//
//        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
//        Queue<Integer> queueSum = new LinkedList<Integer>();
//        queueNode.offer(root);
//        queueSum.offer(0);
//
//        while (!queueNode.isEmpty()) {
//            TreeNode node = queueNode.poll();
//            int rec = queueSum.poll() + node.val;
//
//            if (node.left == null && node.right == null) {
//                if (rec == sum) {
//                    getPath(node);
//                }
//            } else {
//                if (node.left != null) {
//                    map.put(node.left, node);
//                    queueNode.offer(node.left);
//                    queueSum.offer(rec);
//                }
//                if (node.right != null) {
//                    map.put(node.right, node);
//                    queueNode.offer(node.right);
//                    queueSum.offer(rec);
//                }
//            }
//        }
//
//        return ret;
//    }
//
//    public void getPath(TreeNode node) {
//        List<Integer> temp = new LinkedList<Integer>();
//        while (node != null) {
//            temp.add(node.val);
//            node = map.get(node);
//        }
//        Collections.reverse(temp);
//        ret.add(new LinkedList<Integer>(temp));
//    }
//}
//
//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/path-sum-ii/solution/lu-jing-zong-he-ii-by-leetcode-solution/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


