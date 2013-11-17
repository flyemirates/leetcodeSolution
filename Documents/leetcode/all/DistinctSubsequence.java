public class Solution {
    public int numDistinct(String S, String T) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(T.length() == 0)
            return 1;
        if(S.length() < T.length())
            return 0;
        int start = 0;
        for(; start < S.length(); start++){
            if(S.charAt(start) == T.charAt(0))
                break;
        }
        int end = start;
        if(end == S.length())
            return 0;
        while(end < S.length() && S.charAt(end) == T.charAt(0))
            end++;
        int suma = end - start;
        int p = 0;
        while(p < T.length() && T.charAt(p) == T.charAt(0))
            p++;
        int sumt = p;
        int cur = helper(suma, sumt);
        int res = cur * numDistinct(S.substring(end), T) + cur * numDistinct(S.substring(end), T.substring(p));
        return res;
    }
    public int helper(int a, int c){
        int result = 1;
        for(int i = a; i > c; i--)
            result = result * i;
        result = result / factorial(a - c);
        return result;
            
    }
    public int factorial(int a){
        int result = 1;
        for(int i = 1; i <= a; i++)
        {
            result = result * i;
        }
        return result;
    }
}