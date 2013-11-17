public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length < 2)
        	return;
        int row = matrix.length;
        for(int i = 0; i < row / 2; i++){
        	for(int j = i; j < row - i - 1; j++){
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[row - j - 1][i];
        		matrix[row - j - 1][i] = matrix[row - i - 1][row - j - 1];
        		matrix[row - i - 1][row - j - 1] = matrix[j][row - i - 1];
        		matrix[j][row - i - 1] = temp;
        	}
        }
    }
}