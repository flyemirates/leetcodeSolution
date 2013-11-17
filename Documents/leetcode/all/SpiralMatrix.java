// use directions to go along;


public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        int row = matrix.length;
        if(row == 0)
        	return result;
        int col = matrix[0].length;
        if(col == 0)
        	return result;
        int left = 0, top = 0;
        int direction = 1;
        int x = 0, y = 0;
        while(left < col && top < row){
        	direction = direction % 4;
        	switch(direction){
        		case 1:
        			for(; x < col; x++)
        				result.add(matrix[y][x]);
        			x--;                          // don't forget to drag it back~~
        			y++;
        			direction++;
        			top++;
        			break;

        		case 2:
        			for(; y < row; y++)
        				result.add(matrix[y][x]);
        			y--;
        			x--;
        			direction++;
        			col--;
        			break;

        		case 3:
        			for(; x >= left; x--)
        				result.add(matrix[y][x]);
        			x++;
        			y--;
        			direction++;
        			row--;
        			break;
        		case 0:
        			for(; y >= top; y--)
        				result.add(matrix[y][x]);
        			y++;
        			x++;
        			direction++;
        			left++;

        	}
        }
        return result;
    }
}