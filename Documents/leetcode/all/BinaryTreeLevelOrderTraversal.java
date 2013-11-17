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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return result;
        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        first.add(root.val);
        result.add(first);
        helper(nodes, result);
        return result;
    }
    public void helper(ArrayList<TreeNode> nodes, ArrayList<ArrayList<Integer>> result){
        if(nodes.size() == 0)
            return;
        ArrayList<TreeNode> nextlevel = new ArrayList<TreeNode>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i).left != null){
                nextlevel.add(nodes.get(i).left);
                temp.add(nodes.get(i).left.val);
            }
            if(nodes.get(i).right != null){
                nextlevel.add(nodes.get(i).right);
                temp.add(nodes.get(i).right.val);
            }
        }
        if(temp.size() == 0)
            return;
        result.add(temp);
        helper(nextlevel, result);
    }
}