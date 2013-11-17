public class Solution {
     public String strStr(String haystack, String needle) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(needle == "")
            return haystack;
        if(haystack == null || haystack.length() == 0)
            return null;
        for(int i = 0; i + needle.length() <= haystack.length(); i++ ){
            if(haystack.substring(i, i + needle.length()).equals(needle))
                return haystack.substring(i);
        }
        return null;
    }
}