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
    ArrayList<Integer> result;
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        result = new ArrayList<Integer>();
        helper(root);
        return result;
        
    }
    public void helper(TreeNode root){
        if(root == null)
            return;
        result.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}