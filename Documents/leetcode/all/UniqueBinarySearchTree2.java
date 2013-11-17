/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    ArrayList<TreeNode> res;
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        res = new ArrayList<TreeNode>();
        if(n == 0){
            res.add(null);
            return res;
        }
        int[] buf = new int[n + 1];
        for(int i = 1; i < buf.length; i++)
            buf[i] = i;
        res = helper(buf, 1, buf.length - 1);
        return res;
    }
    public ArrayList<TreeNode> helper(int[] buf, int start, int end){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end)
            return null;
        if(start == end){
            result.add(new TreeNode(buf[start]));
            return result;
        }
        if(start + 1 == end){
            TreeNode one = new TreeNode(buf[start]);
            one.right = new TreeNode(buf[end]);
            result.add(one);
            TreeNode two = new TreeNode(buf[end]);
            two.left = new TreeNode(buf[start]);
            result.add(two);
            return result;
        }
        
        for(int i = start; i <= end; i++){
            ArrayList<TreeNode> leftchild = helper(buf, start, i - 1);
            ArrayList<TreeNode> rightchild = helper(buf, i + 1, end);
            if(leftchild == null){
                for(int j = 0; j < rightchild.size(); j++)
                {
                    TreeNode root = new TreeNode(buf[i]);
                    root.right = rightchild.get(j);
                    result.add(root);
                }
            }
            if(rightchild == null){
                for(int j = 0; j < leftchild.size(); j++){
                    TreeNode root = new TreeNode(buf[i]);
                    root.left = leftchild.get(j);
                    result.add(root);
                }
            }
            if(leftchild != null && rightchild != null){
                for(int k = 0; k < leftchild.size(); k++){
                    for(int j = 0; j < rightchild.size(); j++){
                        TreeNode root = new TreeNode(buf[i]);
                        root.left = leftchild.get(k);
                        root.right = rightchild.get(j);
                        result.add(root);
                    }
                }
            
            }
        }
        return result;
    }
}