/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean helper(TreeNode root, int lower, int upper){
    	if(root == null)
    		return true;
        if(!(root.val < upper && root.val > lower))
        	return false;
        boolean leftchild = helper(root.left, lower, root.val);
        boolean rightchild = helper(root.right, root.val, upper);
        return leftchild && rightchild;
    }
}