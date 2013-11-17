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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)
        	return result;
        helper(root, result);
        return result;
    }
    public void helper(TreeNode root, ArrayList<Integer> res){
    	if(root == null)
    		return;
    	helper(root.left, res);
    	res.add(root.val);
    	helper(root.right, res);
    }
}