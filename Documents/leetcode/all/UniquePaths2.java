public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] buf = new int[row][col];
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                buf[i][j] = -1;
        buf[row - 1][col - 1] = 1;
        int result = helper(obstacleGrid, 0, 0, buf);
        return result;

    }
    public int helper(int[][] obs, int m, int n, int[][] buf){
        if(m == obs.length || n == obs[0].length)
            return 0;
        if(obs[m][n] == 1){
            buf[m][n] = 0;
            return 0;
        }
        if(buf[m][n] >= 0)
            return buf[m][n];
        int right = helper(obs, m, n + 1, buf);
        int down = helper(obs, m + 1, n, buf);
        int cur = right + down;
        buf[m][n] = cur;
        return cur;
    }
}


// non recursion method
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] buf = new int[row][col];
        if(obstacleGrid[row - 1][col - 1] == 1)
            return 0;
        buf[row - 1][col - 1] = 1; 
        for(int i = row - 2; i >= 0; i--){
            if(obstacleGrid[i][col - 1] == 1 || buf[i + 1][col - 1] == 0)
                buf[i][col - 1] = 0;
            else
                buf[i][col - 1] = 1;
        }
        
        for(int j = col - 2; j >= 0; j--){
            if(obstacleGrid[row - 1][j] == 1 || buf[row - 1][j + 1] == 0)
                buf[row - 1][j] = 0;
            else
                buf[row - 1][j] = 1;
        }
        
        for(int i = row - 2; i >= 0; i--){
            for(int j = col - 2; j >= 0; j--){
                int right = buf[i][j + 1];    
                int down = buf[i + 1][j];
                if(obstacleGrid[i][j] == 1)
                    buf[i][j] = 0;
                else
                    buf[i][j] = right + down;
            }
        }
        return buf[0][0];
    }
}