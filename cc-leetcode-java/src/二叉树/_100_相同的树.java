package 二叉树;

/**
 * https://leetcode-cn.com/problems/same-tree/
 * @date   2020年11月5日 上午10:40:36
 * @author cc
 *
 */
public class _100_相同的树 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        
		if(p == null && q == null) {
			return true;
		} else if(p == null || q == null) {
			return false;
		} else if (p.val != q.val) {
			return false;
		} else {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
    }
}
