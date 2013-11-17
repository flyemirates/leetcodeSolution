/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
        	return null;
        ListNode start = head;
        ListNode end = head;
        while(end.next != null)
        	end = end.next;
        return helper(start, end);
    }
    public TreeNode helper(ListNode start, ListNode end){
    	if(end == null || end.next == start)
    		return null;
    	if(start.val == end.val)
    		return new TreeNode(start.val);
    	ListNode mid = start;
    	ListNode fast = start;
    	ListNode last = null;
    	while(fast.next != null && fast.next.next != null){ //find the middle TreeNode
    		if(fast.next == end)
    			break;
    		if(fast.next.next == end){
    			last = mid;
    			mid = mid.next;
    			break;
    		}
    		last = mid;
    		mid = mid.next;
    		fast = fast.next.next;
    	}
    	TreeNode root = new TreeNode(mid.val);
    	root.left = helper(start, last);
    	root.right = helper(mid.next, end);
    	return root;
    }
}



//version 2


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if(head.next == null)
            return root;
        ListNode prev = head;
        while(prev.next != slow)
            prev = prev.next;
        prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
