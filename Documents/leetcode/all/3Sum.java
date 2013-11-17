// the following might be the best solution
// sort, then go from both sides towards center.


public class Solution {
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3)
            return result;
        Arrays.sort(num);
        for(int i = 0; i < num.length && num[i] <= 0; i++){
            if(i > 0 && num[i] == num[i - 1])
                continue;
            helper(num, i + 1, num.length - 1, 0 - num[i]);
        }
        return result;
    }
    public void helper(int[] num, int start, int end, int tgt){
        if(start >= end)
            return;
        while(start < end){
            if(num[start] + num[end] == tgt){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(0 - tgt);
                temp.add(num[start]);
                temp.add(num[end]);
                result.add(temp);
                start++;
                while(start < num.length && num[start] == num[start - 1])
                    start++;
                end--;
                while(end >= 0 && num[end] == num[end + 1])
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