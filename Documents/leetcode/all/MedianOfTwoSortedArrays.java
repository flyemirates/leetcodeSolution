public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 0)
            return B[(B.length - 1) / 2];
        if(B.length == 0)
            return A[(A.length - 1) / 2];
        return helper(A, B, 0, A.length - 1, 0, B.length - 1, );
    }
    public double helper(int[] A, int[] B, int starta, int enda, int startb, int endb, int k){

    }
}