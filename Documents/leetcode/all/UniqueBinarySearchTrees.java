public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
       int[] buf = new int[n + 1];
       buf[0] = 1;
       for(int i = 1; i <= n; i++){
           int sum = 0;
           for(int start = 0, end = i - 1; end >= 0 && start < i; end--, start++)
            sum += buf[start] * buf[end];
            buf[i] = sum;
       }
       return buf[n];
    }
}


// time complexity is O(n2).
// time is 1 + 2 + 3 ... + n