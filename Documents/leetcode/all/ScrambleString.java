public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s1.equals(s2))
            return true;
        int len = s1.length();
        if(len == 1)
            return false;
        // rotate itself
        
        for(int i = 1; i < s1.length(); i++){
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            if(isScramble(s11, s21) && isScramble(s12, s22))
                return true;
            
            s21 = s2.substring(0, s2.length() - i);
            s22 = s2.substring(s2.length() - i);
            if(isScramble(s11, s22) && isScramble(s12, s21))
                return true;
            
        }
        return false;
            
        
    }
}