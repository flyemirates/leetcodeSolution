public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0)
            return true;
        Stack<Character> sc = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(sc.empty()){
                sc.push(s.charAt(i));
                continue;
            }
            if(check(sc.peek(), s.charAt(i))){
                sc.pop();
            }
            else
                sc.push(s.charAt(i));
        }
        if(sc.empty())
            return true;
        return false;
    }
    public boolean check(char a, char b){
        return (a == '{' && b == '}') || (a == '[' && b == ']') || (a == '(' && b == ')');
    }
}