public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(nRows == 1)
        	return s;
        String result = "";
        int time = nRows + nRows - 2;
        for(int i = 0; i < s.length(); i = i + time)
        	result = result + s.charAt(i);
        for(int p = 1; p < nRows - 1; p++)
        	for(int i = p, j = time - p; i < s.length(); ){
        		result = result + s.charAt(i);
        		if(j < s.length())
        			result = result + s.charAt(j);
        		i = i + time;
        		j = j + time;
        	}
        for(int i = nRows - 1; i < s.length(); i = i + time)
        	result = result + s.charAt(i);
        return result;
    }
}