public class Solution {
    public int largestRectangleArea(int[] height) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(height.length == 0)
            return 0;
        if(height.length == 1)
            return height[0];
        int[] h = new int[height.length + 1];
        for(int i = 0; i < height.length; i++)
            h[i] = height[i];
        Stack<Integer> si = new Stack<Integer>();
        
        int maxi = 0;
        int i = 0;
        while(i < h.length){
            if(si.isEmpty()){
                si.push(i++);
                continue;
            }
            if(h[i] >= h[si.peek()])
                si.push(i++);
            else{
                int temp = si.pop();
                maxi = Math.max(maxi, h[temp] * (si.isEmpty() ? i : i - si.peek() - 1));
            }
        }
        return maxi;
    }
}