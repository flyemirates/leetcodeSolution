public class Solution {
    public int maxProfit(int[] prices) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int maxi = 0;
        int small = prices[0];
        int big = small;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > big){
                big = prices[i];
                continue;
            }
            if(prices[i] < small){
                maxi = Math.max(maxi, big - small);
                small = prices[i];
                big = small;
            }
        }
        maxi = Math.max(maxi, big - small);
        return maxi;
    }
}