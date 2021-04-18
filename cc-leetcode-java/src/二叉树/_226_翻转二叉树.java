package 二叉树;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * @date   2021年2月6日 上午11:02:07
 * @author cc
 *
 */
public class _226_翻转二叉树 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }

}
