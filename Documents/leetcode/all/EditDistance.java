public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 == 0)
        	return len2;
        if(len2 == 0)
        	return len1;
        int[][] buffer = new int[len1 + 1][len2 + 1];
        for(int i = 0; i < len2 + 1; i++)   // init from 0 to length;
        	buffer[0][i] = i;
        for(int i = 0; i < len1 + 1; i++)
        	buffer[i][0] = i;
        for(int i = 1; i < len1 + 1; i++){
        	for(int j = 1; j < len2 + 1; j++){
        		char left = word1.charAt(i - 1);
        		char up = word2.charAt(j - 1);
        		if(left == up){
        			buffer[i][j] = buffer[i - 1][j - 1]; //equal, no operation requird
        		}
        		else{
        			int small = least(buffer[i - 1][j - 1], buffer[i][j - 1], buffer[i - 1][j]);
        						//    substitution,          an insertion,     a deletion
        			buffer[i][j] = small + 1;
        		}
        	}
        }
        return buffer[len1][len2];
    }
    public int least(int a, int b, int c){
    	if(a > b){
    		if(c > b)
    			return b;
    		else
    			return c;
    	}
    	else{
    		if(c > a)
    			return a;
    		else
    			return c;
    	}
    }
}