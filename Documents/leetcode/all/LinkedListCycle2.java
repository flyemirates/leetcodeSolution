/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null || head.next == null)
            return null;
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while(fast != null){
            if(fast == slow)
                break;
            slow = slow.next;
            fast = fast.next;
            if(fast == null)
                return null;
            fast = fast.next;
        }
        if(fast == null)
            return null;
        ListNode result = head;
        while(result != slow){
            result = result.next;
            slow = slow.next;
        }
        return result;
    }
}