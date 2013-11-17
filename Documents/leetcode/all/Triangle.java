
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int result = helper(triangle, 0, 0);
        return result;
    }
    public int helper(ArrayList<ArrayList<Integer>> triangle, int level, int col){
    	if(level == triangle.size())
    		return 0;
    	int cur = triangle.get(level).get(col);
    	int leftchild = helper(triangle, level + 1, col);
    	int rightchild = helper(triangle, level + 1, col + 1);
    	return (leftchild < rightchild) ? (leftchild + cur) : (rightchild + cur);

    }
}