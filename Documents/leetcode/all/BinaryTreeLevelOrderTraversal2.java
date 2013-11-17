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
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return result;
        ArrayList<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        Stack<ArrayList<Integer>> reverse = new Stack<ArrayList<Integer>>();
        while(!level.isEmpty()){
            ArrayList<Integer> cur = new ArrayList<Integer>();
            ArrayList<TreeNode> next_level = new ArrayList<TreeNode>();
            for(int i = 0; i < level.size(); i++){
                cur.add(level.get(i).val);
                if(level.get(i).left != null)
                    next_level.add(level.get(i).left);
                if(level.get(i).right != null)
                    next_level.add(level.get(i).right);
            }
            reverse.push(cur);
            level = next_level;
        }
        while(!reverse.empty())
            result.add(reverse.pop());
        return result;
    }
}