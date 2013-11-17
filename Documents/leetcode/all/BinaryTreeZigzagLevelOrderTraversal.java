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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
         ArrayList<TreeNode> first = new ArrayList<TreeNode>();
         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
     	if(root == null)
            return result;
         first.add(root);
         helper(first, 0, result);   
     	return result;
    }
    public void helper(ArrayList<TreeNode> altn, int level, ArrayList<ArrayList<Integer>> res){
    	if(altn.size() == 0)
    		return;						// draw a 4 level tree would make it clear to see!!
    	ArrayList<Integer> temp = new ArrayList<Integer>();
    	ArrayList<TreeNode> nextlevel = new ArrayList<TreeNode>();
    	if(level % 2 == 0){    // even level, read from left to right, we always put in TreeNode
    		                   // and read from the last one
    		for(int i = altn.size() - 1; i >= 0; i--){
    			TreeNode cur = altn.get(i);
    			temp.add(cur.val);
    			
    			if(cur.left != null)
    				nextlevel.add(cur.left);
    			if(cur.right != null)
    				nextlevel.add(cur.right);
    		}
    		res.add(temp);
    		helper(nextlevel, level + 1, res);
    	}
    	else{     // odd level, read from right to left
    		for(int i = altn.size() - 1; i >= 0; i--){
    			TreeNode cur = altn.get(i);
    			temp.add(cur.val);
    			
    			if(cur.right != null)
    				nextlevel.add(cur.right);
    			if(cur.left != null)
    				nextlevel.add(cur.left);

    		}
    		res.add(temp);
    		helper(nextlevel, level + 1, res);
    	}
    }
}