public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int row = board.length;
        int col = board[0].length;
        if(row == 0 | col == 0)
            return false;
        
        boolean result = false;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                result = helper(board, i, j, word, new int[row][col]);
                if(result)
                    return true;
            }
        }
        return false;
    }
    public boolean helper(char[][] board, int row, int col, String word, int[][] visited){
        if(word.length() == 0)
            return true;
        if(row < 0 | row >= board.length) 
                return false;
        if(col < 0 | col >= board[row].length)
                return false;
        if(visited[row][col] == 1)
            return false;
        if(board[row][col] != word.charAt(0))
            return false;
        else{
            visited[row][col] = 1;
            boolean result = false;
            result = result | helper(board, row + 1, col, word.substring(1), visited);
            if(result)
            return true;
            result = result | helper(board, row, col + 1, word.substring(1), visited);
                        if(result)
            return true;
            result = result | helper(board, row - 1, col, word.substring(1), visited);
                        if(result)
            return true;
            result = result | helper(board, row, col - 1, word.substring(1), visited);
            
            return result;
        }
    }
}