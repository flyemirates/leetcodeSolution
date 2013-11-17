// initial value for result[0] should be A.length;

public class Solution {
    int[] result;
    public int[] searchRange(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        result = new int[2];
        result[0] = A.length;
        result[1] = -1;
        helper(A, 0, A.length - 1, target);
        if(result[0] == A.length)
            result[0] = -1;
        return result;
    }
    public void helper(int[] arr, int start, int end, int target){
        if(start > end)
            return;
        int mid = (start + end) / 2;
        if(arr[mid] == target){
            replace(mid);
            helper(arr, mid + 1, end, target);
            helper(arr, start, mid - 1, target);
        }
        if(arr[mid] > target)
            helper(arr, start, mid - 1, target);
        else
            helper(arr, mid + 1, end, target);
        
    }
    public void replace(int a){
        if(a < result[0])
            result[0] = a;
        if(a > result[1])
            result[1] = a;
    }
}