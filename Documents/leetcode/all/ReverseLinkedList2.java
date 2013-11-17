// based on inorder traversal, set a prev to point to the previous node
// check if cur < prev, then store them into result.
// always store prev first


public class Solution {
  ArrayList<TreeNode> result;
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<TreeNode>();
        helper(root);
        TreeNode first = result.get(0);
        TreeNode last = result.get(result.size() - 1);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    TreeNode prev = null;
    public void helper(TreeNode cur){
        if(cur == null)
    		return;
    	if(cur.left != null)
    		helper(cur.left);
    	if(prev != null){
    		if(cur.val < prev.val){
    				result.add(prev);     // always store prev first.
    				result.add(cur);
    		}
    	}
    	prev = cur;
    	if(cur.right != null)
    		helper(cur.right);
    }
}

// O(n)
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(m == n)
            return head;
        ListNode start = head;
        ListNode prev = null;
        for(int i = 1; i < m; i++){
            prev = start;
            start = start.next;
        }
        ListNode first = start;
        ListNode second = start.next;
        ListNode third = second.next;
        for(int i = m + 1; i <= n; i++){
            second.next = first;
            first = second;
            second = third;
            if(third != null)
                third = third.next;

        }
        start.next = second;
        if(prev == null)
            return first;
        prev.next = first;
        return head;
    }
}