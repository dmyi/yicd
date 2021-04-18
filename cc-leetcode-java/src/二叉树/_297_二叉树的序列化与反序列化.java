package 二叉树;

import java.util.LinkedList;
import java.util.List;

public class _297_二叉树的序列化与反序列化 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class Codec {
		
		public void preOrder(TreeNode root, StringBuilder sb) {
			if(root == null) {
				sb.append("$,");
				return;
			}
			
			sb.append(root.val);
			sb.append(",");
			preOrder(root.left, sb);
			preOrder(root.right, sb);
		}

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	    	StringBuilder sb = new StringBuilder();
	    	preOrder(root, sb);
	    	
	    	return sb.toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	    	String[] strings = data.split(",");
	        List<String> list = new LinkedList<String>();
	        
	        for(int i = 0; i < strings.length; i++) {
	        	list.add(strings[i]);
	        }
	        return treeBuild(list);
	    }
	    
	    public TreeNode treeBuild(List<String> list) {
	    	String string = list.get(0);
	    	list.remove(0);
	    	
	    	if(!string.equals("$")) {
	    		TreeNode tn = new TreeNode(Integer.valueOf(string));
	    		tn.left = treeBuild(list);
	    		tn.right = treeBuild(list);
	    		return tn;
	    	} else {
	    		return null;
	    	}			
		}
	    
	    
	}

	// Your Codec object will be instantiated and called as such:
	// Codec ser = new Codec();
	// Codec deser = new Codec();
	// TreeNode ans = deser.deserialize(ser.serialize(root));

}
