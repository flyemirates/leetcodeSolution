
// ask if negative number is true or not.
// Math.pow returns DOUBLE


public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x < 0)
            return false;
        if(x < 10)
            return true;
        int digits = 0;
        int temp = x;
        while(temp > 0){
            digits++;
            temp = temp / 10;
        }
        for(int i = 0, j = digits - 1; i < j; i++, j--){
            int pi = (x / (int)Math.pow(10, i)) % 10;
            int pj = (x / (int)Math.pow(10, j)) % 10;
            if(pi != pj)
                return false;
        }
        return true;
    }
}