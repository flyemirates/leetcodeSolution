public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length == 0)
            return 0;
        int max = 1;
        HashMap<Integer, Interval> result = new HashMap<Integer, Interval>();
        for(int i = 0; i < num.length; i++){
            
            int current = num[i];
            if(result.containsKey(current))
                continue;
            Interval self = new Interval(current, current);
            
            if(result.containsKey(current - 1)){
                Interval low = result.get(current - 1);
                self.lower = low.lower;
            }
            if(result.containsKey(current + 1)){
                Interval high = result.get(current + 1);
                self.upper = high.upper;
            }
            
                result.put(self.lower, new Interval(self.lower, self.upper));
            
            
                result.put(self.upper, new Interval(self.lower, self.upper));
            
            if(self.upper - self.lower + 1 > max)
                max = self.upper - self.lower + 1;
            result.put(current, self);

        }
        return max;
    }
}
class Interval{
    int lower;
    int upper;
    Interval(int l, int u){
        this.lower = l;
        this.upper = u;
    }
}


////////////////////////////////////////////
public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 1;
        
        Map<Integer, Interval> map = new HashMap<Integer, Interval>();
        
        for(int i:num){
            if(!map.containsKey(i)){
                Interval interval = new Interval();
                if(map.containsKey(i+1)) interval.upperBound = map.get(i+1).
upperBound;
                else interval.upperBound = i;
                if(map.containsKey(i-1)) interval.lowerBound = map.get(i-1).
lowerBound;
                else interval.lowerBound = i;
                
                map.put(i,interval);
                
                //here is the critical part
                map.get(interval.upperBound).lowerBound = interval.
lowerBound;
                map.get(interval.lowerBound).upperBound = interval.
upperBound;
                
                
                if(interval.upperBound - interval.lowerBound+1 > max) max = 
interval.upperBound - interval.lowerBound+1;
            }
        }
        
        return max;
    }
}

class Interval{
    int upperBound;
    int lowerBound;
}