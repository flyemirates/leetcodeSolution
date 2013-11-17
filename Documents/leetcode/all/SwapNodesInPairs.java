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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || head.next == null)
            return head;
        ListNode nextHead = head.next.next;
        ListNode second = head.next;
        head.next = swapPairs(nextHead); //***pay attention to the order of this and next step. you cannot reverse
        second.next = head;
        return second;
    }
}