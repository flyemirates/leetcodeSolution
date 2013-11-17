// go from back to forth
// at each node, check from the last one. Save much time!!!

public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 0)
            return false;
        if(A.length == 1)
        	return true;
        boolean[] buf = new boolean[A.length];
        buf[A.length - 1] = true;
        for(int i = A.length - 2; i >= 0; i--){
        	if(i + A[i] >= A.length - 1)
        		buf[i] = true;
        	else{
        		for(int j = i + A[i]; j > i; j--){  // go from the last one. save too much time!!!
        			if(buf[j]){
        				buf[i] = true;
        				break;
        			}
        		}
        		// it is already false, no need to set it
        	}
        }
        return buf[0];
    }
}