public class Solution {
    
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] result = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++){//Pay attention to duplicates keys
            if(!hm.containsKey(numbers[i]))
                hm.put(numbers[i], i);
            else{
                if(numbers[i] == target / 2){
                    result[0] = hm.get(numbers[i]);
                    result[1] = i;
                    result[0] = result[0] + 1;
                    result[1] = result[1] + 1;
                    return result;
                }
                
            }
        }
        for(int k : hm.keySet()){
            if(hm.containsKey(target - k)){
                result[0] = hm.get(k);
                result[1] = hm.get(target - k);
                break;
            }
        }
        if(result[0] > result[1]){
            int temp = result[0];
            result[0] = result[1];
            result[1] = temp;
        }
        result[0] = result[0] + 1;
        result[1] = result[1] + 1;
        return result;
    }
}