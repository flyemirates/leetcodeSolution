public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] buf = new int[32];
        for(int i = 0; i < A.length; i++){
        	for(int j = 0; j < 32; j++){
        		if((A[i] & (1 << j)) != 0)
        			buf[j] = buf[j] + 1;
        	}
        }
        for(int i = 0; i < 32; i++)
        	buf[i] = buf[i] % 3;
        int result = 0;
        for(int i = 0; i < 32; i++)
    		if(buf[i] == 1)
    			result = result + (1 << i);
    	return result;
    }
}