public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int end = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        for(; i >= 0 && j >= 0; end--){
            if(A[i] > B[j]){
                A[end] = A[i];
                i--;
            }
            else{
                A[end] = B[j];
                j--;
            }
        }
        for(; j >= 0; end--)
            A[end] = B[j--];

    }
}