public class Solution {
    public String getPermutation(int n, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> all = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++)
        	all.add(i);
        String res = "";
        while(all.size() > 0){
        	int num = factorial(all.size() - 1);
        	int cur = all.remove((k - 1) / num);   // what you need to do with k
        	k = k - num * ((k - 1) / num);
        	res = res + cur;
        }
        return res;
    }
    public int factorial(int k){
    	int count = 1;
    	for(int i = 2; i <= k; i++)
    		count = count * i;
    	return count;
    }
}