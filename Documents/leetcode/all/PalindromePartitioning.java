public class Solution {
    ArrayList<ArrayList<String>> result;
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<ArrayList<String>>();
        helper(s, 0, new ArrayList<String>());
        return result;
    }
    public void helper(String s, int start, ArrayList<String> temp){
        if(start == s.length()){
            result.add(temp);
            return;
        }
        for(int i = start + 1; i <= s.length(); i++){
            if(check(s, start, i)){
                ArrayList<String> copy = (ArrayList<String>) temp.clone();
                copy.add(s.substring(start, i));
                helper(s, i, copy);
            }
        }
    }
    public boolean check(String s, int start, int end){
        for(int i = start, j = end - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
   
}