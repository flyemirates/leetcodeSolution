// compute from the second last one to the first.


public class Solution {
    
    public int[] buf;
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 1)
            return 0;
        buf = new int[A.length];
        for(int i = 0; i < A.length - 1; i++)
            buf[i] = -1;
        for(int i = A.length - 2; i >= 0; i--){
            if(i + A[i] >= A.length - 1){
            buf[i] = 1;
            continue;
            }
            int less = Integer.MAX_VALUE;
            if(A[i] == 0){       // if it's 0, set to largest integer.
                buf[i] = less;
                continue;
            }
            for(int j = 1; j <= A[i]; j++){
                if(buf[i + j] < less){
                    less = buf[i + j];
                }
            }
            if(less == Integer.MAX_VALUE)     // keep to the largest, or if you add 1, you get -2147xxxx
                buf[i] = less;
            else
                buf[i] = less + 1;
        }
        return buf[0];
    }
   
}
