// use Stack instead of an integer field!!
// like int result = Integer.MAX_VALUE:
public class Solution {
    Stack<Integer> result;
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return 0;
        result = new Stack<Integer>();
        result.add(Integer.MAX_VALUE);
        helper(root, 1);
        return result.pop();
    }
    public void helper(TreeNode current, int level){
        if(current.left == null && current.right == null){
            if(result.peek() > level)
                result.push(level);
            return;
        }
        if(current.left != null)
            helper(current.left, level + 1);
        if(current.right != null)
            helper(current.right, level + 1);
    }
}


// better solution
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
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return 0;
        int rightchild = 0;
        if(root.right != null)
            rightchild = minDepth(root.right);
        else
            return minDepth(root.left) + 1;
        int leftchild = 0;
        if(root.left != null)
            leftchild = minDepth(root.left);
        else
            return rightchild + 1;
        return (leftchild < rightchild) ? ( 1 + leftchild) : (1 + rightchild);
    
    }
}