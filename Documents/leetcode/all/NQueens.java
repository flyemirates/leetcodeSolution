public class Solution {
    ArrayList<String[]> result;

    public ArrayList<String[]> solveNQueens(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        result = new ArrayList<String[]>();
        
        if(n == 0)
            return result;
        int[] buf = new int[n];
        for(int i = 0; i < n; i++)
            buf[i] = -1;
        helper(buf, 0);
        return result;
    }
    public void helper(int[] arr, int cur){
        if(cur == arr.length){
            String[] r = trans(arr);
            result.add(r);
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(check(arr, cur, i)){
                int[] copy = (int[]) arr.clone();
                copy[cur] = i;
                helper(copy, cur + 1);
            }
        }
    }
    public String[] trans(int[] arr){
        String[] res = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            String temp = "";
            int p = 0;
            for(; p < i; p++)
                temp = temp + ".";
            temp = temp + "Q";
            p++;
            for(; p < arr.length; p++)
                temp = temp + ".";
            res[arr[i]] = temp;
        }
        return res;
    }
    public boolean check(int[] arr, int pos, int val){
        // row check
        for(int i = 0; i < pos; i++){
            if(arr[i] == val)
                return false;
        }

        // diag check
        for(int i = 0; i < pos; i++){
            if((pos - i) == Math.abs(val - arr[i]))
                return false;
        }
        return true;
    }
}