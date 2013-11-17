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
        if(head == null || head.next == null)
            return head;
        ListNode start = head;
        while(start.next != null){
            ListNode temp = start.next;
            if(temp.val != start.val)
                start = start.next;
            else{
                while(temp.val == start.val){
                    temp = temp.next;
                    if(temp == null){
                        start.next = null;
                        return head;           // return directly
                    }
                }
                start.next = temp;
                start = start.next;

            }
        }
        return head;
    }
}