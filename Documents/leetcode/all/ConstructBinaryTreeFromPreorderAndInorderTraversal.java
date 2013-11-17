/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */



// the first node in preorder is the root that divide inorder into left child tree and right.




public class Solution {    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(preorder.length == 0)
        	return null;
        return helper(preorder, 0, inorder, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] pre, int cur, int[] in, int start, int end){
    	if(start > end)
    		return null;
    	TreeNode root = new TreeNode(pre[cur]);

    	int p = start;
    	while(in[p] != pre[cur])
    		p++;
    	root.left = helper(pre, cur + 1, in, start, p - 1);
    	root.right = helper(pre, cur + (p - start + 1), in, p + 1, end); // move (p - start + 1) steps right
    	return root;
    }
}