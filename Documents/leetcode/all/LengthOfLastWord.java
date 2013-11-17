// there might be ' ' at the end of s

public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int start = s.length() - 1;
        for(; start >= 0; start--){
            if(s.charAt(start) != ' ')
                break;
        }
        int end = start;
        for(; end >= 0; end--){
            if(s.charAt(end) == ' ')
                break;
        }
        return start - end;
    }
}