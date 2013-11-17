public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < candidates.length; i++)
            helper(candidates, i, target, new ArrayList<Integer>(), result);
        return result;
    }
    public void helper(int[] candidates, int pos, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res){
        temp.add(candidates[pos]);
        int sum_temp = sum(temp);
        if(sum_temp > target)
            return;
        if(sum_temp == target){
            res.add(temp);
            return;
        }
        for(int i = pos; i < candidates.length; i++){
            ArrayList<Integer> copy = (ArrayList<Integer>) temp.clone();
            helper(candidates, i, target, copy, res);
        }
    }
    public int sum(ArrayList<Integer> t){
        int total = 0;
        for(int i = 0; i < t.size(); i++)
            total = total + t.get(i);
        return total;
    }
}