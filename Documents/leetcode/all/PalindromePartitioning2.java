public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() < 2)
            return 0;
        Stack<Character> sc = new Stack<Character>();
        Stack<Integer> si = new Stack<Integer>();
        si.push(s.length() - 1);
        helper(s, sc, 0, si);
        return si.pop();
    }
    public void helper(String s, Stack<Character> sc, int cur, Stack<Integer> min){
        if(s.length() == 0 && sc.empty()){
            int top = min.peek();
            if(cur - 1 < top)
                min.push(cur - 1);
            return;
        }
        if(s.length() == 0)
            return;
        if(s.length() == 1 && sc.empty()){
            int top = min.peek();
            if(cur < top)
                min.push(cur);
            return;
        }
        if(s.length() == 1)
            return;
        Stack<Character> palin = new Stack<Character>();
        palin.push(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            if(palin.peek() == s.charAt(i)){
                Stack<Character> copy = (Stack<Character>) palin.clone();
                copy.add(s.charAt(i));
                helper(s.substring(i + 1), copy, cur, min);
                palin.pop();
            }
            else
                palin.push(s.charAt(i));

            if(palin.empty()){
                helper(s.substring(i + 1), new Stack<Character>(), cur + 1, min);
            }
        }
        
    }

}