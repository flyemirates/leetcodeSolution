public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] buf = new int[m][n];
       
        buf[m - 1][n - 1] = 1;
        
        int result = helper(0, 0, buf);
        return result;
    }
    public int helper(int m, int n, int[][] buf){
        if(m == buf.length || n == buf[0].length)
            return 0;
        if(buf[m][n] > 0)
            return buf[m][n];
        int right = helper(m, n + 1, buf);
        int down = helper(m + 1, n, buf);
        int cur = right + down;
        buf[m][n] = cur;
        return cur;
    }
}


// non-recursion    T: O(m * n)   Space: O(m * n)
public class Solution {
    public int uniquePaths(int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[][] buf = new int[m][n];
        //right line
        for(int i = 0; i < m; i++)
            buf[i][n - 1] = 1;
        //bottom line
        for(int j = 0; j < n; j++)
            buf[m - 1][j] = 1;

        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                buf[i][j] = buf[i][j + 1] + buf[i + 1][j];
            }
        }
        return buf[0][0];
    }
}