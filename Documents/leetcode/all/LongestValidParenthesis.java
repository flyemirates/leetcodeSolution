
public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        helper(s, result);
        return result[0];
    }
    public void helper(String str, int[] result){
        int whole = check(str);
        if(whole > 0 && result[0] < whole){
            result[0] = whole;
            return;
        }
        for(int i = 1; i < str.length(); i++){
            int left = check(str.substring(0, i));
            if(result[0] < left)
                result[0] = left;
            else
                helper(str.substring(0, i), result);
            int right = check(str.substring(i));
            if(result[0] < right)
                result[0] = right;
            else
                helper(str.substring(i), result);
        }
    }
    public int check(String str){
        Stack<Character> sc = new Stack<Character>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(')
                sc.push('(');
            else{
                if(sc.empty())
                    return -1;
                sc.pop();
            }
        }
        if(sc.empty())
            return str.length();
        return -1;
    }
}



//   O(n)    put in Integer

public class Solution {
    public int longestValidParentheses(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s.length() < 2)
            return 0;
        Stack<Integer> si = new Stack<Integer>();
        int longest = 0;
        int last = -1;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(')
                si.push(i);
            else{
                if(si.isEmpty())
                    last = i;
                else{
                    si.pop();
                    if(si.isEmpty())
                        longest = Math.max(longest, i - last);
                    else
                        longest = Math.max(longest, i - si.peek());
                }
            }
        }
        
        return longest;
    }
}



//   O(n)   using Stack


public class Solution {
    
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int result = 0;
        if(s.length() == 0)
            return result;
        Stack<Pair> sp = new Stack<Pair>();
        for(int i = 0; i < s.length(); i++){
            if(sp.isEmpty()){
                result = i;
                sp.push(new Pair(i, s.charAt(i)));
                continue;
            }
            if(sp.peek().c == '(' && s.charAt(i) == ')'){
                sp.pop();
                if(sp.isEmpty())
                    result = Math.max(result, i + 1);
                else{
                    result = Math.max(result, i - sp.peek().pos);
                }
            }
            else{
                int len = i - sp.peek().pos - 1;    
                result = Math.max(result, len);
                sp.push(new Pair(i, s.charAt(i)));}
        }
        return result;
    }
    
}
class Pair{
    int pos;
    char c;
    Pair(int p, char ch){
        this.pos = p;
        this.c = ch;
    }
}
