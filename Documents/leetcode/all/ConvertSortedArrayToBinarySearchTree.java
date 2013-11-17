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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length == 0)
            return null;
        return helper(num, 0, num.length - 1);
    }
    public TreeNode helper(int[] num, int start, int end){
        if(start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(num, start, mid - 1);
        root.right = helper(num, mid + 1, end);
        return root;
    }
}