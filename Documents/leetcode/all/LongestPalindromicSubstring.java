

// the palindrome can be odd or even.
// start = center - 1, end = center + 1; 
// or start = center - 1, end = center;


public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() < 2)
            return s;
        Stack<String> max = new Stack<String>();
        max.push(s.substring(0, 1));
        helper(s, 1, max);
        return max.pop();
    }
    public void helper(String s, int center, Stack<String> max){
        if(center == s.length())
            return;
        int cur = max.peek().length();
        int start = center - 1, end = center + 1;      // odd
        for(; start >= 0 && end < s.length(); start--, end++){
            if(s.charAt(start) == s.charAt(end)){
                int len = end - start + 1;
                if(len > max.peek().length())
                    max.push(s.substring(start, end + 1));
            }
            else{
                break;
            }
        }
        start = center - 1;
        end = center;                            //even
        for(; start >= 0 && end < s.length(); start--, end++){
            if(s.charAt(start) == s.charAt(end)){
                int len = end - start + 1;
                if(len > max.peek().length())
                    max.push(s.substring(start, end + 1));
            }
            else{
                break;
            }
        }
        helper(s, center + 1, max);
                

    }
    public boolean same(String s, int start, int end){
        char c = s.charAt(start);
        for(int i = start + 1; i <= end; i++){
            if(s.charAt(i) != c)
                return false;
        }
        return true;
    }
    public boolean check(String s, int start, int end){
        for(int i = start, j = end; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}