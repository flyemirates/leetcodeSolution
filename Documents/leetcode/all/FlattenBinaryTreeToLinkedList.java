/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//one place to remember


public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return;
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        helper(root, result);
        TreeNode temp = root;
        for(int i = 1; i < result.size(); i++){
            temp.right = result.get(i);
            temp = temp.right;
        }
    }
    public void helper(TreeNode root, ArrayList<TreeNode> res){
        if(root == null)
            return;
        res.add(root);
        helper(root.left, res);
        root.left = null;                 //Pay attention to this step!!! you need
                                        // to delete the left child!!!!
        helper(root.right, res);
    }
}