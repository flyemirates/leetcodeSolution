public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        //check row
        for(int i = 0; i < board.length; i++){
        	char[] cur = board[i];
        	HashSet<Character> hs = new HashSet<Character>();
        	for(int j = 0; j < cur.length; j++){
        		if(cur[j] == '.')
        			continue;
        		if(hs.contains(cur[j]))
        			return false;
        		else
        			hs.add(cur[j]);
        	}
        }

        //check col
        for(int i = 0; i < board[0].length; i++){
        	HashSet<Character> hs = new HashSet<Character>();
        	for(int j = 0; j < board.length; j++){
        		if(board[j][i] == '.')
        			continue;
        		if(hs.contains(board[j][i]))
        			return false;
        		else
        			hs.add(board[j][i]);
        	}
        }

        //check nine smaller cube
        for(int i = 0; i < board[0].length; i = i + 3){
        	for(int j = 0; j < board.length; j = j + 3){
        		HashSet<Character> hs = new HashSet<Character>();
        		for(int start = i; start < i + 3; start++){
        			for(int end = j; end < j + 3; end++){
        				if(board[start][end] == '.')
        					continue;
        				if(hs.contains(board[start][end]))
        					return false;
        				else
        					hs.add(board[start][end]);
        			}
        		}
        	}
        }
        return true;
    }
}