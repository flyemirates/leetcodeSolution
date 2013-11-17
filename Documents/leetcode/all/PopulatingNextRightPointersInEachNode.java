/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */


// don't forget the last node ~~~


public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeLinkNode> buff = new ArrayList<TreeLinkNode>();
        if(root == null)
            return;
        buff.add(root);
        helper(buff);
    }
    public void helper(ArrayList<TreeLinkNode> buf){
        if(buf.size() == 0)
            return;
        ArrayList<TreeLinkNode> nextlevel = new ArrayList<TreeLinkNode>();
        int i = 0;
        for(; i < buf.size() - 1; i++){
            TreeLinkNode current = buf.get(i);
            current.next = buf.get(i + 1);
            if(current.left != null)
                nextlevel.add(current.left);
            if(current.right != null)
                nextlevel.add(current.right);
        }
        buf.get(i).next = null;
        if(buf.get(i).left != null)            //don't forget to add the children of 
                                                // the last node!!!!1
            nextlevel.add(buf.get(i).left);
        if(buf.get(i).right != null)
            nextlevel.add(buf.get(i).right);
        helper(nextlevel);
    }
}





// Constant space!!!


public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null)
            return;
        TreeLinkNode upper = root;
        upper.next = null;
        TreeLinkNode curr = upper.left;
        TreeLinkNode start = curr;
        while(upper != null && curr != null){
            while(upper != null){
                curr.next = upper.right;
                upper = upper.next;
                curr = curr.next;
                if(upper == null)
                    curr.next = null;
                else
                    curr.next = upper.left;
                curr = curr.next;
            }
            upper = start;
            start = upper.left;
            curr = upper.left;
        }
    }
    
}
