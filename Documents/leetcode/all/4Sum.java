
// start from both sides towards center. two pointers.
// the same with 2 sum, 3 sum.

public class Solution {
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 4)
            return result;
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++){
            if(i > 0 && num[i] == num[i - 1])
                continue;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(num[i]);
            threeSum(num, target - num[i], i + 1, num.length - 1, temp);
        }
        return result;
    }
    public void threeSum(int[] num, int tgt, int start, int end, ArrayList<Integer> temp) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(end - start < 2)
            return;
        for(int i = start; i <= end; i++){
            if(i > start && num[i] == num[i - 1])
                continue;
            ArrayList<Integer> copy = (ArrayList<Integer>) temp.clone();
            copy.add(num[i]);
            helper(num, i + 1, end, tgt - num[i], copy);
        }
        
    }
    public void helper(int[] num, int start, int end, int tgt, ArrayList<Integer> temp){
        if(start >= end)
            return;
        while(start < end){
            if(num[start] + num[end] == tgt){
                ArrayList<Integer> copy = (ArrayList<Integer>) temp.clone();
                
                copy.add(num[start]);
                copy.add(num[end]);
                result.add(copy);
                start++;
                while(start < num.length && num[start] == num[start - 1])
                    start++;
                end--;
                while(end >= start && num[end] == num[end + 1])
                    end--;
                continue;
            }
            if(num[start] + num[end] < tgt)
                start++;
            else
                end--;
        }
    }
}
