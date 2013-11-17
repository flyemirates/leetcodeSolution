public class Solution {
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0)
            return result;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        result.add(temp);
        numRows--;
    	while(numRows > 0){
    		ArrayList<Integer> next = new ArrayList<Integer>();
    		next.add(1);
    		for(int i = 1; i < temp.size(); i++)
    		{
    			int sum = temp.get(i - 1) + temp.get(i);
    			next.add(sum);
    		}
    		next.add(1);
    		result.add(next);
    		temp = next;
    		numRows--;
    	}
    	return result;
    }
 
}