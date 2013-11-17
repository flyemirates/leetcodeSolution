public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0 || s.length() == 1)
            return true;
        for(int i = 0, j = s.length() - 1; i < j;){
            char start = s.charAt(i);
        	if(!checkalpanumeric(start)){
        		i++;
        		continue;
        	}
        	char end = s.charAt(j);
        	if(!checkalpanumeric(end)){
        		j--;
        		continue;
        	}
        	if(pair(start, end)){
        		i++;
        		j--;
        	}
        	else
        		return false;
        }
        return true;
    }
  
    public boolean pair(char a, char b){
    	return (a == b) || (Math.abs(a - b) == 32);
    }
    public boolean checkalpanumeric(char a){
    	return (a >= 'a' && a <= 'z') || (a >= '0' && a <= '9') || (a >= 'A' && a <= 'Z');
    }
}