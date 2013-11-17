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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int res = helper(root);
        if(res == -1)
            return false;
        return true;
    }
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        int leftchild = helper(root.left);
        if(leftchild == -1)
            return -1;
        int rightchild = helper(root.right);
        if(rightchild == -1)
            return -1;
        if(Math.abs(leftchild - rightchild) > 1)
            return -1;
        return Math.max(leftchild, rightchild) + 1;
    }
}