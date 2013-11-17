public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length < 2)
        	return A.length;
        int i = 0;
        int len = A.length;
        for(; i < len; i++){
        	int next = i;
        	while(A[next] == A[i]){
        		next++;
        		if(next == len)
        			return i + 1;
        	}
        	int diff = next - i - 1;
        	
        	for(int j = next; j < len; j++)
        		A[j - diff] = A[j];
        	len = len - diff;
        }
        return i + 1;
    }
}