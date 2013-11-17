

// Constant Space!!! No recursion!!!

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return;
        TreeLinkNode upper = root;
        TreeLinkNode cur = null, start = null;
        while(upper != null){
            while(upper != null && upper.left == null && upper.right == null)
                upper = upper.next;
            if(upper == null)
                return;
            cur = (upper.left == null) ? upper.right : upper.left;
            start = cur;
            if(cur == upper.left && upper.right != null){
                cur.next = upper.right;
                cur = cur.next;
            }
            upper = upper.next;
            while(upper != null){
                if(upper.left == null && upper.right == null){
                    upper = upper.next;
                    continue;
                }
                cur.next = (upper.left == null) ? upper.right : upper.left;
                cur = cur.next;
                if(cur == upper.left && upper.right != null){
                    cur.next = upper.right;
                    cur = cur.next;
                }
                upper = upper.next;
            }
            cur.next = null;
            upper = start;
        }
    }
    
}