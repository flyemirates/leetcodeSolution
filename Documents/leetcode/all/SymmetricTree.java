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
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return true;
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode one, TreeNode two){
        if(one == null && two == null)
            return true;
        if(one == null || two == null)
            return false;
        if(one.val != two.val)
            return false;
        boolean center = helper(one.right, two.left);
        if(!center)
            return false;
        return helper(one.left, two.right);
    }
}