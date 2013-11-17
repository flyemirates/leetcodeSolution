// may have repeating results
// get rid of those


public class Solution {
    public ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<ArrayList<Integer>>();
        if(num.length == 0)
        	return result;
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++){        // start from each number
        	if(i != 0 && num[i] == num[i - 1])
                continue;
        	ArrayList<Integer> temp = new ArrayList<Integer>();
        	temp.add(num[i]);
        	helper(num, i + 1, target - num[i], temp);
        }
        return result;
    }
    public void helper(int[] num, int current, int target, ArrayList<Integer> temp){
    	if(target == 0 && temp.size() > 0){
    		result.add(temp);
    		return;
    	}
    	if(current == num.length)
    		return;
    	if(num[current] > target)
    		return;
    	int i = current + 1;
    	while(i < num.length && num[i] == num[i - 1])    // get rid of repeating numbers
    		i++;
    	if(i != num.length){
    		ArrayList<Integer> copy = (ArrayList<Integer>) temp.clone();
    		helper(num, i, target, copy);
    	}
    	temp.add(num[current]);
    	helper(num, current + 1, target - num[current], temp);
    }
}


//////


public class Solution {
   ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        helper(num, 0, target, new ArrayList<Integer>());
        return result;
    }
    public void helper(int[] num, int pos, int balance, ArrayList<Integer> temp){
        if(balance == 0){
            result.add(temp);
            return;
        }
        if(pos == num.length)
            return;
        
        if(num[pos] > balance)
            return;
        for(int i = pos; i < num.length; i++){
            if(i > pos && num[i] == num[i - 1])    // i > pos could get rid of repeating
                continue;
            if(num[i] > balance)
                continue;
            ArrayList<Integer> copy = (ArrayList<Integer>) temp.clone();
            copy.add(num[i]);
            helper(num, i + 1, balance - num[i], copy);
        }
    }
    
}