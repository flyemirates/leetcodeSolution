public class Solution {
     public int removeElement(int[] A, int elem) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int last = A.length - 1;
        for(int i = 0; i <= last; i++){
            if(A[i] == elem){
                int temp = A[last];
                A[last] = A[i];
                A[i] = temp;
                i--;
                last--;
            }
        }
        return last + 1;
    }
}