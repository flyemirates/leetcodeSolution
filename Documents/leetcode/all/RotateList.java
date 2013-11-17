//if n is larger than the length of the list, then return rotateRight(head, n - i - 1);


public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0)
            return head;
        if(head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < n; i++){
            fast = fast.next;
            if(fast == null){
                return rotateRight(head, n - i - 1);  // this step!
            }
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode result = slow.next;
        slow.next = null;
        fast.next = head;
        return result;
    }
}