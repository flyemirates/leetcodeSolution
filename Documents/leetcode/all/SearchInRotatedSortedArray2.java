public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 0)
             return false;
         return helper(A, 0, A.length - 1, target);
    }
    public boolean helper(int[] arr, int start, int end, int target){
        if(start > end)
            return false;
        int mid = (start + end) / 2;
        if(arr[mid] == target)
            return true;
        if(arr[start] < arr[end]){
            if(target < arr[mid])
                return helper(arr, start, mid - 1, target);
            return helper(arr, mid + 1, end, target);
        }
        if(arr[mid] == arr[start])// duplicates happens here~~
            return helper(arr, start, mid - 1, target) || helper(arr, mid + 1, end, target);
        if(arr[mid] > arr[start]){
            if(target < arr[mid]){
                if(target >= arr[start])
                    return helper(arr, start, mid - 1, target);
                return helper(arr, mid + 1, end, target);
            }
            return helper(arr, mid + 1, end, target);
        }
        else{
            if(target < arr[mid]){
                return helper(arr, start, mid - 1, target);
            }
            else{
                if(target <= arr[end])
                    return helper(arr, mid + 1, end, target);
                return helper(arr, start, mid - 1, target);
            }
        }
        
    }
}