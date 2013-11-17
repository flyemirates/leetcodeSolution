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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
            return head;
        if(k == 1)
            return head;
        ListNode start = head;
        ListNode last = head;
        for(int i = 1; i < k; i++){
            if(last.next != null)
                last = last.next;
            else
                return head;
        }
        ListNode next_head = last.next;
        ListNode loop = start.next;
        start.next = reverseKGroup(next_head, k);
        ListNode temp = loop.next;
        loop.next = start;
        while(loop != last){                  // this part is to reverse the list
            ListNode third = temp.next;
            temp.next = loop;
            loop = temp;
            temp = third;
        }
        
        return last;
    }
}