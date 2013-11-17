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
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        int temp = 0;
        helper(root, temp, result);
        int sum = 0;
        for(int i = 0; i < result.size(); i++){
            sum = sum + result.get(i);
        }
        return sum;
    }
    public void helper(TreeNode root, int temp, ArrayList<Integer> res){
        temp = temp * 10 + root.val;
        if(root.left == null && root.right == null){
            res.add(temp);
            return;
        }
        
        if(root.left != null)
            helper(root.left, temp, res);
        if(root.right != null)
            helper(root.right, temp, res);
    }
}


public class Solution {
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return 0;
        return helper(root, 0);
    }
    public int helper(TreeNode root, int upper){
        if(root == null)
            return upper;
        int current = upper * 10 + root.val;
        int left = 0;
        if(root.left != null)
            left = helper(root.left, current);

        int right = 0;
        if(root.right != null)
            right = helper(root.right, current);
        if(left + right == 0)
            return current;
        return left + right;
    }
}