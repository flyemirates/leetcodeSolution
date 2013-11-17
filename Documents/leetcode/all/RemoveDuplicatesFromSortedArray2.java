
public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length < 2)
            return A.length;
        int start = 0;
        int end = A.length - 1;
        for(int i = start + 1; i <= end; i++){
            if(A[i] != A[start]){
                int distance = 2;
                if(i == start + 1){
                    start++;
                    continue;
                }
                for(int j = i; j <= end; j++)
                    A[start + distance + j - i] = A[j];
                end = end - (i - start - distance);
                i = start + distance;
                start = start + distance;
            }
        }
        if(start == end)
            return  start + 1;
        else
            return start + 2;
    }
}