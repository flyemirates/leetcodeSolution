public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int row = grid.length;
        int col = grid[0].length;
        if(row == 0 || col == 0)
        	return 0;
        int[][] buf = new int[row][col];
        for(int i = 0; i < row; i++)
        	for(int j = 0; j < col; j++)
        		buf[i][j] = -1;
        buf[row - 1][col - 1] = grid[row - 1][col - 1];
        int res = helper(grid, buf, 0, 0);
        return res;
    }
    public int helper(int[][] grid, int[][] buf, int x, int y){
    	if(x == grid.length || y == grid[0].length)
    		return -1;
    	if(buf[x][y] >= 0)
    		return buf[x][y];
    	int right = helper(grid, buf, x, y + 1);
    	int down = helper(grid, buf, x + 1, y);
    	if(right == -1){
    		buf[x][y] = down + grid[x][y];
    		return buf[x][y];
    	}
    	if(down == -1){
    		buf[x][y] = right + grid[x][y];
    		return buf[x][y];
    	}
    	int smaller = (right < down) ? right : down;
    	buf[x][y] = smaller + grid[x][y];
    	return buf[x][y];
 
    }
}


// time: O(row * col)    space : O(row * col)

public class Solution {
    public int minPathSum(int[][] grid) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int row = grid.length;
        int col = grid[0].length;
        int[][] buf = new int[row][col];
        buf[row - 1][col - 1] = grid[row - 1][col - 1];
        //bottom line
        for(int i = col - 2; i >= 0; i--)
            buf[row - 1][i] = buf[row - 1][i + 1] + grid[row - 1][i];
        //right line
        for(int j = row - 2; j >= 0; j--)
            buf[j][col - 1] = buf[j + 1][col - 1] + grid[j][col - 1];

        for(int i = row - 2; i >= 0 ; i--){
            for(int j = col - 2; j >= 0; j--){
                int right = buf[i][j + 1];
                int down = buf[i + 1][j];
                buf[i][j] = (right < down) ? (right + grid[i][j]) : (down + grid[i][j]);
            }
        }
        return buf[0][0];
    }
}