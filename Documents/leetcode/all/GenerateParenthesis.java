public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        String temp = "";
        helper(n, 0, 0, temp, result);
        return result;
    }
    public void helper(int n, int left, int right, String temp, ArrayList<String> result){
        if(left == n && right == n){
            result.add(temp);
            return;
        }
        if(left > n || right > left)
            return;
        String plusleft = new String(temp + "(");
        helper(n, left + 1, right, plusleft, result);
        String plusright = new String(temp + ")");
        helper(n, left, right + 1, plusright, result);
    }
}