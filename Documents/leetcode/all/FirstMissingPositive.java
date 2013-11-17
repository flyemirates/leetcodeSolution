
// in-place swap 


public class Solution {
  public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i = 0; i < A.length; i++){
            if(A[i] <= 0)
                continue;
            if(A[i] > A.length){
                A[i] = -1;
                continue;
            }
            if(A[i] > 0 && A[i] != A[A[i] - 1]){
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
                i--;                 // remember to self deduce!!!
            }
        }
        for(int i = 0; i < A.length; i++){
            if(A[i] != i + 1)
                return i + 1;
        }
        return A.length + 1;
    }
}