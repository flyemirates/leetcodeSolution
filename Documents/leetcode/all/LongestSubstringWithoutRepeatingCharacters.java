import java.util.Hashtable;

// Hashtable has a 't', not 'T'
// you would better import Hashtable again manually
// use two pointers and hashtable.
// start over at the position + 1 where repeating char first appeared.


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() < 2)
            return s.length();
        Stack<Integer> max = new Stack<Integer>();
        Hashtable<Character, Integer> temp = new Hashtable<Character, Integer>();
        max.push(1);
        helper(s, 0, 0, temp, max);
        return max.pop();
    }
    public void helper(String s, int start, int pos, Hashtable<Character, Integer> temp, Stack<Integer> max){
        if(pos == s.length()){
            int num = pos - start;
            if(num > max.peek())
                max.push(num);
            return;
        }
        if(temp.containsKey(s.charAt(pos))){
            int num = pos - start;
            if(num > max.peek())
                max.push(num);
            int new_start = temp.get(s.charAt(pos));
            helper(s, new_start + 1, new_start + 1, new Hashtable<Character, Integer>(), max);
            return;
        }
        temp.put(s.charAt(pos), pos);
        helper(s, start, pos + 1, temp, max);
    }
}