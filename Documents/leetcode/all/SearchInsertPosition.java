// pay attention to the Question, it is a sorted array!!! sorted!!!
// binary search~~


public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(A, target, 0, A.length - 1);
    }
    public int helper(int[] A, int target, int start, int end){
        if(start > end)
            return start;
        if(start == end){
            if(A[start] >= target)           // here is >= !!!
                return start;
            return start + 1;
        }
        int mid = (start + end) / 2;
        if(A[mid] == target)
            return mid;
        if(A[mid] > target)
            return helper(A, target, start, mid - 1);
        else
            return helper(A, target, mid + 1, end);
    }
}