public class Solution {
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<ArrayList<Integer>>();
        helper(n, k, 1, new ArrayList<Integer>());
        return result;
    }
    public void helper(int n, int k, int pos, ArrayList<Integer> temp){
        if(k == 0){
            result.add(temp);
            return;
        }
        if(pos > n)
            return;
        for(int i = pos; i <= n; i++){
            ArrayList<Integer> copy = (ArrayList<Integer>) temp.clone();
            copy.add(i);
            helper(n, k - 1, i + 1, copy);
        }
    }
}