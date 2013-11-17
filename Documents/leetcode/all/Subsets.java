public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(S.length == 0)
            return result;
        Arrays.sort(S);
        
        for(int i = 0; i <= S.length; i++)
            combine(S, 0, i, new ArrayList<Integer>(), result);
        return result;
    }
    public void combine(int[] arr, int cur, int k, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res){
        if(temp.size() == k){
            res.add(temp);
            return;
        }
        if(cur == arr.length)
            return;
        for(int i = cur; i < arr.length; i++){
            ArrayList<Integer> copy = (ArrayList<Integer>) temp.clone();
            copy.add(arr[i]);
            combine(arr, i + 1, k, copy, res);
        }

    }
    
}