public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int maxi = Integer.MIN_VALUE;
        int temp = 0;
        for(int i = 0; i < A.length; i++){
            temp += A[i];
            maxi = Math.max(maxi, temp);
            if(temp < 0){
                temp = 0;
                continue;
            }
        }
        return maxi;
    }
}