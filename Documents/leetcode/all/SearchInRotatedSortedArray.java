// the place with *, you need >= , instead of >.
// or you fail.
// no need to consider pure binary search, you may get it
// in sub problems

public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 0)
            return -1;
        int res = helper(A, 0, A.length - 1, target);
        return res;
    }
    public int helper(int[] arr, int start, int end, int target){
        if(start > end)
            return -1;
        int mid = (start + end) / 2;
        if(arr[mid] == target)
            return mid;
        if(arr[mid] >= arr[start]){
            if(arr[mid] > target){
                if(target >= arr[start])
                    return helper(arr, start, mid - 1, target);
                else
                    return helper(arr, mid + 1, end, target);
            }
            else
                return helper(arr, mid + 1, end, target);
        }
        else{
            if(arr[mid] > target)
                return helper(arr, start, mid - 1, target);
            else{
                if(target <= arr[end])
                    return helper(arr, mid + 1, end, target);
                else
                    return helper(arr, start, mid - 1, target);
            }
        }
    }
}