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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists.size() == 0)
            return null;
        ListNode root = least(lists);
        if(root == null)
            return root;

        ListNode curr = root;
        
        do{
            int index = lists.indexOf(curr);
            lists.set(index, curr.next);
            curr.next = least(lists);
            curr = curr.next;
            
        }while(curr != null);
        return root;
    }
    public ListNode least(ArrayList<ListNode> lists){
        ListNode temp = null;
        for(int i = 0; i < lists.size(); i++){
            if(lists.get(i) == null)
                continue;
            if(temp == null){
                temp = lists.get(i);
                continue;
            }
            if(temp.val > lists.get(i).val)
                temp = lists.get(i);
        }
        return temp;
    }

}