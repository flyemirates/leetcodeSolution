// just like in-order traversal.
// compare if prev is larger than cur.
// set prev global var, then, add prev and add cur;
// don't need to change order of prev and cur;



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
    ArrayList<TreeNode> result;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<TreeNode>();
        prev = null;
        helper(root);
        TreeNode first = result.get(0);
        TreeNode last = result.get(result.size() - 1);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    
    public void helper(TreeNode cur){
        if(cur == null)
        	return;
    	
    	helper(cur.left);
    	if(prev != null){
    		if(cur.val < prev.val){
    			
    				result.add(prev);
    				result.add(cur);
    			
    		}}
    	prev = cur;
    	helper(cur.right);
    }
}