public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1.length() == 0 && s2.length() == 0) 
            return s3.length() == 0;
        if(s1.length() == 0)
            return s2.equals(s3);
        if(s2.length() == 0)
            return s1.equals(s3);
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 + len2 != s3.length())
            return false;
        boolean[][] buffer = new boolean[len1 + 1][len2 + 1];
        buffer[0][0] = true;
        for(int j = 1; j < len2 + 1; j++){
            if(s2.charAt(j - 1) == s3.charAt(j - 1))
                buffer[0][j] = true;
        }
        for(int i = 1; i < len1 + 1; i++){
            if(s1.charAt(i - 1) == s3.charAt(i - 1))
                buffer[i][0] = true;
        }
        for(int i = 1; i < len1 + 1; i++){
            for(int j = 1; j < len2 + 1; j++){
                if(!buffer[i - 1][j] && !buffer[i][j - 1])
                {
                    buffer[i][j] = false;
                    continue;
                }
                if(buffer[i - 1][j]){
                    if(s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        buffer[i][j] = true;
                }
                if(buffer[i][j - 1]){
                    if(s2.charAt(j - 1) == s3.charAt(i + j - 1))
                        buffer[i][j] = true;
                }

            }
        }
        return buffer[len1][len2];
    }
}