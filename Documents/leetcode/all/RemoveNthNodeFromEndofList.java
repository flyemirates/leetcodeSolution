/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode last = head;
        for(int i = 0; i < n; i++){
            last = last.next; //先往后挪~~
            if(last == null)
        		return head.next;
        	
        }
        ListNode prev = head;
        while(last.next != null){
        	prev = prev.next;
        	last = last.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}