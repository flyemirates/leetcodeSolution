public class Solution {
    Stack<Integer> result;
    public int totalNQueens(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // result = new Stack<Integer>();
        // result.push(0);
        result = new Stack<Integer>();
        result.push(0);
        helper(n, 0, 0, 0);
        
        return result.peek();
    }
    
    public void helper(int n, int row, int left, int right){
        int upper = (1 << n) - 1;
        int pos = upper & (~ (row | left | right));
        if(row != upper){
        while(pos != 0){
            int p = pos & (-pos);
            pos = pos - p;
            helper(n, row + p, (left + p) << 1, (right + p) >> 1);
        }}
        else
            result.push(result.peek() + 1);
    }
}