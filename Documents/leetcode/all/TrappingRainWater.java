public class Solution {
    public int trap(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A.length < 3)
            return 0;
        int[] left = new int[A.length];
        left[0] = A[0];
        for(int i = 1; i < left.length; i++){
        	if(A[i] > left[i - 1])
        		left[i] = A[i];
        	else
        		left[i] = left[i - 1];
        }

        int[] right = new int[A.length];
        right[right.length - 1] = A[A.length - 1];
        for(int i = right.length - 2; i >= 0; i--){
        	if(A[i] > right[i + 1])
        		right[i] = A[i];
        	else
        		right[i] = right[i + 1];
        }

        int result = 0;
        for(int i = 0; i < A.length; i++){
        	int smaller = Math.min(left[i], right[i]);
        	result = result + (smaller - A[i]);
        }
        return result;
    }
}