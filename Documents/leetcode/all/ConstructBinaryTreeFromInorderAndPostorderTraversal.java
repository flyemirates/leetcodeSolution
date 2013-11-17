/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// the last node in postorder is the root that divide inorder into left child and right
// the number of right children is (end - p + 1)



public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(inorder.length == 0)
            return null;
        return helper(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }
    public TreeNode helper(int[] in, int start, int end, int[] post, int cur){
    	if(start > end)
    		return null;
    	TreeNode root = new TreeNode(post[cur]);
    	int p = start;
    	while(in[p] != post[cur])
    		p++;
    	root.left = helper(in, start, p - 1, post, cur - (end - p + 1));
    	root.right = helper(in, p + 1, end, post, cur - 1);
        return root;
    }
}