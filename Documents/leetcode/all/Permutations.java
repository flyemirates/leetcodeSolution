public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> start = new ArrayList<Integer>();
        if(num.length == 0)
            return result;
        start.add(num[0]);
        result.add(start);
        for(int i = 1; i < num.length; i++){
            helper(num[i], result);
        }
        return result;
    }
    public void helper(int a, ArrayList<ArrayList<Integer>> res){
        int len = res.size();
        for(int i = 0; i < len; i++){
            ArrayList<Integer> curr = res.get(i);
            for(int j = 0; j <= curr.size(); j++){
                ArrayList<Integer> clone = (ArrayList<Integer>) curr.clone(); //*pay attention to return value
                clone.add(j, a);
                res.add(clone);
            }
        }
        for(int i = 0; i < len; i++)
            res.remove(0);
        
    }
}