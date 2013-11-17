public class Solution {
    public ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> first = new ArrayList<Integer>();
        result = new ArrayList<ArrayList<Integer>>();
        if(num.length == 0)
            return result;
        first.add(num[0]);
        result.add(first);
        helper(num, 1);
        return result;
    }
    public void helper(int[] num, int current){
        if(current == num.length)
            return;
        ArrayList<ArrayList<Integer>> next = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < result.size(); i++){
            ArrayList<Integer> cur = result.get(i);
            
            for(int j = 0; j <= cur.size(); j++){
                
                if(j != 0 && num[current] == cur.get(j - 1))
                    continue;
                ArrayList<Integer> copy = new ArrayList<Integer>();
                int p = 0;
                for(; p < j; p++)
                    copy.add(cur.get(p));
                copy.add(num[current]);
                for(; p < cur.size(); p++)
                    copy.add(cur.get(p));
                next.add(copy);
            }
        }
        result = next;
        helper(num, current + 1);
    }
}



// need to test
public class Solution {
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> first = new ArrayList<Integer>();
        if(num.length == 0)
            return result;
        Arrays.sort(num);
        first.add(num[0]);
        result.add(first);
        for(int i = 1; i < num.length; i++)
            helper(num[i]);
        return result;
    }
    public void helper(int val){
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < result.size(); i++){
            ArrayList<Integer> cur = result.get(i);
            for(int j = 0; j <= cur.size(); j++){
                if(j > 0 && val == cur.get(j - 1))
                    continue;
                ArrayList<Integer> insert = new ArrayList<Integer>();
                int p = 0;
                for(; p < j; p++)
                    insert.add(cur.get(p));
                insert.add(val);
                for(; p < cur.size(); p++)
                    insert.add(cur.get(p));
                temp.add(insert);
            }
        }
        result = temp;
    }
}