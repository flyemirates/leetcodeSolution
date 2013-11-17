public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0)
            return 1.0;
        if(x == 0 || x == 1)
            return x;
        if(x == -1.0){
            if(n % 2 == 0)
                return 1.0;
            else
                return -1.0;
        }
        if(n < 0)
        	return 1 / pow(x, 0 - n);
        if(n == 1)
        	return x;
        if(n % 2 == 0){
        	double half = pow(x, n / 2);
        	return half * half;
        }
        else{
        	double half = pow(x, n / 2);
        	return half * half * x;
        }
    }
}