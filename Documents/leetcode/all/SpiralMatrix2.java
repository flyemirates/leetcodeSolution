public class Solution {
    public int[][] generateMatrix(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[][] result = new int[n][n];
        if(n < 1)
            return result;
        int bottom = n;
        int right = n;
        int top = 0;
        int left = 0;
        int x = 0, y = 0;
        int count = 1;
        int direction = 0;    // 0: right, 1: down, 2: left, 3:up
        while(count <= n * n){
            direction = direction % 4;
            switch(direction){
                case 0:
                    for(;y < right; y++){
                        result[x][y] = count++;
                    }
                    y--;
                    x++;
                    top++;
                    break;
                case 1:
                    for(; x < bottom; x++)
                        result[x][y] = count++;
                    x--;
                    y--;
                    right--;
                    break;
                case 2:
                    for(; y >= left; y--)
                        result[x][y] = count++;
                    y++;
                    x--;
                    bottom--;
                    break;
                case 3:
                    for(; x >= top; x--)
                        result[x][y] = count++;
                    x++;
                    y++;
                    left++;
                    break;
            }
            direction++;
        }
        return result;
    }
}