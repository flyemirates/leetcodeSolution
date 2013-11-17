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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        if(head.val == head.next.val){
            ListNode temp = head;
            while(temp.val == head.val){
                temp = temp.next;
                if(temp == null)           //*** temp may get to null
                    return null;
            }
            return deleteDuplicates(temp);
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }
}