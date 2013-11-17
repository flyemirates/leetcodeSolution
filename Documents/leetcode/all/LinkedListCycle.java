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
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null || head.next == null)
            return false;
        ListNode slow = head.next;
        ListNode fast = slow.next;
        while(fast != null){
            if(slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next;
            if(fast == null)
                return false;
            fast = fast.next;
        }
        return false;
    }
}