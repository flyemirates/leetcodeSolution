public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int start=0, end=height.length-1, res=0;
        while(start<end){
            int min = Math.min(height[start],height[end]);
            res=Math.max(res,(end-start)*min);
            if(height[start]<height[end]){
                while(start<end && height[start]<=min) start++;
            }else if(height[start]>height[end]){
                  while(start<end && height[end]<=min) end--;
            }else{
                  while(start<end && height[start]<=min) start++;
                  while(start<end && height[end]<=min) end--;
            }
        }
        return res;
    }
}