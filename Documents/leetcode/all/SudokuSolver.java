public class Solution {
   
	
	ArrayList<HashSet<Character>> rows;
    ArrayList<HashSet<Character>> cols;
    ArrayList<HashSet<Character>> smalls;
    public void solveSudoku(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        rows = new ArrayList<HashSet<Character>>();
        cols = new ArrayList<HashSet<Character>>();
        smalls = new ArrayList<HashSet<Character>>();
       
        
        for(int i = 0; i < 9; i++){
            rows.add(new HashSet<Character>());
            cols.add(new HashSet<Character>());
            smalls.add(new HashSet<Character>());
        }
        for(int j = 0; j < 9; j++){
        for(int i = 0; i < 9; i++){
        	
        	if(board[j][i] != '.'){
        		rows.get(j).add(board[j][i]);
        		smalls.get(j/3*3 + i/3).add(board[j][i]);
        	}
        	if(board[i][j] != '.')
        		cols.get(j).add(board[i][j]);
        	
        }}
        helper(board, 0, 0);
        
    }
    public boolean helper(char[][] board, int row, int col){
        
        if(col == 9){
            col = 0;
            row = row + 1;
        }
        if(row == 9)
            return true;
        if(board[row][col] >= '1' && board[row][col] <= '9')
        {
            rows.get(row).add(board[row][col]);    
            cols.get(col).add(board[row][col]);
            smalls.get(row / 3 * 3 + col / 3).add(board[row][col]);
            return helper(board, row, col + 1);
        }
        HashSet<Character> possi = possible(row, col);
        for(char c : possi){
        	board[row][col] = c;
            rows.get(row).add(c);    
            cols.get(col).add(c);
            smalls.get(row / 3 * 3 + col / 3).add(c);
            boolean next = helper(board, row, col + 1);
            if(next)
                return true;
            else{
                rows.get(row).remove(c);    
                cols.get(col).remove(c);
                smalls.get(row / 3 * 3 + col / 3).remove(c);
                board[row][col] = '.';
            }
        }
        return false;
    }
    public HashSet<Character> possible(int row, int col){
        HashSet<Character> result = new HashSet<Character>();
        int little = row / 3 * 3 + col / 3;
        for(char i = '1'; i <= '9'; i++){
            if(!cols.get(col).contains(i) && !smalls.get(little).contains(i) && !rows.get(row).contains(i))
            {
                result.add(i);
            }
        }
        return result;
    }
    
}