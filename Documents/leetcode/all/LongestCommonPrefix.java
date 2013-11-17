public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(strs.length == 0)
        	return "";
        String result = strs[0];
        for(int i = 1; i < strs.length; i++)
        	result = common(result, strs[i]);
        return result;
    }
    public String common(String a, String b){
    	int end = 0;
    	if(a.length() == 0 || b.length() == 0)
    		return "";
    	for(; end < a.length() && end < b.length(); end++){
    		if(a.charAt(end) != b.charAt(end))
    			break;
    	}
    	return a.substring(0, end);
    }
}