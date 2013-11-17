public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x == 0 || x == 1)
            return x;
        return helper(x, 1.0, x, 0.001);
    }
    public int helper(int target, double start, double end, double diff){
        double mid = (start + end) / 2;
        if((mid*mid - target) > 0 && (mid * mid - target) < diff)
            return (int)mid;
        if(mid * mid > target)
            return helper(target, start, mid, diff);
        else
            return helper(target, mid, end, diff);
    }
}