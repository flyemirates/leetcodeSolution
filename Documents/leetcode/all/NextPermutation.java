public class Solution {
    public void nextPermutation(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(num.length < 2)
            return;
        
        int big = num.length - 1;
        for(; big > 0; big--){
            if(num[big] > num[big - 1])
                break;
        }
        
        
        if(big > 0){
            int crit = num[big - 1];
            int small = num.length - 1;
            for(; small >= big; small--){
                if(num[small] > crit){
                    int temp = num[small];
                    num[small] = num[big - 1];
                    num[big - 1] = temp;
                    break;
                }
            }
        }
        
        for(int i = big, j = num.length - 1; i < j; i++, j--){
            int temp = num[j];
            num[j] = num[i];
            num[i] = temp;
        }
        
    }
}