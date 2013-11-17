public class Solution {
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Arrays.sort(num);
        res = new ArrayList<ArrayList<Integer>>();
        
        for(int j = 0; j <= num.length; j++)
            helper(num, 0, j, new ArrayList<Integer>());
        
        return res;
    }
    public void helper(int[] num, int pos, int volum, ArrayList<Integer> temp){
        if(temp.size() == volum){
            res.add(temp);
            return;
        }
        if(pos == num.length)
            return;
        for(int i = pos; i < num.length; i++){
            if(i > pos && num[i] == num[i - 1])
                continue;
            ArrayList<Integer> copy = (ArrayList<Integer>) temp.clone();
            copy.add(num[i]);
            helper(num, i + 1, volum, copy);
        }
    }
}