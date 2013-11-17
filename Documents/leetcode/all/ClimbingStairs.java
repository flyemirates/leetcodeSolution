

public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 1 || n == 2)
            return n;
        int[] buf = new int[n + 1];
        buf[1] = 1;
        buf[2] = 2;
        for(int i = 3; i < n + 1; i++)
            buf[i] = buf[i - 1] + buf[i - 2];
        return buf[n];
    }
    
}