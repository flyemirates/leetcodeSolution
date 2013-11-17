public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if((A.length + B.length) % 2 == 1){
            int k = (A.length + B.length) / 2 + 1;
            return (double)findK(A, B, 0, A.length, 0, B.length, k);
        }
        int k = (A.length + B.length) / 2;
        int lower = findK(A, B, 0, A.length, 0, B.length, k);
        int upper = findK(A, B, 0, A.length, 0, B.length, k + 1);
        return (double) (lower + upper) / 2;
    }
    public int findK(int[] A, int[] B, int aoff, int aleft, int boff, int bleft, int k){
        if(aleft > bleft)
            return findK(B, A, boff, bleft, aoff, aleft, k);
        if(aleft == 0)
            return B[boff + k - 1];
        if(k == 1)
            return Math.min(A[aoff], B[boff]);
        int ap = Math.min(k / 2, aleft);
        int bp = k - ap;
        if(A[aoff + ap - 1] > B[boff + bp - 1])
            return findK(A, B, aoff, aleft, boff + bp, bleft - bp, k - bp);
        return findK(A, B, aoff + ap, aleft - ap, boff, bleft, k - ap);
    }
}