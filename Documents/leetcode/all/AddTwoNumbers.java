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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode root = helper(l1, l2, 0);
        return root;
    }
    public ListNode helper(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null){
            if(carry == 1)
                return new ListNode(1);
            return null;
        }
        if(l1 == null){
            if(carry == 0)
                return l2;
            int sum = l2.val + carry;
            carry = sum / 10;
            l2.val = sum % 10;
            l2.next = helper(l1, l2.next, carry);
            return l2;
        }
        if(l2 == null)
            return helper(l2, l1, carry);
        int sum = l1.val + l2.val + carry;
        l1.val = sum % 10;
        carry = sum / 10;
        l1.next = helper(l1.next, l2.next, carry);
        return l1;
    }
}