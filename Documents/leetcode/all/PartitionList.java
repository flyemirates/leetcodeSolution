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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode smallstart = null;
        ListNode bigstart = null;
        if(head == null)
            return head;
        ListNode temp = head;
        ListNode small = null;
        ListNode big = null;
        if(head.val < x){
            smallstart = head;
            while(temp.val < x){
                small = temp;
                temp = temp.next;
                if(temp == null)
                    return head;
            }
            bigstart = temp;
            big = bigstart;
        }
        else{
            bigstart = head;
            while(temp.val >= x){
                big = temp;
                temp = temp.next;
                if(temp == null)
                    return head;
            }
            smallstart = temp;
            small = smallstart;
        }
        
        while(temp.next != null){
            temp = temp.next;
            if(temp.val < x){
                small.next = temp;
                small = small.next;
            }
            else{
                big.next = temp;
                big = big.next;
            }
        }
        small.next = bigstart;
        big.next = null;      // or, we may get infinite loop....
        return smallstart;

    }
}





public class Solution {
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<ListNode> small = new LinkedList<ListNode>();
        LinkedList<ListNode> big = new LinkedList<ListNode>();
        if(head == null || head.next == null)
            return head;
        ListNode temp = head;
        for(; temp != null; temp = temp.next){
            if(temp.val < x)
                small.add(temp);
            else
                big.add(temp);
        }
        ListNode result = null;
        temp = null;
        if(small.size() != 0){
            result = small.poll();
            temp = result;
            while(!small.isEmpty())
            {
                temp.next = small.poll();
                temp = temp.next;
            }
        }
        if(temp == null){
            result = big.poll();
            temp = result;
        }
        while(!big.isEmpty()){
                temp.next = big.poll();
                temp = temp.next;
            }
            temp.next = null;    // or you get infinite loop...
        return result;
    }
}