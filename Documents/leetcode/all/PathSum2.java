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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<ArrayList<Integer>>();
        helper(root, new ArrayList<Integer>(), sum);
        return result;
    }
    public void helper(TreeNode root, ArrayList<Integer> temp, int sum){
        if(root == null)
            return;
        if(root.val == sum && root.left == null && root.right == null){
            temp.add(root.val);
            result.add(temp);
            return;
        }
        ArrayList<Integer> forleft = (ArrayList<Integer>) temp.clone();
        forleft.add(root.val);
        helper(root.left, forleft, sum - root.val);

        ArrayList<Integer> forright = (ArrayList<Integer>) temp.clone();
        forright.add(root.val);
        helper(root.right, forright, sum - root.val);
    }
}