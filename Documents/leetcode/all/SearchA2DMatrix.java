public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int row = matrix.length;
        if(row == 0)
            return false;
        int col = matrix[0].length;
        if(col == 0)
            return false;
        if(target < matrix[0][0] || target > matrix[row - 1][col - 1])
            return false;
        boolean result = binrow(matrix, 0, row - 1, target);
        return result;
    }
    public boolean binrow(int[][] matrix, int start, int end, int target){
        if(start > end)
            return false;
        if(start == end){
            return bincol(matrix[start], 0, matrix[start].length - 1, target);
        }
        int mid = (start + end) / 2 + 1;
        if(matrix[mid][0] <= target)
            return binrow(matrix, mid, end, target);
        return binrow(matrix, start, mid - 1, target);
    }
    public boolean bincol(int[] arr, int start, int end, int target){
        if(start > end)
            return false;
        int mid = (start + end) / 2;
        if(arr[mid] == target)
            return true;
        if(arr[mid] > target)
            return bincol(arr, start, mid - 1, target);
        return bincol(arr, mid + 1, end, target);
    }
}