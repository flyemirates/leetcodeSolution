public class Solution {
    public int maxProfit(int[] prices) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int profit = 0;
        int base = prices[0];
        int temp = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i - 1])
                temp = prices[i] - base;
            else{
                profit += temp;
                temp = 0;
                base = prices[i];
            }
        }
        return profit;
    }
}